package com.tepth.latte.ec.main.sort.list;

import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.example.latte.ui.recycler.ItemType;
import com.example.latte.ui.recycler.MultipleFields;
import com.example.latte.ui.recycler.MultipleItemEntity;
import com.example.latte.ui.recycler.MultipleRecyclerAdapter;
import com.example.latte.ui.recycler.MultipleViewHolder;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.main.sort.SortDelegate;
import com.tepth.latte.utils.resources.ResourcesUtil;

import java.util.List;

/**
 * Description:分类页面左侧竖直菜单Recycler适配器
 *
 * @author Hequn.Lee
 * @date 2017/12/3
 */

public class SortRecyclerAdapter extends MultipleRecyclerAdapter {

    private final SortDelegate DELEGATE;

    SortRecyclerAdapter(List<MultipleItemEntity> data, SortDelegate delegate) {
        super(data);
        this.DELEGATE = delegate;
        //添加垂直菜单布局
        addItemType(ItemType.VERTICAL_MENU_LIST, R.layout.item_vertical_menu_list);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case ItemType.VERTICAL_MENU_LIST:
                final String text = entity.getField(MultipleFields.TEXT);
                final boolean isClicked = entity.getField(MultipleFields.TAG);
                final AppCompatTextView name = holder.getView(R.id.tv_vertical_item_name);
                final View line = holder.getView(R.id.view_line);
                final View itemView = holder.itemView;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                if (!isClicked) {
                    line.setVisibility(View.INVISIBLE);
                    name.setTextColor(ResourcesUtil.getColorFromResources(mContext, R.color.we_chat_black));
                    itemView.setBackgroundColor(ResourcesUtil.getColorFromResources(mContext, R.color.item_background));
                } else {
                    line.setVisibility(View.VISIBLE);
                    name.setTextColor(ResourcesUtil.getColorFromResources(mContext, R.color.we_chat_black));
                    itemView.setBackgroundColor(ResourcesUtil.getColorFromResources(mContext, R.color.item_background));
                    line.setBackgroundColor(ResourcesUtil.getColorFromResources(mContext, R.color.item_background));
                    itemView.setBackgroundColor(Color.WHITE);
                }
                holder.setText(R.id.tv_vertical_item_name, text);
                break;
            default:
                break;
        }
    }
}
