package com.tepth.tangec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.tepth.latte.activities.BaseActivity;
import com.tepth.latte.delegates.LatteDelegate;
import com.tepth.latte.ec.sign.SignUpDelegate;

/**
 * 主页Activity
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */
public class TangActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }
}
