package cn.jcex.ui.fragment.mine;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.adapter.MineOrderAdapter;
import cn.jcex.base.BaseFragment;

/**
 * 类描述:运单记录fragment
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/04/13  10:03
 */

public class OrderRecordsFragment extends BaseFragment {

    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    private List<String> mDatas;


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_forecast_orders, null);
        return view;
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();
    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.mine_order_forecast);
        mTvLeft.setVisibility(View.VISIBLE);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        BaseQuickAdapter adapter = new MineOrderAdapter(R.layout.item_mine_orders, mDatas);
        adapter.openLoadAnimation();
        mRecycleView.setAdapter(adapter);
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

    @OnClick({R.id.tv_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left://返回
                getActivity().onBackPressed();
                getActivity().finish();
                break;


        }
    }

}
