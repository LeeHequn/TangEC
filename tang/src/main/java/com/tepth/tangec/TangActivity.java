package com.tepth.tangec;

import com.tepth.latte.activities.BaseActivity;
import com.tepth.latte.delegates.LatteDelegate;

/**
 * 主页Activity
 *
 * @author Hequn.Lee
 * @date 2017/11/06
 */
public class TangActivity extends BaseActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new TangDelegate();
    }
}
