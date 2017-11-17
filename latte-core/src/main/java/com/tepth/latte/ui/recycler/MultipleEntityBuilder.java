package com.tepth.latte.ui.recycler;

import java.util.WeakHashMap;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/11/17
 */

public class MultipleEntityBuilder {

    private static final WeakHashMap<Object, Object> FIELDS = new WeakHashMap<>();

    public MultipleEntityBuilder() {
        //先清除之前存储的数据
        FIELDS.clear();
    }

    public final MultipleEntityBuilder setItemType(int itemType) {
        FIELDS.put(MultipleFields.ITEM_TYPE, itemType);
        return this;
    }

    public final MultipleEntityBuilder setField(Object key, Object value) {
        FIELDS.put(key, value);
        return this;
    }

    public final MultipleEntityBuilder setFields(Object key, Object value) {
        FIELDS.put(key, value);
        return this;
    }
}
