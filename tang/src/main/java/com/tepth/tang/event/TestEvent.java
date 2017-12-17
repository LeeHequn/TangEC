package com.tepth.tang.event;

import android.os.Build;
import android.webkit.WebView;
import android.widget.Toast;

import com.tepth.latte.delegates.web.event.BaseEvent;

/**
 * Description:执行Web和原生交互的测试类
 *
 * @author Hequn.Lee
 * @date 2017/12/15
 */

public class TestEvent extends BaseEvent {

    public static final String EVENT_NAME = "test";

    @Override
    public String execute(String params) {
        //Web调用原生
        Toast.makeText(getContext(), getAction(), Toast.LENGTH_SHORT).show();
        //原生调用Web
        if (EVENT_NAME.equals(getAction())) {
            final WebView webView = getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        webView.evaluateJavascript("nativeCall();", null);
                    }
                }
            });
        }
        return null;
    }
}
