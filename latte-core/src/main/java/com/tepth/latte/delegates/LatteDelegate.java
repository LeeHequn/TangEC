package com.tepth.latte.delegates;

/**
 * 全局的基类Delegate
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

@SuppressWarnings("ALL")
public abstract class LatteDelegate extends PermissionCheckerDelegate {
    /**
     * 获取Fragment的上一级Fragment
     *
     * @param <T> 上一级Fragment
     * @return 上一级Fragment
     */
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
