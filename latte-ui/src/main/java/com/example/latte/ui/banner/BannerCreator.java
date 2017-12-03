package com.example.latte.ui.banner;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.latte.ui.R;

import java.util.ArrayList;

/**
 * Description:设置默认样式的Banner
 *
 * @author Hequn.Lee
 * @date 2017/12/1
 */

public class BannerCreator {

    public static void setDefault(ConvenientBanner<String> convenientBanner,
                                  ArrayList<String> banners,
                                  OnItemClickListener clickListener) {
        //设置holder
        convenientBanner.setPages(new HolderCreator(), banners)
                //设置底下的圆圈
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                //设置圆圈水平居中
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                //设置点击图片事件
                .setOnItemClickListener(clickListener)
                .setPageTransformer(new DefaultTransformer())
                //设置延迟时间3秒
                .startTurning(3000)
                //设置是否循环
                .setCanLoop(true);
    }
}
