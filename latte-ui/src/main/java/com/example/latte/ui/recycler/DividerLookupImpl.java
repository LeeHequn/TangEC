package com.example.latte.ui.recycler;

/**
 * Description:自定义DividerItemDecoration.DividerLookup
 * implements DividerItemDecoration.DividerLookup
 * @author Hequn.Lee
 * @date 2018/1/9
 */

@SuppressWarnings("ALL")
class DividerLookupImpl  {
    private final int COLOR;
    private final int SIZE;

    DividerLookupImpl(int color, int size) {
        this.COLOR = color;
        this.SIZE = size;
    }
//    @Override
//    public Divider getVerticalDivider(int position) {
//        return new Divider.Builder()
//                .size(SIZE)
//                .color(COLOR)
//                .build();
//    }
//    @Override
//    public Divider getHorizontalDivider(int position) {
//        return new Divider.Builder()
//                .size(SIZE)
//                .color(COLOR)
//                .build();
//    }
}
