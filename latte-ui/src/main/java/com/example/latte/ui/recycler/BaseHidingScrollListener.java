package com.example.latte.ui.recycler;

import android.support.v7.widget.RecyclerView;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/1/9
 */

public abstract class BaseHidingScrollListener extends RecyclerView.OnScrollListener {

    private static final int HIDE_THRESHOLD = 20;
    private int scrolledDistance = 0;
    private boolean controlsVisible = true;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
            onHide();
            controlsVisible = false;
            scrolledDistance = 0;
        } else if (scrolledDistance < -HIDE_THRESHOLD && !controlsVisible) {
            onShow();
            controlsVisible = true;
            scrolledDistance = 0;
        }
        final boolean isControls = (controlsVisible && dy > 0) || (!controlsVisible && dy < 0);
        if (isControls) {
            scrolledDistance += dy;
        }
    }

    /**
     * Toolbar隐藏的方法
     */
    public abstract void onHide();

    /**
     * Toolbar显示的方法
     */
    public abstract void onShow();
}
