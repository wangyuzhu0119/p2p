package com.bw.utils;

public interface LoanConst {

    public static final int RETURN_TYPE_MONTH_AMOUT = 0;
    public static final int RETURN_TYPE_MONTH_INTEREST = 1;
    public static final int RETURN_TYPE_MONTH_PRINCIPAL = 2;

    //月利率 精确到小数点后的2位数
    public static final int SCALE_DISPLAY = 2;
    public static final int SCALE_STORE = 4;
    public static final int SCALE_COMPUTER = 8;
}
