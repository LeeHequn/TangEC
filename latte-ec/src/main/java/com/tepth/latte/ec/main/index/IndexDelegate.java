package com.tepth.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tepth.latte.delegates.bottom.BottomItemDelegate;
import com.tepth.latte.ec.R;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/11/16
 */

public class IndexDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
