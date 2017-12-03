package com.example.latte.ui.refresh;

/**
 * Description:存储分页的Bean对象
 *
 * @author Hequn.Lee
 * @date 2017/12/1
 */

@SuppressWarnings("ALL")
public final class PagingBean {

    /**
     * 当前是第几页
     */
    private int mPageIndex = 0;
    /**
     * 总数据条数
     */
    private int mTotal = 0;
    /**
     * 一页显示几条数据
     */
    private int mPageSize = 0;
    /**
     * 当前已经显示了几条数据
     */
    private int mCurrentCount = 0;
    /**
     * 延迟加载时间
     */
    private int mDelayed = 0;

    public int getPageIndex() {
        return mPageIndex;
    }

    public PagingBean setPageIndex(int pageIndex) {
        mPageIndex = pageIndex;
        return this;
    }

    public int getTotal() {
        return mTotal;
    }

    public PagingBean setTotal(int total) {
        mTotal = total;
        return this;
    }

    public int getPageSize() {
        return mPageSize;
    }

    public PagingBean setPageSize(int pageSize) {
        mPageSize = pageSize;
        return this;
    }

    public int getCurrentCount() {
        return mCurrentCount;
    }

    public PagingBean setCurrentCount(int currentCount) {
        mCurrentCount = currentCount;
        return this;
    }

    public int getDelayed() {
        return mDelayed;
    }

    public PagingBean setDelayed(int delayed) {
        mDelayed = delayed;
        return this;
    }

    PagingBean addIndex(){
        mPageIndex++;
        return this;
    }
}
