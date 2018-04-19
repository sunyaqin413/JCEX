package cn.jcex.ui.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.base.BaseFragment;
import cn.jcex.ui.activity.LoginActivity;
import cn.jcex.ui.activity.mine.MineAddressActivity;
import cn.jcex.ui.activity.mine.MineCostActivity;
import cn.jcex.ui.activity.mine.MineDeliveryRecordsActivity;
import cn.jcex.ui.activity.mine.MyOrderActivity;
import cn.jcex.ui.activity.mine.OrderRecordsActivity;
import cn.jcex.ui.activity.mine.ServiceOnlineActivity;
import cn.jcex.ui.activity.mine.SettingActivity;
import cn.jcex.ui.activity.mine.ToForecastOrderActivity;
import cn.jcex.view.dialog.SweetAlertDialog;

/**
 * 类描述:我的
 *
 * @author Sunyaqin
 * @data 2018-03-30  17:50
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.iv_set)
    ImageView mIvSet;
    @BindView(R.id.iv_head)
    ImageView mIvHead;
    @BindView(R.id.tv_login)
    TextView mTvLogin;
    @BindView(R.id.tv_register)
    TextView mTvRegister;
    @BindView(R.id.iv_order)
    ImageView mIvOrder;

    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        return view;
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initViewsOnCreate() {
    }


    @Override
    protected void requestNetData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }

    @OnClick({R.id.iv_set, R.id.iv_head, R.id.tv_login, R.id.tv_register, R.id.rl_mine_order, R.id.rl_forecast, R.id.rl_track,
            R.id.rl_cost, R.id.rl_pick_records, R.id.rl_address, R.id.rl_service_online, R.id.rl_service_line, R.id.rl_sales_line})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_set://设置
                intent = new Intent(getActivity(), SettingActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_head://头像

                break;
            case R.id.tv_login://登录
                intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.tv_register://注册

                break;
            case R.id.rl_mine_order://我的订单
                intent = new Intent(getActivity(), MyOrderActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.rl_forecast://待预报
                intent = new Intent(getActivity(), ToForecastOrderActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.rl_track://物流追踪
                intent = new Intent(getActivity(), OrderRecordsActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.rl_cost://我的费用
                intent = new Intent(getActivity(), MineCostActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.rl_pick_records://提货记录
                intent = new Intent(getActivity(), MineDeliveryRecordsActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.rl_address://地址簿
                intent = new Intent(getActivity(), MineAddressActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.rl_service_online://在线客服
                intent = new Intent(getActivity(), ServiceOnlineActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.rl_service_line://客服热线
                dialog.changeAlertType(SweetAlertDialog.PROMPT_TYPE);
                dialog.setTitleText("拨打电话:400-887-1083").show();
                dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        Uri data = Uri.parse("tel:" + "400-887-1083");
                        intent.setData(data);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.rl_sales_line://销售热线
                dialog.changeAlertType(SweetAlertDialog.PROMPT_TYPE);
                dialog.setTitleText("拨打电话:400-882-1083").show();
                dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        Uri data = Uri.parse("tel:" + "400-882-1083");
                        intent.setData(data);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                break;
        }
    }


}
