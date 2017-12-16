package com.tepth.latte.delegates.web.client;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tepth.latte.delegates.web.BaseWebDelegate;
import com.tepth.latte.delegates.web.route.Router;
import com.tepth.latte.utils.log.LatteLogger;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/12/7
 */

@SuppressWarnings("ALL")
public class WebViewClientImpl extends WebViewClient {

    private final BaseWebDelegate DELEGATE;

    public WebViewClientImpl(BaseWebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handlerWebUrl(DELEGATE, url);
    }
}
