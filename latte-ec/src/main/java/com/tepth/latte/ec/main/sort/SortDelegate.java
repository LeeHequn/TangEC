package com.tepth.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tepth.latte.delegates.bottom.BaseBottomItemDelegate;
import com.tepth.latte.ec.R;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/11/16
 */

public class SortDelegate extends BaseBottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
