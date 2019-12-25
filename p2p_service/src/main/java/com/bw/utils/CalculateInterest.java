package com.bw.utils;

import org.springframework.stereotype.Component;
import sun.plugin.com.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CalculateInterest {

//    borrowAmount 借款总金额
//    yearRate 年化利率
//    returnMonthNum 还款期数/月
//    returnType 还款方式  0-等额本息   1-按月到期  2-等额本金
    //计算总利息
    public static BigDecimal calculateInterest(BigDecimal borrowAmount,
                                               BigDecimal yearRate,
                                               int returnMonthNum,
                                               int returnType){

        //定义 总利息 为 0
        BigDecimal totalInterest = BigDecimal.ZERO ;
        //计算月利率
        BigDecimal monthRate = yearRate.divide(new BigDecimal(100)).divide(new BigDecimal(12),LoanConst.SCALE_COMPUTER , BigDecimal.ROUND_HALF_UP);

        switch (returnType){
            //等额本息
            case LoanConst.RETURN_TYPE_MONTH_AMOUT :
                BigDecimal tmp1 = borrowAmount.multiply(monthRate);
                BigDecimal tmp2 = monthRate.add(BigDecimal.ONE).pow(returnMonthNum);
                BigDecimal tmp3 = tmp2.subtract(BigDecimal.ONE);
                //每月还款的钱
                BigDecimal monthAmount = tmp1.multiply(tmp2).divide(tmp3,LoanConst.SCALE_COMPUTER , BigDecimal.ROUND_HALF_UP);
                //总利息
                totalInterest = monthAmount.multiply(new BigDecimal(returnMonthNum)).subtract(borrowAmount);
                break;
             //按月到期
             case LoanConst.RETURN_TYPE_MONTH_INTEREST :
                 //月利息
                 BigDecimal monthInterest = borrowAmount.multiply(monthRate);
                 //总利息
                 totalInterest = monthInterest.multiply(new BigDecimal(returnMonthNum)).setScale(LoanConst.SCALE_STORE);
                break;
              //等额本金
              case LoanConst.RETURN_TYPE_MONTH_PRINCIPAL :
                  totalInterest = new BigDecimal(returnMonthNum+1).multiply(borrowAmount).multiply(monthRate).divide(new BigDecimal(2));
                break;
        }
        System.out.print("calculateInterest->->"+totalInterest);
        return totalInterest;
    }

    public static void main(String[] args) {
        //BigDecimal totalInterest = CalculateInterest.CalculateInterest(new BigDecimal(120000),new BigDecimal(6),12,0);
        BigDecimal total = CalculateInterest.calculateInterest(new BigDecimal(50001),new BigDecimal(6),6,0);
        System.out.print(total);
    }
}
