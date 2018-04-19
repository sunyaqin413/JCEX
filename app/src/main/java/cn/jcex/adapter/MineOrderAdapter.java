package cn.jcex.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


/**
 * 类描述:我的运单adapter
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/13  10:44
 */

public class MineOrderAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    public MineOrderAdapter(int item_mine_orders, List<String> mDatas) {
        super(item_mine_orders, mDatas);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
    }
}
