package com.tepth.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.tepth.latte.app.Latte;

/**
 * Description:刷新控件助手
 *
 * @author Hequn.Lee
 * @date 2017/11/17
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout refreshLayout) {
        this.REFRESH_LAYOUT = refreshLayout;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    /**
     * 刷新的方法
     */
    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //这里请求一些网络操作
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
