package com.tepth.latte.app;

import android.content.Context;

/**
 * 全局类Latte
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */
@SuppressWarnings("ALL")
public final class Latte {
    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigType.APPLICATION_CONTEXT);
    }
}
