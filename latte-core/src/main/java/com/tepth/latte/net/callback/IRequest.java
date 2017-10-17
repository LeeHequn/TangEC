package com.tepth.latte.net.callback;

/**
 * 网络请求回调，包含开始和结束
 * Created by Hequn.Lee on 2017/10/9.
 */

public interface IRequest {
    void onRequestStart();

    void onRequestEnd();
}
