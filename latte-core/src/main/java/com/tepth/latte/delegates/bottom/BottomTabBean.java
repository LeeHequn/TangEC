package com.tepth.latte.delegates.bottom;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/11/9
 */

public final class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }

    @Override
    public int hashCode() {
        return ICON.hashCode() + TITLE.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BottomTabBean) {
            BottomTabBean bean = (BottomTabBean) obj;
            return ICON.equals(bean.getIcon()) && TITLE.equals(bean.getTitle());
        }
        return false;
    }
}
