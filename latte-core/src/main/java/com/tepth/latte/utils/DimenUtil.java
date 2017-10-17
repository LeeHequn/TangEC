package com.tepth.latte.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.tepth.latte.app.Latte;

/**
 * 获取屏幕宽高的工具类
 * Created by Hequn.Lee on 2017/10/17.
 */

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
