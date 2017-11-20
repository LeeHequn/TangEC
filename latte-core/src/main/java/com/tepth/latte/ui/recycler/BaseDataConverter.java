package com.tepth.latte.ui.recycler;

import java.util.ArrayList;

/**
 * Description:数据转换器基类
 *
 * @author Hequn.Lee
 * @date 2017/11/17
 */

@SuppressWarnings("ALL")
public abstract class BaseDataConverter {

    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    /**
     * 数据转换的方法
     *
     * @return 返回数据转换出来的Entity集合
     */
    public abstract ArrayList<MultipleItemEntity> convert();

    public BaseDataConverter setJsonData(String json) {
        mJsonData = json;
        return this;
    }

    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("DATA IS NULL!");
        }
        return mJsonData;
    }
}
