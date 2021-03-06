package com.tepth.latte.delegates.bottom;

import android.widget.Toast;

import com.tepth.latte.R;
import com.tepth.latte.app.Latte;
import com.tepth.latte.delegates.LatteDelegate;

/**
 * Description:五个分页的Delegate基类，主要封装双击退出点击事件
 *
 * @author Hequn.Lee
 * @date 2017/11/9
 */

public abstract class BaseBottomItemDelegate extends LatteDelegate {
    /**
     * 再点一次退出程序时间设置
     */
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出" + Latte.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
