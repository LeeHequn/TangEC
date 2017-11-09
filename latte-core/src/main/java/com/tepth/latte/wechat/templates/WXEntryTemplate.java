package com.tepth.latte.wechat.templates;

import com.tepth.latte.wechat.BaseWXEntryActivity;
import com.tepth.latte.wechat.LatteWeChat;

/**
 * Description:微信入口模板文件
 *
 * @author Hequn.Lee
 * @date 2017/11/8
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        //没有动画，直接消失
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }

}
