package com.tepth.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.joanzapata.iconify.widget.IconTextView;
import com.tepth.latte.delegates.bottom.BottomItemDelegate;
import com.tepth.latte.ec.R;
import com.tepth.latte.ec.R2;
import com.tepth.latte.net.RestClient;
import com.tepth.latte.net.callback.ISuccess;
import com.tepth.latte.ui.recycler.MultipleFields;
import com.tepth.latte.ui.recycler.MultipleItemEntity;
import com.tepth.latte.ui.refresh.RefreshHandler;
import com.tepth.latte.utils.resources.ResourcesUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Description:
 *
 * @author Hequn.Lee
 * @date 2017/11/16
 */

public class IndexDelegate extends BottomItemDelegate {

    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;

    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;

    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;

    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;

    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;

    private RefreshHandler mRefreshHandler = null;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = new RefreshHandler(mRefreshLayout);
        RestClient.builder()
                .url("index.php")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final IndexDataConvert convert = new IndexDataConvert();
                        convert.setJsonData(response);
                        final ArrayList<MultipleItemEntity> list = convert.convert();
                        final String image = list.get(1).getField(MultipleFields.IMAGE_URL);
                        Toast.makeText(getContext(), image, Toast.LENGTH_SHORT).show();
                    }
                })
                .builder()
                .get();

    }

    /**
     * 初始化下拉刷新布局
     */
    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeColors(
                ResourcesUtil.getColorFromResources(getContext(), android.R.color.holo_blue_bright),
                ResourcesUtil.getColorFromResources(getContext(), android.R.color.holo_orange_light),
                ResourcesUtil.getColorFromResources(getContext(), android.R.color.holo_red_light)
        );
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
        mRefreshHandler.firstPage("index.php");
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }
}
