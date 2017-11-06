package com.tepth.tangec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.tencent.bugly.crashreport.CrashReport;
import com.tepth.latte.app.Latte;
import com.tepth.latte.ec.icon.FontEcModule;
import com.tepth.latte.net.interceptors.DebugInterceptor;

/**
 * 全局Application
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

public class TangApp extends Application {

    @Override
    public void onCreate() {
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                //引入官方图标库
                .withIcon(new FontAwesomeModule())
                //引入我自定义的聚划算图标库
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .Configure();//初始化配置文件
        //配置Bugly
        CrashReport.initCrashReport(getApplicationContext(), "7049f826d7", true);
        super.onCreate();
    }
}
