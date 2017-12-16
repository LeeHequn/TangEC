package com.tepth.latte.delegates.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tepth.latte.delegates.web.client.WebViewClientImpl;
import com.tepth.latte.delegates.web.event.EventManager;
import com.tepth.latte.delegates.web.event.TestEvent;
import com.tepth.latte.delegates.web.route.RouteKeys;
import com.tepth.latte.delegates.web.route.Router;

/**
 * Description:WebView的Delagate实现类
 *
 * @author Hequn.Lee
 * @date 2017/12/7
 */

public class WebDelegateImpl extends BaseWebDelegate {

    public static WebDelegateImpl create(String url) {
        final Bundle args = new Bundle();
        args.putString(RouteKeys.URL.name(), url);
        final WebDelegateImpl delegate = new WebDelegateImpl();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public Object setLayout() {
        return getWebView();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        if (getUrl() != null) {
            //用原生的方式模拟Web跳转并进行页面加载
            Router.getInstance().loadPage(this, getUrl());
        }
        EventManager.getInstance().addEvent("test", new TestEvent());
    }

    @Override
    public IWebViewInitializer setInitializer() {
        return this;
    }

    @Override
    public WebView initWebView(WebView webView) {
        return new WebViewInitializer().createWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClient() {
        return new WebViewClientImpl(this);
    }

    @Override
    public WebChromeClient initWebChromeClient() {
        return new WebChromeClient();
    }
}
