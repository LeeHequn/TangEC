package com.tepth.latte.delegates.web.event;

import android.content.Context;
import android.webkit.WebView;

import com.tepth.latte.delegates.LatteDelegate;
import com.tepth.latte.delegates.web.BaseWebDelegate;

/**
 * Description:Web和原生交互的基类
 *
 * @author Hequn.Lee
 * @date 2017/12/13
 */

@SuppressWarnings("ALL")
public abstract class BaseEvent implements IEvent {

    private Context mContext = null;
    private String mAction = null;
    private BaseWebDelegate mDelegate = null;
    private String mUrl = null;
//    private WebView mWebView = null;

    public Context getContext() {
        return mContext;
    }

    public WebView getWebView() {
        return mDelegate.getWebView();
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        mAction = action;
    }

    public LatteDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(BaseWebDelegate delegate) {
        mDelegate = delegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
