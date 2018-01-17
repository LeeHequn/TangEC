package com.tepth.latte.ec.main.index;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.example.latte.ui.recycler.RgbValue;
import com.tepth.latte.ec.R;

/**
 * Description:让Toolbar根据Recycler滑动的变化而变化透明度的控制器
 *
 * @author Hequn.Lee
 * @date 2017/12/3
 */

@SuppressWarnings("ALL")
public class TranslucentBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    /**
     * 顶部距离
     */
    private int mDistanceY = 0;

    /**
     * 颜色变化的速度
     */
    private static final int SHOW_SPEED = 3;

    private final RgbValue RGB_VALUE = RgbValue.create(255, 124, 5);

    public TranslucentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 当滑动的控件为RecyclerView时,重写onNestedPreScroll方法更改Toolbar的透明度
     *
     * @param parent     CoordinatorLayout父布局
     * @param child      Toolbar子布局
     * @param dependency 滑动的布局
     * @return 是否控制该布局
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency.getId() == R.id.rv_index;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        //增加滑动距离
        mDistanceY += dy;
        //获取Toolbar的高度
        final int targetHeight = child.getBottom();
        //当滑动时，滑动距离小于Toolbar高度时，调整渐变色
        if (mDistanceY > 0 && mDistanceY <= targetHeight) {
            //比例
            final float scale = (float) mDistanceY / targetHeight;
            final float alpha = scale * 255;
            child.setBackgroundColor(Color.argb((int) alpha, RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
        } else if (mDistanceY > targetHeight) {
            //当滑动过快时，恢复原来的颜色
            child.setBackgroundColor(Color.rgb(RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
        }
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, Toolbar child, View target, float velocityX, float velocityY, boolean consumed) {
        return true;
    }
}
