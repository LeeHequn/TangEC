package com.tepth.tangec;

import com.tepth.latte.activities.ProxyActivity;
import com.tepth.latte.delegates.LatteDelegate;

public class TangActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new TangDelegate();
    }
}
