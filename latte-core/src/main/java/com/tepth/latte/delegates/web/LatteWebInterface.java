package com.tepth.latte.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.tepth.latte.delegates.web.event.BaseEvent;
import com.tepth.latte.delegates.web.event.EventManager;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/12/7
 */

public final class LatteWebInterface {

    private final BaseWebDelegate DELEGATE;

    private LatteWebInterface(BaseWebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static LatteWebInterface create(BaseWebDelegate delegate) {
        return new LatteWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        final BaseEvent event = EventManager.getInstance().createEvent(action);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }
}
