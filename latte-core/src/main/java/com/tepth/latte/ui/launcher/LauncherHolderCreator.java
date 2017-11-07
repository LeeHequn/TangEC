package com.tepth.latte.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Description:启动图片Holder创建者
 *
 * @author Hequn.Lee
 * @date 2017/11/7
 */

public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder> {
    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
