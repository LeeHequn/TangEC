package com.tepth.latte.ec.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tepth.latte.delegates.bottom.BaseBottomItemDelegate;
import com.tepth.latte.delegates.web.IPageLoadListener;
import com.tepth.latte.delegates.web.WebDelegateImpl;
import com.tepth.latte.ec.R;
import com.tepth.latte.utils.log.LatteLogger;

/**
 * Description:发现频道的Delegate
 *
 * @author Hequn.Lee
 * @date 2017/12/7
 */

public class DiscoverDelegate extends BaseBottomItemDelegate implements IPageLoadListener {
    @Override
    public Object setLayout() {
        return R.layout.delegate_discover;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final WebDelegateImpl delegate = WebDelegateImpl.create("index.html");
        delegate.setTopDelegate(this.getParentDelegate());
        delegate.setPageLoadListener(this);
        getSupportDelegate().loadRootFragment(R.id.web_discovery_container, delegate);
    }

    @Override
    public void onLoadStart() {
        LatteLogger.i("WebView", "Start loading page!");
    }

    @Override
    public void onLoadEnd() {
        LatteLogger.i("WebView", "Finish loading page!");
    }
}
