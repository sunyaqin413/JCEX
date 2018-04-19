package cn.jcex.ui.fragment.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.adapter.PriceElseCheckAdapter;
import cn.jcex.base.BaseFragment;
import cn.jcex.bean.CalcuatePriceElseBean;
import cn.jcex.global.CommonJCData;
import cn.jcex.utils.L;
import cn.jcex.utils.T;

/**
 * 类描述:价格试算
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/10  15:44
 */

public class CalculatePriceFragment extends BaseFragment {
    private static final int REQUEST_DESTINATION = 105;
    private static final int REQUEST_TRANSPORT = 106;
    private static final int REQUEST_TYPE = 107;
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.tv_destination)
    TextView mTvDestination;
    @BindView(R.id.rl_select_destination)
    RelativeLayout mRlSelectDestination;
    @BindView(R.id.tv_weight)
    EditText mTvWeight;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.tv_volume)
    EditText mTvVolume;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.rl_select_type)
    RelativeLayout mRlSelectType;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;
    private List<CalcuatePriceElseBean> mDatas;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_price_calculate, null);
        return view;
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();
        mDatas.add(0,new CalcuatePriceElseBean("磁检",1));
        mDatas.add(1,new CalcuatePriceElseBean("单独报关",2));
        mDatas.add(2,new CalcuatePriceElseBean("FBA",3));
        mDatas.add(3,new CalcuatePriceElseBean("VAT",4));
        mDatas.add(4,new CalcuatePriceElseBean("木箱",5));
    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.home_price_for_trial);
        mTvLeft.setVisibility(View.VISIBLE);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),3);
        mRecycleView.setLayoutManager(layoutManager);
        BaseQuickAdapter checkAdapter = new PriceElseCheckAdapter(R.layout.item_ca_price_check, mDatas);
        checkAdapter.openLoadAnimation();
        mRecycleView.setAdapter(checkAdapter);

    }

    @Override
    protected void requestNetData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.tv_left, R.id.rl_select_destination, R.id.rl_select_weight,R.id.rl_select_type, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left://返回
                getFragmentManager().popBackStack();
                getActivity().finish();
                break;

            case R.id.rl_select_destination://选择目的地
                SelectDestinationFragment fragment = new SelectDestinationFragment();
                fragment.setTargetFragment(CalculatePriceFragment.this, REQUEST_DESTINATION);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, fragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.rl_select_weight://选择运输方式
                SelectTransportModeFragment transportModeFragment = new SelectTransportModeFragment();
                transportModeFragment.setTargetFragment(CalculatePriceFragment.this, REQUEST_TRANSPORT);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, transportModeFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.rl_select_type://选择类型
                SelectOrderTypeFragment orderTypeFragment = new SelectOrderTypeFragment();
                orderTypeFragment.setTargetFragment(CalculatePriceFragment.this, REQUEST_TYPE);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, orderTypeFragment)
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.btn_submit://提交预报信息
                T.showShort(getActivity(), "查询结果:");
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_DESTINATION:
                if (resultCode != Activity.RESULT_OK) {
                    return;
                } else {
                    String str = data.getStringExtra(CommonJCData.COUNTRY_NAME);
                    L.d("HOME", "目的地:" + str);
                    mTvDestination.setText(str);
                }
                break;
            case REQUEST_TRANSPORT:
                if (resultCode != Activity.RESULT_OK) {
                    return;
                } else {
                    String str = data.getStringExtra(CommonJCData.TRANSPORT_MODE);
                    L.d("HOME", "运输方式:" + str);
//                    mTvTransportMode.setText(str);
                }
                break;
                case REQUEST_TYPE:
                if (resultCode != Activity.RESULT_OK) {
                    return;
                } else {
                    String str = data.getStringExtra(CommonJCData.PACKAGE_TYPE);
                    L.d("HOME", "包裹类型:" + str);
//                    mTvTransportMode.setText(str);
                }
                break;
        }

    }



}
