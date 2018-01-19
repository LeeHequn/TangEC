package com.tepth.latte.ec.pay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2018/1/19
 */

public class PayAsyncTask extends AsyncTask<String, Void, String> {

    @SuppressLint("StaticFieldLeak")
    private final Activity ACTIVITY;
    private final IAlPayResultListener LISTENER;

    public PayAsyncTask(Activity activity, IAlPayResultListener listener) {
        this.ACTIVITY = activity;
        this.LISTENER = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
