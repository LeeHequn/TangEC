package com.tepth.latte.ec.main.cart;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.widget.Toast;

import com.example.latte.ui.recycler.MultipleItemEntity;
import com.joanzapata.iconify.widget.IconTextView;
import com.tepth.latte.delegates.bottom.BaseBottomItemDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.R2;
import com.tepth.latte.ec.pay.FastPay;
import com.tepth.latte.net.RestClient;
import com.tepth.latte.net.callback.ISuccess;
import com.tepth.latte.utils.resources.ResourcesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:购物车Delegate
 *
 * @author Hequn.Lee
 * @date 2017/12/18
 */

@SuppressWarnings("ALL")
public class ShopCartDelegate extends BaseBottomItemDelegate implements ISuccess, ICartItemListener {

    private ShopCartAdapter mAdapter = null;
    /**
     * 购物车数量标记
     */
    private int mCurrentCount = 0;
    /**
     * 总数
     */
    private int mTotalCount = 0;
    /**
     * 总价格
     */
    private double mTotalPrice = 0.00;

    @BindView(R2.id.rv_shop_cart)
    RecyclerView mRecyclerView = null;

    @BindView(R2.id.icon_shop_cart_select_all)
    IconTextView mIconSelectAll = null;

    @BindView(R2.id.stub_no_item)
    ViewStubCompat mStubNoItem = null;

    @BindView(R2.id.tv_shop_cart_total_price)
    AppCompatTextView mTvTotalPrice = null;

    @OnClick(R2.id.icon_shop_cart_select_all)
    void onClickSelectAll() {
        final int tag = (int) mIconSelectAll.getTag();
        if (tag == 0) {
            mIconSelectAll.setTextColor(
                    ResourcesUtil.getColorFromResources(getContext(), R.color.app_main));
            mIconSelectAll.setTag(1);
            mAdapter.setIsSelectedAll(true);
            //更新RecyclerView的显示状态，notifyDataSetChanged会刷新所有控件，消耗比较大，所以用notifyItemRangeChanged
            mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());
        } else {
            mIconSelectAll.setTextColor(Color.GRAY);
            mIconSelectAll.setTag(0);
            mAdapter.setIsSelectedAll(false);
            //更新RecyclerView的显示状态
            mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());
        }
    }

    @OnClick(R2.id.tv_top_shop_cart_remove_selected)
    void onClickRemoveSelectedItem() {
        final List<MultipleItemEntity> data = mAdapter.getData();
        //在所有数据里找到要删除的数据
        List<MultipleItemEntity> deleteEntities = new ArrayList<>();
        for (MultipleItemEntity item : data) {
            final boolean isSelected = item.getField(ShopCartItemFields.IS_SELECTED);
            if (isSelected) {
                deleteEntities.add(item);
            }
        }
        final int deleteSize = deleteEntities.size();
        if (deleteSize > 0) {
            for (MultipleItemEntity entity : deleteEntities) {
                int removePosition;
                final int entityPosition = entity.getField(ShopCartItemFields.POSITION);
                if (entityPosition > mCurrentCount - 1) {
                    removePosition = entityPosition - (mTotalCount - mCurrentCount);
                } else {
                    removePosition = entityPosition;
                }
                if (removePosition <= mAdapter.getItemCount()) {
                    mAdapter.remove(removePosition);
                    mCurrentCount = mAdapter.getItemCount();
                    //更新数据
                    mAdapter.notifyItemRangeChanged(removePosition, mAdapter.getItemCount());
                }
            }
            final List<MultipleItemEntity> totalData = mAdapter.getData();
            final int totalSize = totalData.size();
            for (int i = 0; i < totalSize; i++) {
                final MultipleItemEntity entity = totalData.get(i);
                entity.setField(ShopCartItemFields.POSITION, i);
            }
            mAdapter.setNewData(totalData);
        }
        checkItemCount();
    }

    @OnClick(R2.id.tv_top_shop_cart_clear)
    void onClickClear() {
        mAdapter.getData().clear();
        mAdapter.notifyDataSetChanged();
        checkItemCount();
    }

    @OnClick(R2.id.tv_shop_cart_pay)
    void onClickPay() {
        FastPay.create(this).beginPayDialog();
    }

    /**
     * 创建订单，注意，和支付没有关系
     */
    private void createOrder() {

    }

    @SuppressLint("RestrictedApi")
    private void checkItemCount() {
        final int count = mAdapter.getItemCount();
        if (count == 0) {
            final View stubView = mStubNoItem.inflate();
            final AppCompatTextView tvToBuy = (AppCompatTextView) stubView.findViewById(R.id.tv_stub_to_buy);
            tvToBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "你该购物了！", Toast.LENGTH_SHORT).show();
                }
            });
            mRecyclerView.setVisibility(View.GONE);
        } else {
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_shop_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mIconSelectAll.setTag(0);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("shop_cart.php")
                .loader(getContext())
                .success(this)
                .builder()
                .get();
    }

    @Override
    public void onSuccess(String response) {
        final ArrayList<MultipleItemEntity> data = new ShopCartDataConverter()
                .setJsonData(response)
                .convert();
        mAdapter = new ShopCartAdapter(data);
        mAdapter.setCartItemListener(this);
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        checkItemCount();
        mTotalPrice = mAdapter.getTotalPrice();
        mTvTotalPrice.setText(String.valueOf(mTotalPrice));
    }

    @Override
    public void onItemClick(double itemTotalPrice) {
        final double price = mAdapter.getTotalPrice();
        mTvTotalPrice.setText(String.valueOf(price));
    }
}
