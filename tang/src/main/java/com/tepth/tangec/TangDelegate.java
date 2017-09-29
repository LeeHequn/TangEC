package com.tepth.tangec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tepth.latte.delegates.LatteDelegate;

/**
 * Created by LHQ on 2017/9/29.
 */

public class TangDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_tang;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
