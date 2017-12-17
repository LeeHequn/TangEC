package com.tepth.latte.delegates.web.client;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tepth.latte.app.ConfigType;
import com.tepth.latte.app.Latte;
import com.tepth.latte.delegates.web.BaseWebDelegate;
import com.tepth.latte.delegates.web.IPageLoadListener;
import com.tepth.latte.delegates.web.route.Router;
import com.tepth.latte.ui.loader.LatteLoader;
import com.tepth.latte.utils.log.LatteLogger;
import com.tepth.latte.utils.storage.LattePreference;

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
        syncCookie();
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

    /**
     * 获取并同步浏览器的Cookie
     */
    private void syncCookie() {
        final CookieManager manager = CookieManager.getInstance();
        //注意，这里的Cookie和API请求的Cookie是不一样的，这个在网页中不可见
        final String webHost = Latte.getConfiguration(ConfigType.WEB_HOST);
        if (webHost != null && manager.hasCookies()) {
            final String cookieStr = manager.getCookie(webHost);
            if (cookieStr != null && "".equals(cookieStr)) {
                LattePreference.addCustomAppProfile("cookie", cookieStr);
            }
        }

    }
}
