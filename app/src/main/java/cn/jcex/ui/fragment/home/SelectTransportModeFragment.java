package cn.jcex.ui.fragment.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.base.BaseFragment;
import cn.jcex.global.CommonJCData;
import cn.jcex.view.QuickSearchView;

/**
 * 类描述:预报订单-选择运输方式
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/11  11:27
 */

public class SelectTransportModeFragment extends BaseFragment {
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.tv_country)
    TextView mTvCountry;
    @BindView(R.id.tv_city)
    TextView mTvCity;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.quick_view)
    QuickSearchView mQuickView;
    @BindView(R.id.tv_right)
    TextView mTvRight;
    private String name;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_order_select_destination, null);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.home_forecast_order_select_country);
        mTvLeft.setVisibility(View.VISIBLE);
        mTvLeft.setText(R.string.common_cancel);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(R.string.common_save);
        mEtSearch.setHint(R.string.home_forecast_order_country_hint);
        mEtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                name=s.toString().trim();
            }
        });
        mQuickView.setOnAlphaClickListener(new QuickSearchView.OnAlphaClickListener() {
            @Override
            public void onClick(Character c) {

            }
        });

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



    @OnClick({R.id.tv_left, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left://取消
                getFragmentManager().popBackStack();
                break;
            case R.id.tv_right://确定
                sendResult(Activity.RESULT_OK);
                getFragmentManager().popBackStack();
                break;
        }
    }
    private void sendResult(int resultOk) {
        if(getTargetFragment() == null){
            return;
        }else{
            Intent i = new Intent();
            i.putExtra(CommonJCData.TRANSPORT_MODE,"自营专线");
            getTargetFragment().onActivityResult(getTargetRequestCode(),resultOk,i);
        }
    }
}
