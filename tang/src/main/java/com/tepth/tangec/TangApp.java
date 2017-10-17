package com.tepth.tangec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.tencent.bugly.crashreport.CrashReport;
import com.tepth.latte.app.Latte;
import com.tepth.latte.ec.icon.FontEcModule;

/**
 * 全局Application
 * Created by LHQ on 2017/9/29.
 */

public class TangApp extends Application {

    @Override
    public void onCreate() {
        Latte.init(this)
                .withApiHost("http://news.baidu.com/")
                .withIcon(new FontAwesomeModule())//引入官方图标库
                .withIcon(new FontEcModule())//引入我自定义的聚划算图标库
                .Configure();//初始化配置文件
        //配置Bugly
        CrashReport.initCrashReport(getApplicationContext(), "7049f826d7", true);
        super.onCreate();
    }
}
