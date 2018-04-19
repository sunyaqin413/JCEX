package cn.jcex.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.base.BaseDelegateAdapter;
import cn.jcex.base.BaseFragment;
import cn.jcex.ui.activity.toJoin.JoinInUsActivity;
import cn.jcex.utils.GlideImageLoader;

import static cn.jcex.ui.fragment.ToJoinFragment.Config.BANNER_VIEW_TYPE;
import static cn.jcex.ui.fragment.ToJoinFragment.Config.ITEM_NAMES;
import static cn.jcex.ui.fragment.ToJoinFragment.Config.ITEM_URL;
import static cn.jcex.ui.fragment.ToJoinFragment.Config.MENU_VIEW_TYPE;

/**
 * 类描述: 加盟
 *
 * @author Sunyaqin
 * @data 2018-03-30  17:50
 */

public class ToJoinFragment extends BaseFragment {

    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.btn_join)
    Button mBtnJoin;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;
    private static boolean isFirstEnter = true;
    private List<DelegateAdapter.Adapter> adapters;
    interface Config {
        //不同item必须不同的viewtype
        int BANNER_VIEW_TYPE = 1;
        int MENU_VIEW_TYPE = 2;

        int[] ITEM_URL = {R.mipmap.icon_join_1, R.mipmap.icon_join_2, R.mipmap.icon_join_3, R.mipmap.icon_join_4,
                R.mipmap.icon_join_5, R.mipmap.icon_join_6};
        String[] ITEM_NAMES = {"加盟事项", "加盟区域", "佳成概况", "佳成资源","合作单位","加盟热线"};
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_join, null);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.join_to_jcex);
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
            mRecycleView.getAdapter().notifyDataSetChanged();
        }
        //1,初始化
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        mRecycleView.setLayoutManager(virtualLayoutManager);
        //home_product_1,设置缓存view个数
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycleView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        //3,RecylerView创建适配器，初始化DelegateAdapter
        final DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        //4,创建adapter，并继承DelegateAdapter.Adapter
        adapters = new LinkedList<>();
        //添加滚动广告
        addBannerAdapter();
        //添加专线介绍
        addGridItemImgAdapter();
        //添加所有的adapter
        delegateAdapter.setAdapters(adapters);
        mRecycleView.setAdapter(delegateAdapter);
    }
    /**
     * 添加广告条
     */
    private void addBannerAdapter() {
        BaseDelegateAdapter bannerAdapter = new BaseDelegateAdapter(getActivity(), new SingleLayoutHelper(), R.layout.vlayout_join_banner, 1, BANNER_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(R.mipmap.pic_join_banner);
                arrayList.add(R.mipmap.pic_join_banner);
                arrayList.add(R.mipmap.pic_join_banner);
                // 绑定数据
                Banner mBanner = holder.getView(R.id.banner);
                //设置banner样式
                mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置图片加载器
                mBanner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                mBanner.setImages(arrayList);
                //设置banner动画效果
                mBanner.setBannerAnimation(Transformer.DepthPage);
                //设置标题集合（当banner样式有显示title时）
                //        mBanner.setBannerTitles(titles);
                //设置自动轮播，默认为true
                mBanner.isAutoPlay(true);
                //设置轮播时间
                mBanner.setDelayTime(3000);
                //设置指示器位置（当banner模式中有指示器时）
                mBanner.setIndicatorGravity(BannerConfig.CENTER);
                //banner设置方法全部调用完毕时最后调用
                mBanner.start();
                mBanner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(getActivity(), "banner点击了" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        };
        adapters.add(bannerAdapter);
    }
    /**
     *
     */
    private void addGridItemImgAdapter() {
        GridLayoutHelper gridLayoutHelper= new GridLayoutHelper(2);
        gridLayoutHelper.setPadding(10, 10, 10, 10);
        gridLayoutHelper.setVGap(5);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(10);// 控制子元素之间的水平间距
        BaseDelegateAdapter itemAdapter = new BaseDelegateAdapter(getActivity(), gridLayoutHelper, R.layout.vlayout_join_menu
                , 6, MENU_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                int item = ITEM_URL[position];
                ImageView iv = holder.getView(R.id.iv_menu);
                TextView tv = holder.getView(R.id.tv_menu_title);
                Glide.with(getContext()).load(item).into(iv);
                tv.setText(ITEM_NAMES[position]);
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getActivity(), "item" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        adapters.add(itemAdapter);
    }


    @Override
    protected void requestNetData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @OnClick(R.id.btn_join)
    public void onViewClicked() {
          //我要加盟
        Intent intent=new Intent(getContext(), JoinInUsActivity.class);
        getActivity().startActivity(intent);
    }
}
