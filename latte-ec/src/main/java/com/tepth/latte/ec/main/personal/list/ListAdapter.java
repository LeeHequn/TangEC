package com.tepth.latte.ec.main.personal.list;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tepth.latte.ec.R;

import java.util.List;

/**
 * Description:个人主页适配器
 *
 * @author Hequn.Lee
 * @date 2018/1/23
 */

public class ListAdapter extends BaseMultiItemQuickAdapter<ListBean, BaseViewHolder> {

    public ListAdapter(List<ListBean> data) {
        super(data);
        addItemType(ListItemType.ITEM_NORMAL, R.layout.arrow_item_layout);
    }

    @Override
    protected void convert(BaseViewHolder holder, ListBean item) {
        switch (holder.getItemViewType()) {
            case ListItemType.ITEM_NORMAL:
                holder.setText(R.id.tv_arrow_text, item.getText());
                holder.setText(R.id.tv_arrow_value, item.getValue());
                break;
            default:
                break;
        }
    }
}
