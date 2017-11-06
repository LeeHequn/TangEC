package com.tepth.latte.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * 基本类Delegate
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

@SuppressWarnings("ALL")
public abstract class BaseDelegate extends SwipeBackFragment {

    private Unbinder mUnbinder = null;

    /**
     * 设置布局
     *
     * @return 返回布局
     */
    public abstract Object setLayout();

    /**
     * 绑定视图
     *
     * @param savedInstanceState 存储的Bundle
     * @param rootView           根视图
     */
    public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        }
        if (rootView != null) {
            mUnbinder = ButterKnife.bind(this, rootView);
            onBindView(savedInstanceState, rootView);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
