package com.bw.controller;

import com.bw.entity.Account;
import com.bw.entity.BidRecord;
import com.bw.entity.LoanMark;
import com.bw.entity.ReturnPlan;
import com.bw.service.BidFullscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/full")
public class BidFullscaleController {

    //1、展示t_loan_mark中满标状态status=2的所有信息
    //2、审核
    //3、审核成功后，向满标审核表t_borrow_audit_record插入审核记录
    //4、满标状态修改为还款中状态 status=3
    //5、用户可用余额增加  待还本息增加  添加动账记录
    //6、出借人 待收本金增加   待收本息增加  冻结金额减少  添加动账记录
    //7、根据借款期数 循环添加还款计划
    //8、根据借款期数+投标人数 循环添加回款计划

    @Autowired
    BidFullscaleService bidFullscaleService;

    //满标列表
    @RequestMapping("/fullscaleList")
    public List<LoanMark> fullscaleList(){
        List<LoanMark> list = bidFullscaleService.fullscaleList();
        return list;
    }

    //满标审核不予通过
    @RequestMapping("/checkFail")
    public Boolean checkFail(Integer checkid , Integer borrowSignId , String comment){
        Date checkDate = new Date();
        try {
            //满标审核不予通过
            bidFullscaleService.checkFail(borrowSignId,checkid,checkDate,comment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //满标审核通过
    @RequestMapping("/scaleCheck")
    public boolean scaleCheck(Integer checkid , Integer borrowSignId , String comment){
        //获取当前时间
        Date checkDate = new Date();
        try {
            //审核成功后，向满标审核表t_borrow_audit_record插入审核记录
            bidFullscaleService.insertScaleRecord(borrowSignId,checkid,checkDate,comment);
            //修改借款标为还款中状态 status=3
            bidFullscaleService.updateStstus(borrowSignId);
            /*
             * 放款
             */
                //获取申请人的账户信息
            LoanMark borroLloanMark = bidFullscaleService.getBorrowLoanMark(borrowSignId);
            Integer borrowUsersId = borroLloanMark.getBorrowUserId();
            Account borrowAccount = bidFullscaleService.getBorrowAccount(borrowUsersId);
            Integer borrowUserid = borrowAccount.getId();
                //用户可用余额增加  待还本息增加
            BigDecimal newAV = borroLloanMark.getBorrowMoney().add(borrowAccount.getAccoubtAvbalance());
            BigDecimal newIntamont = borroLloanMark.getInterestAmont().add(borroLloanMark.getBorrowMoney());
            bidFullscaleService.updateBorrowUserAV(newAV,newIntamont,borrowUserid);
                //借款人添加一条动账记录信息
            Date RecordDate = new Date();
            BigDecimal AccountFlowMoney = borroLloanMark.getBorrowMoney();
            bidFullscaleService.insertAccountFlow(borrowUserid,RecordDate,AccountFlowMoney,newAV);

                //出借人 待收本金增加   待收利息增加  冻结金额减少
                    //根据借款标的id查询 所有投该标的信息
            List<BidRecord> bidRecord = bidFullscaleService.getBidRecordListById(borrowSignId);
                    //循环 获取投该借款标的投标人的 id 和 投标金额
            for (BidRecord record : bidRecord) {
                Integer bidUserId = record.getBidUserId();    //获取每个出借人的 id
                BigDecimal bidMoney = record.getBidMoney();  //获取每个出借人的 投资金额
                //投资金额 除 借款总金额  得到比例   用总利息 乘 比例 得到 出借人的待收利息
                BigDecimal moneys = borroLloanMark.getBorrowMoney();   //借款人借款的总金额
                BigDecimal ratio = bidMoney.divide(moneys);  //比例
                BigDecimal bidUserIA = borroLloanMark.getInterestAmont().multiply(ratio);   //出借人的利息
                BigDecimal bidUserUI = bidMoney.add(bidUserIA);   //投资金额 +  利息 = 待收本息
                Account BidAccount = bidFullscaleService.getBidUserAccountById(bidUserId);   //冻结金额减少
                BigDecimal BidUserAF = BidAccount.getAccoubtFrobalance().subtract(bidMoney);
                //修改出借人的账户
                bidFullscaleService.updateBidUserUP(bidUserId,bidUserUI,BidUserAF,bidMoney);
                //出借人-循环添加 n条动账记录  操作金额=投资金额bidMoney    结余=冻结余额BidUserAF
                Date BidRecordDate = new Date();
                bidFullscaleService.BidUserAccountFlow(bidUserId,BidRecordDate,bidMoney,BidUserAF);
            }

            //生成还款计划 循环期数来实现
            String borrowName = borroLloanMark.getBorrowName();//借款标名称
            Integer borrowId = borroLloanMark.getBorrowSignId(); //借款标id
            Integer returnMonthes = borroLloanMark.getReturnMonthes(); //期数
            Integer borrowUserId = borroLloanMark.getBorrowUserId();  //借款人的id  还款人的id
            BigDecimal borrowMoney = borroLloanMark.getBorrowMoney(); //还款总本金
            BigDecimal returnPrincipal = borrowMoney.divide(BigDecimal.valueOf(returnMonthes)); //每期还款本金
            BigDecimal interestAmont = borroLloanMark.getInterestAmont().divide(new BigDecimal(returnMonthes));  //每期还款利息
            BigDecimal returnMoney = returnPrincipal.add(interestAmont);  //每期还款的本息

            Date returnDate = new Date(); //获取当前时间
            //for循环期数 = 第几期      循环每期的还款截止日期,从第一期开始
            for (Integer i=1;i<=returnMonthes;i++) {
                Integer returnMonthe = i;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(returnDate);
                calendar.add(Calendar.DATE,30);
                returnDate =  calendar.getTime();
                System.out.println("还款计划每期的还款截止时间:"+returnDate);
                //  循环添加还款计划
                bidFullscaleService.insertReturnPlan(borrowId , borrowName , returnMonthe , borrowUserId , returnMoney , returnPrincipal , interestAmont , returnDate);

                /*
                 * 回款  出借人数 + 还款期数  循环嵌套
                 */
                    //获取这一期的还款计划
                ReturnPlan returnPlan = bidFullscaleService.getReturnPlan(returnMonthe);
                Integer ReturnPlanid = returnPlan.getId(); //所属还款计划的id
                int BidSize = bidRecord.size();
                    //循环多个出借人  添加回款计划
                for (Integer j=1;j<=BidSize;j++){
                    BidRecord bidRecord1 = bidRecord.get(j);  //投资人的投资信息
                    BigDecimal bidMoney = bidRecord1.getBidMoney();  //出借人出借的钱
                    BigDecimal receiveInterest = bidMoney.divide(borroLloanMark.getBorrowMoney());  //出借人出借的钱占总借款的比例 利率
                    BigDecimal receivePal = returnPrincipal.multiply(receiveInterest);  //出借人每月该收到的本金
                    BigDecimal receiveAmont = interestAmont.multiply(receiveInterest);   //出借人每月该受到的利息
                    BigDecimal receiveMoney = receivePal.add(receiveAmont);    //出借人每月收到的本息
                    BigDecimal interestFee = receiveAmont.multiply(new BigDecimal(0.1));  //每月收出借人利息的10%
                    Date receiveDate = returnDate;  //计划每月的回款日      实际回款日是借款人每月实际的还款日
                    //添加回款计划
                    bidFullscaleService.insertRecordPlan(ReturnPlanid,borrowId,borrowName,returnMonthe,receiveMoney,receivePal,interestFee,borrowUserId,receiveDate);
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
