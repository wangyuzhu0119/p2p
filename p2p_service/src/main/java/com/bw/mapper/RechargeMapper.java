package com.bw.mapper;

import com.bw.entity.Account;
import com.bw.entity.RechargeRecord;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
public interface RechargeMapper {

    //线上充值
    Boolean onlineRecharge(RechargeRecord rechargeRecord);

    //获取未审核的充值列表
    List<RechargeRecord> doloadRechargeList();

    //查询交易密码
    Account getAccountbyId(Integer userid);

    //获取当前审核充值信息的记录
    RechargeRecord loadRechargeByPayId(Integer payId);

    //审核结果
    void updateRechargeResult(Integer auditUserId, Integer auditStatue, String auditComment, Date auditTime, Integer payId);

    //获取充值人的可用余额
    Account getAccountBypayId(Integer id);

    //若充值通过,充值用户的可用余额增加
    void addAccoubtAvbalanceBypayId(Integer id, BigDecimal newAc);

    //线下充值
    void offlineRecharge(RechargeRecord rechargeRecord);

    //线下充值未审核的信息
    List<RechargeRecord> dolaodOffRechaargeList();

    //线下充值未审核的信息 - 流水单号对账
    RechargeRecord checkOffRechargeNumber(Integer id);

    //线下充值审核
    void updateOffRecharge(Integer auditStatue, String auditComment, Integer id, Date newAuditTime);

    //线下充值 修改可用金额
    void updateAVByUserId(BigDecimal newOffAv, Integer userid);


}
