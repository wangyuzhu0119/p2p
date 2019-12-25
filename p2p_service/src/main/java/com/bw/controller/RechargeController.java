package com.bw.controller;

import com.bw.entity.Account;
import com.bw.entity.RechargeRecord;
import com.bw.service.RechargeService;
import com.bw.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/recharge")
public class RechargeController {

    @Autowired
    RechargeService rechargeService;


    //线上充值
    @RequestMapping("/onlineRecharge")
    public Boolean onlineRecharge(@RequestBody RechargeRecord rechargeRecord){
        Date downOrderTime = new Date();
        rechargeRecord.setDownOrderTime(downOrderTime);
        System.out.print("▄▄▄▄▄▄▄------▄▄▄▄▄▄▄"+rechargeRecord);
        try{
            if(!(rechargeRecord.getPayMoney().equals(BigDecimal.ZERO))){
                rechargeService.onlineRecharge(rechargeRecord);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    //获取未审核的充值信息
    @RequestMapping("/doloadRechargeList")
    public List<RechargeRecord> doloadRechargeList(){
        List<RechargeRecord> list = rechargeService.doloadRechargeList();
        System.out.println("----------"+list);
        return  list;
    }


    //支付密码
    @RequestMapping("/checkPayPassword")
    public Boolean checkPayPassword(String payPassword,Integer id){
        System.out.println("●●●●●●●●●"+payPassword);
        System.out.println("●●●●●●●●●"+id);
        try {
            //数据库查询密码
            Account account = rechargeService.getAccountbyId(id);
            String password = account.getTradePassword();
            if(Md5Utils.md5(payPassword).equals(password)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @RequestMapping("/rechargeResult")
    public Boolean rechargeResult(Integer auditUserId , Integer auditStatue ,String auditComment , Integer payId){
        //获取当前充值的记录
        RechargeRecord rechargeRecord = rechargeService.loadRechargeByPayId(payId);
        try{
            Date auditTime = new Date();
            //审核结果
            rechargeService.updateRechargeResult(auditUserId,auditStatue,auditComment,auditTime,payId);
            if(auditStatue == 1){
                Integer id = rechargeRecord.getCreateUserId();
                Account account = rechargeService.getAccountBypayId(id);
                //获取充值用户的可用余额
                BigDecimal ac = account.getAccoubtAvbalance();
                //充值金额加上可用余额
                BigDecimal newAc = ac.add(rechargeRecord.getPayMoney());
                //若充值通过 充值用户的可用余额增加
                rechargeService.addAccoubtAvbalanceBypayId(id,newAc);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    //线下充值
    @RequestMapping("/offlineRecharge")
    public Boolean offlineRecharge(@RequestBody RechargeRecord rechargeRecord){
        try {
            rechargeService.offlineRecharge(rechargeRecord);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //获取线下充值未审核的信息
    @RequestMapping("/dolaodOffRechaargeList")
    public List<RechargeRecord> dolaodOffRechaargeList(){
        List<RechargeRecord> list = rechargeService.dolaodOffRechaargeList();
        return list;
    }


    //审核线下充值的流水单号
    @RequestMapping("/checkRechargeNumbers")
    public Boolean checkOffRechargeNumber(String offRechargeNumber,Integer id){
        RechargeRecord rechargeRecord = rechargeService.checkOffRechargeNumber(id);
        String a = rechargeRecord.getTradeCode();
        try {
            if(offRechargeNumber.equals(a)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //线下充值审核
    @RequestMapping("/updateOffRecharge")
    public Boolean updateOffRecharge(Integer auditStatue, String auditComment,Integer id){
        RechargeRecord rechargeRecord = rechargeService.checkOffRechargeNumber(id);
        Integer userid = rechargeRecord.getCreateUserId();
        Account account = rechargeService.getAccountbyId(userid);
        BigDecimal newAV = account.getAccoubtAvbalance();
        BigDecimal newOffAv = rechargeRecord.getPayMoney().add(newAV);
        try {
            if(auditStatue.equals(1)){
                Date newAuditTime = new Date();
                rechargeService.updateOffRecharge(auditStatue,auditComment,id,newAuditTime);
                //修改账户可用金额
                rechargeService.updateAVByUserId(newOffAv,userid);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
