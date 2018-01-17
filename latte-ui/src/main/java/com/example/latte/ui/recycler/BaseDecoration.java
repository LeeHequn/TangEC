package com.example.latte.ui.recycler;

import android.support.annotation.ColorInt;

/**
 * Description:自定义Decoration
 * extends DividerItemDecoration
 * @author Hequn.Lee
 * @date 2018/1/9
 */

@SuppressWarnings("ALL")
public class BaseDecoration  {

    private BaseDecoration(@ColorInt int color, int size) {
        //setDividerLookup(new DividerLookupImpl(color, size));
    }

    public static BaseDecoration create(@ColorInt int color, int size) {
        return new BaseDecoration(color, size);
    }
}
