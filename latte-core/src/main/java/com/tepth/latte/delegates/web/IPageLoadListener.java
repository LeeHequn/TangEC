package com.tepth.latte.delegates.web;

/**
 * Description:Web页面加载开始和结束的接口回调
 *
 * @author Hequn.Lee
 * @date 2017/12/17
 */

public interface IPageLoadListener {

    /**
     * Web页面加载开始时调用
     */
    void onLoadStart();

    /**
     * Web页面加载结束时调用
     */
    void onLoadEnd();
}
