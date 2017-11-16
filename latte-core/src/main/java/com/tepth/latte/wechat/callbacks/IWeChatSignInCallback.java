package com.tepth.latte.wechat.callbacks;

/**
 * Description:微信登录后回调接口
 *
 * @author Hequn.Lee
 * @date 2017/11/9
 */

public interface IWeChatSignInCallback {
    /**
     * 微信登陆成功后回调
     *
     * @param userInfo 微信用户信息
     */
    void onSignInSuccess(String userInfo);
}
