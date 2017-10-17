package com.tepth.latte.app;

import android.content.Context;

import java.util.HashMap;
//import java.util.WeakHashMap;

/**
 * 全局类Latte
 * Created by LHQ on 2017/9/28.
 */

public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
