package com.tepth.latte.net.callback;

/**
 * 网络请求错误回调
 * Created by Hequn.Lee on 2017/10/9.
 */

public interface IError {
    void onError(int code, String msg);
}
