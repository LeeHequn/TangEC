package com.tepth.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.tepth.latte.delegates.LatteDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ui.launcher.LauncherHolderCreator;
import com.tepth.latte.ui.launcher.ScollLauncherTag;
import com.tepth.latte.utils.storage.LattePreference;

import java.util.ArrayList;

/**
 * Description:滚动的启动页
 *
 * @author Hequn.Lee
 * @date 2017/11/7
 */

public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener {

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    private void initBanner() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        mConvenientBanner
                .setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        //如果点击的是最后一个图片
        if (position == INTEGERS.size() - 1) {
            LattePreference.setAppFlag(ScollLauncherTag.HAS_FIRST_LAUNCHERAPP.name(), true);
            //检查用户是否登陆
        }
    }
}
