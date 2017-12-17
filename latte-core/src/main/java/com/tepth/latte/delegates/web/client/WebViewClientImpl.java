package com.tepth.latte.delegates.web.client;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tepth.latte.delegates.web.BaseWebDelegate;
import com.tepth.latte.delegates.web.IPageLoadListener;
import com.tepth.latte.delegates.web.route.Router;
import com.tepth.latte.ui.loader.LatteLoader;
import com.tepth.latte.utils.log.LatteLogger;

/**
 * Description:WebViewClient实现类
 *
 * @author Hequn.Lee
 * @date 2017/12/7
 */

@SuppressWarnings("ALL")
public class WebViewClientImpl extends WebViewClient {

    private final BaseWebDelegate DELEGATE;
    private IPageLoadListener mIPageLoadListener = null;
    private static final Handler HANDLER = new Handler();

    public void setPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }

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

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadEnd();
        }
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                LatteLoader.closeLoading();
            }
        }, 1000);
    }
}
