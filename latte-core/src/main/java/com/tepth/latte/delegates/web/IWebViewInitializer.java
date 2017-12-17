package com.tepth.latte.delegates.web;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Description:初始化WebView的接口类
 *
 * @author Hequn.Lee
 * @date 2017/12/7
 */

public interface IWebViewInitializer {

    /**
     * 初始化WebView
     *
     * @param webView 要初始化的WebView
     * @return WebView
     */
    WebView initWebView(WebView webView);

    /**
     * 初始化WebViewClient
     *
     * @return WebViewClient
     */
    WebViewClient initWebViewClient();

    /**
     * 初始化WebChromeClient
     *
     * @return WebChromeClient
     */
    WebChromeClient initWebChromeClient();
}
