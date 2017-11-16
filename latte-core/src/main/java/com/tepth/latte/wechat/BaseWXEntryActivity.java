package com.tepth.latte.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tepth.latte.net.RestClient;
import com.tepth.latte.net.callback.IError;
import com.tepth.latte.net.callback.IFailure;
import com.tepth.latte.net.callback.ISuccess;
import com.tepth.latte.utils.log.LatteLogger;

/**
 * Description:处理微信登陆逻辑的页面
 *
 * @author Hequn.Lee
 * @date 2017/11/9
 */

public abstract class BaseWXEntryActivity extends BaseWXActivity {

    /**
     * 用户登陆成功后回调
     *
     * @param userInfo 用户信息
     */
    protected abstract void onSignInSuccess(String userInfo);

    /**
     * 微信发送到第三方应用后的请求回调
     *
     * @param baseReq 回调参数
     */
    @Override
    public void onReq(BaseReq baseReq) {
    }

    /**
     * 第三方应用发送请求到微信后的回调
     *
     * @param baseResp 回调参数
     */
    @Override
    public void onResp(BaseResp baseResp) {
        final String code = ((SendAuth.Resp) baseResp).code;
        final StringBuilder authUrl = new StringBuilder();
        authUrl
                .append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=")
                .append(LatteWeChat.APP_ID)
                .append("&secret=")
                .append(LatteWeChat.APP_SECRET)
                .append("&code=")
                .append(code)
                .append("&grant_type=authorization_code");
        LatteLogger.d("authUrl", authUrl.toString());
        getAuth(authUrl.toString());
    }

    /**
     * 通过Auth的URL拿到accessToken
     *
     * @param authUrl url
     */
    private void getAuth(String authUrl) {
        RestClient
                .builder()
                .url(authUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final JSONObject authObj = JSON.parseObject(response);
                        final String accessToken = authObj.getString("access_token");
                        final String openId = authObj.getString("openid");

                        final StringBuilder userInfoUrl = new StringBuilder();
                        userInfoUrl
                                .append("https://api.weixin.qq.com/sns/userinfo?access_token=")
                                .append(accessToken)
                                .append("&openid=")
                                .append(openId)
                                .append("&lang=")
                                .append("zh_CN");
                        LatteLogger.d("userInfoUrl", userInfoUrl.toString());
                        getUserInfo(userInfoUrl.toString());
                    }
                })
                .builder()
                .get();
    }

    /**
     * 获取用户信息
     *
     * @param userInfoUrl 获取用户信息的URL
     */
    private void getUserInfo(String userInfoUrl) {
        RestClient
                .builder()
                .url(userInfoUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        onSignInSuccess(response);
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .builder()
                .get();
    }
}
