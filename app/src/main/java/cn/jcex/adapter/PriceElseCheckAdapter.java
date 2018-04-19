package cn.jcex.adapter;

import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cn.jcex.R;
import cn.jcex.bean.CalcuatePriceElseBean;

/**
 * 类描述: 首页-价格试算-额外服务选择adapter
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/9  15:22
 */

public class PriceElseCheckAdapter extends BaseQuickAdapter<CalcuatePriceElseBean,BaseViewHolder> {

    public PriceElseCheckAdapter(int item_ca_price_check, List<CalcuatePriceElseBean> mDatas) {
        super(item_ca_price_check,mDatas);
    }

    @Override
    protected void convert(BaseViewHolder helper, final CalcuatePriceElseBean item) {
        helper.setText(R.id.tv, item.getName());
//        helper.setImageResource(R.id.iv, item.getImgId());
        helper.setOnCheckedChangeListener(R.id.checkbox, new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                  item.setSelected(true);
                }else{
                    item.setSelected(false);
                }
            }
        });
    }

}
