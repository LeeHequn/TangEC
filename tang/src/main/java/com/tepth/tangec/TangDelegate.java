package com.tepth.tangec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.tepth.latte.delegates.LatteDelegate;
import com.tepth.latte.net.RestClient;
import com.tepth.latte.net.callback.IError;
import com.tepth.latte.net.callback.IFailure;
import com.tepth.latte.net.callback.ISuccess;

/**
 * 项目的Delegate
 * Created by LHQ on 2017/9/29.
 */

public class TangDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_tang;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://news.baidu.com/")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .builder()
                .get();
    }
}
