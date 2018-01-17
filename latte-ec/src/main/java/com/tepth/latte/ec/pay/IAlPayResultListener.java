package com.tepth.latte.ec.pay;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/1/16
 */

public interface IAlPayResultListener {

    /**
     * 支付成功
     */
    void onPaySuccess();

    /**
     * 支付中
     */
    void onPaying();

    /**
     * 支付失败
     */
    void onPayFail();

    /**
     * 支付取消
     */
    void onPayCancel();

    /**
     * 支付连接错误
     */
    void onPayConnectError();
}
