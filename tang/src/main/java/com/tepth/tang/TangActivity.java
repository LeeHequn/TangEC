package com.tepth.tang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.tepth.latte.activities.BaseActivity;
import com.tepth.latte.delegates.LatteDelegate;
import com.tepth.latte.ec.launcher.LauncherDelegate;
import com.tepth.latte.ec.sign.ISignListener;
import com.tepth.latte.ec.sign.SignInDelegate;
import com.tepth.latte.ui.launcher.ILauncherListener;
import com.tepth.latte.ui.launcher.OnLauncherFinishTag;

/**
 * 主页Activity
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */
public class TangActivity extends BaseActivity implements ISignListener, ILauncherListener {

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
        return new LauncherDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                Toast.makeText(this, "启动结束了，用户登陆了", Toast.LENGTH_SHORT).show();
                startWithPop(new TangDelegate());
                break;
            case NOT_SIGNED:
                Toast.makeText(this, "启动结束了，用户没登陆", Toast.LENGTH_SHORT).show();
                startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
