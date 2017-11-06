package com.tepth.latte.utils.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.tepth.latte.app.Latte;

/**
 * 获取屏幕宽高的工具类
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
