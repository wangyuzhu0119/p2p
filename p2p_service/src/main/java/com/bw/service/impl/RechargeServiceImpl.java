package com.bw.service.impl;

import com.bw.entity.Account;
import com.bw.entity.RechargeRecord;
import com.bw.mapper.RechargeMapper;
import com.bw.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    RechargeMapper rechargeMapper;

    //线上充值
    @Override
    public Boolean onlineRecharge(RechargeRecord rechargeRecord) {
        return rechargeMapper.onlineRecharge(rechargeRecord);
    }

    //获取未审核的充值列表
    @Override
    public List<RechargeRecord> doloadRechargeList() {
        return rechargeMapper.doloadRechargeList();
    }


    //查询交易密码
    @Override
    public Account getAccountbyId(Integer userid) {
        return rechargeMapper.getAccountbyId(userid);
    }

    //获取当前充值信息的记录
    @Override
    public RechargeRecord loadRechargeByPayId(Integer payId) {
        return rechargeMapper.loadRechargeByPayId(payId);
    }


    @Override
    public void updateRechargeResult(Integer auditUserId, Integer auditStatue, String auditComment, Date auditTime, Integer payId) {
        rechargeMapper.updateRechargeResult(auditUserId, auditStatue, auditComment, auditTime, payId);
    }


    //获取充值用户的可用余额
    @Override
    public Account getAccountBypayId(Integer id) {
        return rechargeMapper.getAccountBypayId(id);
    }

    //若充值通过,充值用户的可用余额增加
    @Override
    public void addAccoubtAvbalanceBypayId(Integer id, BigDecimal newAc) {
        rechargeMapper.addAccoubtAvbalanceBypayId(id,newAc);
    }

    //线下充值
    @Override
    public void offlineRecharge(RechargeRecord rechargeRecord) {
        rechargeMapper.offlineRecharge(rechargeRecord);
    }

    //线下充值未审核的信息
    @Override
    public List<RechargeRecord> dolaodOffRechaargeList() {
        return rechargeMapper.dolaodOffRechaargeList();
    }

    //线下充值未审核的信息 - 流水单号对账
    @Override
    public RechargeRecord checkOffRechargeNumber(Integer id) {
        return rechargeMapper.checkOffRechargeNumber(id);
    }



    //线下充值审核
    @Override
    public void updateOffRecharge(Integer auditStatue, String auditComment, Integer id, Date newAuditTime) {
        rechargeMapper.updateOffRecharge(auditStatue, auditComment, id, newAuditTime);
    }

    //线下充值 修改可用金额
    @Override
    public void updateAVByUserId(BigDecimal newOffAv, Integer userid) {
        rechargeMapper.updateAVByUserId(newOffAv,userid);
    }
}
