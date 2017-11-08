package com.tepth.latte.app;

import com.tepth.latte.utils.storage.LattePreference;

/**
 * Description:用户管理者
 *
 * @author Hequn.Lee
 * @date 2017/11/8
 */

public class AccountManager {
    private enum SignTag {
        SIGN_TAG
    }

    /**
     * 保存用户登录状态，登录后调用
     *
     * @param state 登录状态
     */
    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    /**
     * 检查用户是否登陆
     *
     * @return 返回用户登录状态
     */
    private static boolean isSignIn() {
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    /**
     * 检查用户是否登陆并回调
     *
     * @param checker 回调接口
     */
    public static void checkAccount(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }
}
