package cn.jcex.ui.fragment.station;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jcex.R;
import cn.jcex.base.BaseFragment;

/**
 * 类描述:
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/9  12:17
 */

public class ChinaStationFragment extends BaseFragment {

    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
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
        View view = inflater.inflate(R.layout.fragment_station_china, null);
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
}
