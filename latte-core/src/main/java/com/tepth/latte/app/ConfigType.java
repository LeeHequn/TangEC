package com.tepth.latte.app;

/**
 * 配置枚举
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */

public enum ConfigType {
    /**
     * 后台主地址
     */
    API_HOST,
    /**
     * APP上下文
     */
    APPLICATION_CONTEXT,
    /**
     * 配置文件是否加载
     */
    CONFIG_READY,
    /**
     * 图标
     */
    ICON,
    /**
     * 拦截器
     */
    INTERCEPTOR,
    /**
     * 微信AppId
     */
    WE_CHAT_APP_ID,
    /**
     * 微信AppSecret
     */
    WE_CHAT_APP_SECRET,
    /**
     * Activity
     */
    ACTIVITY,
    /**
     * 全局的Handler
     */
    HANDLER
}
