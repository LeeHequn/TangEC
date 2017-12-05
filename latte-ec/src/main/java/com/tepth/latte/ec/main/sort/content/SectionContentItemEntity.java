package com.tepth.latte.ec.main.sort.content;

/**
 * Description:分类页面右侧内容里的大的Bean对象下面的小Entity对象
 *
 * @author Hequn.Lee
 * @date 2017/12/4
 */

class SectionContentItemEntity {

    private int mGoodsId = 0;
    private String mGoodsName = null;
    private String mGoodsThumb = null;

    int getGoodsId() {
        return mGoodsId;
    }

    void setGoodsId(int goodsId) {
        this.mGoodsId = goodsId;
    }

    String getGoodsName() {
        return mGoodsName;
    }

    void setGoodsName(String goodsName) {
        this.mGoodsName = goodsName;
    }

    String getGoodsThumb() {
        return mGoodsThumb;
    }

    void setGoodsThumb(String goodsThumb) {
        this.mGoodsThumb = goodsThumb;
    }
}
