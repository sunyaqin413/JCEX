package cn.jcex.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.jcex.R;


/**
 * 类描述:我的-在线客服adapter
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/13  10:44
 */

public class ServiceOnlineAdapter extends BaseQuickAdapter<String,BaseViewHolder> {


    public ServiceOnlineAdapter(int item_service_online, List<String> mDatas) {
        super(item_service_online, mDatas);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);
    }
}
