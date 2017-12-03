package com.tepth.latte.ec.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.tepth.latte.app.AccountManager;
import com.tepth.latte.app.IUserChecker;
import com.tepth.latte.delegates.LatteDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.R2;
import com.example.latte.ui.launcher.ILauncherListener;
import com.example.latte.ui.launcher.OnLauncherFinishTag;
import com.example.latte.ui.launcher.ScollLauncherTag;
import com.tepth.latte.utils.storage.LattePreference;
import com.tepth.latte.utils.timer.BaseTimerTask;
import com.tepth.latte.utils.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:启动页Delegate
 *
 * @author Hequn.Lee
 * @date 2017/11/7
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    private ScheduledExecutorService mScheduledExecutorService = null;
    private int mCount = 5;
    private ILauncherListener mILauncherListener = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (mScheduledExecutorService != null) {
            mScheduledExecutorService.shutdownNow();
            mScheduledExecutorService = null;
            checkIsShowScroll();
        }
    }

    private void initTimer() {
        mScheduledExecutorService = new ScheduledThreadPoolExecutor(1, new ThreadPoolExecutor.AbortPolicy());
        final BaseTimerTask task = new BaseTimerTask(this);
        mScheduledExecutorService.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    /**
     * 判断是否显示滑动页面
     */
    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScollLauncherTag.HAS_FIRST_LAUNCHERAPP.name())) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            //检查用户是否登陆
            AccountManager.checkAccount(new IUserChecker() {
                @Override
                public void onSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIn() {
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }

    @Override
    public void onTimer() {
        getBaseActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mScheduledExecutorService != null) {
                            mScheduledExecutorService.shutdownNow();
                            mScheduledExecutorService = null;
                            checkIsShowScroll();
                        }
                    }
                }
            }
        });
    }
}
