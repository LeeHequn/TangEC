package com.tepth.latte.delegates.web.chromeclient;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Description:WebChromeClient实现类
 *
 * @author Hequn.Lee
 * @date 2017/12/13
 */

@SuppressWarnings("ALL")
public class WebChromeClientImpl extends WebChromeClient {

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return super.onJsAlert(view, url, message, result);
    }
}
