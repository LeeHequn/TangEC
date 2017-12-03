package com.example.latte.ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Description:RGB color auto picker
 *
 * @author Hequn.Lee
 * @date 2017/12/3
 */

@SuppressWarnings("ALL")
@AutoValue
public abstract class RgbValue {

    /**
     * RedColor
     *
     * @return Red Color Int
     */
    public abstract int red();

    /**
     * GreenColor
     *
     * @return Green Color Int
     */
    public abstract int green();

    /**
     * BlueColor
     *
     * @return Blue Color Int
     */
    public abstract int blue();

    public static RgbValue create(int red, int green, int blue) {
        return new AutoValue_RgbValue(red, green, blue);
    }
}
