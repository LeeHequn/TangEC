package com.tepth.tangec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.tepth.latte.app.Latte;
import com.tepth.latte.ec.icon.FontEcModule;

/**
 * Created by LHQ on 2017/9/29.
 */

public class TangApp extends Application {

    @Override
    public void onCreate() {
        Latte.init(this)
                .withIcon(new FontAwesomeModule())//引入官方图标库
                .withIcon(new FontEcModule())//引入我自定义的聚划算图标库
                .Configure();//初始化配置文件
        super.onCreate();
    }
}
