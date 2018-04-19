package cn.jcex.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.adapter.TabFragmentAdapter;
import cn.jcex.base.BaseFragment;
import cn.jcex.ui.fragment.station.ChinaStationFragment;
import cn.jcex.ui.fragment.station.ForeignStationFragment;

/**
 * 类描述:站点
 *
 * @author Sunyaqin
 * @data 2018-03-30  17:50
 */

public class StationFragment extends BaseFragment {
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;

    private static boolean isFirstEnter = true;
    /**
     * Tab标题
     */
    private List<String> title;
    private List<Fragment> fragments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_station,null);
        return view;
    }

    @Override
    protected void initData() {
        title = new ArrayList<>();
        title.add(getResources().getString(R.string.station_china));
        title.add(getResources().getString(R.string.station_foreign));
        fragments = new ArrayList<>();
        fragments.add(new ChinaStationFragment());
        fragments.add(new ForeignStationFragment());

    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.station_jcex);
        //下拉刷新
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        delegateAdapter.refresh(initData());
                        refreshLayout.finishRefresh();
                    }
                }, 2000);
            }
        });
//        mSmartRefreshLayout.setRefreshHeader(new ClassicsHeader(this));
        mSmartRefreshLayout.setHeaderHeight(50);

        //触发自动刷新
        if (isFirstEnter) {
            isFirstEnter = false;
            mSmartRefreshLayout.autoRefresh();
        } else {

        }

        mTabLayout.addTab(mTabLayout.newTab().setText(title.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(title.get(1)));
        mViewPager.setCurrentItem(0);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//MODE_FIXED固定展示,MODE_SCROLLABLE滑动展示
        TabFragmentAdapter adapter = new TabFragmentAdapter(getActivity(), fragments, title, getChildFragmentManager());
        mViewPager.setAdapter(adapter);
        //让TableLayout和ViewPager进行联合
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(adapter);
        //给ViewPager设置页面切换监听 ,ViewPager和TableLayout配合使用，监听只能设置给TabLayout
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    protected void requestNetData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }

    @OnClick(R.id.et_search)
    public void onViewClicked() {

    }
}
