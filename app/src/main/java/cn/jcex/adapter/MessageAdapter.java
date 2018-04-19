package cn.jcex.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.jcex.R;

/**
 * 类描述: 我的消息adapter
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/9  15:22
 */

public class MessageAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public MessageAdapter(int item_grid_order, List<String> mDatas) {
        super(item_grid_order,mDatas);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);
    }


}
