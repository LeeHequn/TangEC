package com.tepth.latte.net.callback;

/**
 * 网络请求成功回调
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

public interface ISuccess {
    /**
     * 网络请求成功回调
     *
     * @param response 回调字符串
     */
    void onSuccess(String response);
}
