package com.tepth.tang;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.tencent.bugly.crashreport.CrashReport;
import com.tepth.latte.app.Latte;
import com.tepth.latte.net.interceptors.CookieInterceptors;
import com.tepth.tang.event.TestEvent;
import com.tepth.latte.ec.database.DatabaseManager;
import com.tepth.latte.ec.icon.FontEcModule;
import com.tepth.latte.net.interceptors.DebugInterceptor;

/**
 * 全局Application
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

@SuppressWarnings("ALL")
public class TangApp extends Application {

    /**
     * 家里的XAMPP服务器地址
     */
    private static final String HOME_IP_ADDRESS = "http://192.168.0.106:80/RestServer/api/";
    /**
     * 公司的XAMPP服务器地址
     */
    private static final String WORK_IP_ADDRESS = "http://192.168.1.23:8088/RestServer/api/";

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化配置文件
        Latte.init(this)
                .withApiHost(WORK_IP_ADDRESS)
                //引入官方图标库
                .withIcon(new FontAwesomeModule())
                //引入我自定义的聚划算图标库
                .withIcon(new FontEcModule())
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withWeChatAppId("wx8ba572958ee506c3")
                .withWeChatAppSecret("13a913b9e01201ad214069a6024d7b94")
                .withJavasciptInterface("latte")
                .withWebEvent(TestEvent.EVENT_NAME, new TestEvent())
                //添加Cookie拦截器
                .withWebHost("https://baidu.com/")
                .withInterceptor(new CookieInterceptors())
                .configure();
        //初始化数据库
        DatabaseManager.getInstance().init(this);
        //配置Bugly
        CrashReport.initCrashReport(getApplicationContext(), "7049f826d7", true);
    }
}
