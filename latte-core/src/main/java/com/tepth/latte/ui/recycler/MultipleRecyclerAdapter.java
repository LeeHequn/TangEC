package com.tepth.latte.ui.recycler;

import android.support.v7.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.tepth.latte.R;

import java.util.List;

/**
 * Description:
 *
 * @author LHQ
 * @date 2017/11/21
 */

public class MultipleRecyclerAdapter extends
        BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>
        implements
        BaseMultiItemQuickAdapter.SpanSizeLookup {

    protected MultipleRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }

    public static MultipleRecyclerAdapter create(List<MultipleItemEntity> data) {
        return new MultipleRecyclerAdapter(data);
    }

    public static MultipleRecyclerAdapter create(BaseDataConverter converter) {
        return new MultipleRecyclerAdapter(converter.convert());
    }

    private void init() {
        //设置不同的布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
    }

    @Override
    protected void convert(MultipleViewHolder multipleViewHolder, MultipleItemEntity multipleItemEntity) {

    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int i) {
        return 0;
    }
}
