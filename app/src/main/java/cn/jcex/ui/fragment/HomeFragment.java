package cn.jcex.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sunfusheng.marqueeview.MarqueeView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jcex.R;
import cn.jcex.base.BaseDelegateAdapter;
import cn.jcex.base.BaseFragment;
import cn.jcex.ui.activity.home.CalculatePriceActivity;
import cn.jcex.ui.activity.home.DeliveryGoodsApplicationActivity;
import cn.jcex.ui.activity.home.ForecastOrderActivity;
import cn.jcex.ui.activity.home.MessageActivity;
import cn.jcex.ui.activity.home.RemoteQueryActivity;
import cn.jcex.ui.activity.home.SearchActivity;
import cn.jcex.utils.GlideImageLoader;

import static android.app.Activity.RESULT_OK;
import static cn.jcex.ui.fragment.HomeFragment.Config.BANNER_VIEW_TYPE;
import static cn.jcex.ui.fragment.HomeFragment.Config.GRID_ITEM_TYPE;
import static cn.jcex.ui.fragment.HomeFragment.Config.IMG_URLS;
import static cn.jcex.ui.fragment.HomeFragment.Config.ITEM_NAMES;
import static cn.jcex.ui.fragment.HomeFragment.Config.ITEM_URL;
import static cn.jcex.ui.fragment.HomeFragment.Config.MENU_VIEW_TYPE;
import static cn.jcex.ui.fragment.HomeFragment.Config.NEWS_VIEW_TYPE;
import static cn.jcex.ui.fragment.HomeFragment.Config.TITLE_VIEW_TYPE;


/**
 * 类描述:首页
 *
 * @author Sunyaqin
 * @data 2018-03-30  17:49
 */

public class HomeFragment extends BaseFragment {

    private static final int REQUEST_CODE = 101;
    private static boolean isFirstEnter = true;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;
    private List<DelegateAdapter.Adapter> adapters;


    interface Config {
        //不同item必须不同的viewtype
        int TITLE_VIEW_TYPE = 1;
        int BANNER_VIEW_TYPE = 2;
        int MENU_VIEW_TYPE = 3;
        int NEWS_VIEW_TYPE = 4;
        int GRID_ITEM_TYPE = 5;
        int[]  IMG_URLS={R.mipmap.icon_home_menu1,R.mipmap.icon_home_menu2,R.mipmap.icon_home_menu3,R.mipmap.icon_home_menu4};
        String[] ITEM_NAMES = {"预报订单", "价格试算", "偏远查询", "提货申请"};
        int[] ITEM_URL = { R.mipmap.home_product_1,R.mipmap.home_product_2, R.mipmap.home_product_3,R.mipmap.home_product_4, R.mipmap.home_product_5, R.mipmap.home_product_6};
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        return view;
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initViewsOnCreate() {
        //1,初始化
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        mRecycleView.setLayoutManager(virtualLayoutManager);
        //home_product_1,设置缓存view个数
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycleView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);
        //3,RecylerView创建适配器，初始化DelegateAdapter
        final DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);

        //4,创建adapter，并继承DelegateAdapter.Adapter
        adapters = new LinkedList<>();
        //添加搜索头
        addTitleSearchAdapter();
        //添加滚动广告
        addBannerAdapter();
        //添加分类功能
        addGridItemAdapter();
        //添加滚动新闻条
        addNewsAdapter();
        //添加grid布局
//        addGridLayoutAdapter();
        //添加专线介绍
        addGridItemImgAdapter();
        //添加所有的adapter
        delegateAdapter.setAdapters(adapters);
        mRecycleView.setAdapter(delegateAdapter);
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
    }


    /**
     * 添加搜索头
     */
    private void addTitleSearchAdapter() {

        BaseDelegateAdapter titleAdapter = new BaseDelegateAdapter(getActivity(), new FixLayoutHelper(20, 20), R.layout.vlayout_title, 1, TITLE_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ImageView mIvScan = holder.getView(R.id.iv_scan);
                EditText mEtSearch = holder.getView(R.id.et_search);
                ImageView mIvMsg = holder.getView(R.id.iv_msg);
                //扫描识别
                mIvScan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), CaptureActivity.class);
                        getActivity().startActivityForResult(intent, REQUEST_CODE);
                    }
                });
                //搜索
                mEtSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), SearchActivity.class);
                        getActivity().startActivity(intent);
//                        swichToChildFragment(FragmentInstanceManager.getInstance().getFragment(SearchFragment.class), true);
                    }
                });
                //消息
                mIvMsg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), MessageActivity.class);
                        getActivity().startActivity(intent);
                    }
                });
            }
        };
        adapters.add(titleAdapter);
    }
    /**
     * 处理二维码扫描结果
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                if (requestCode == REQUEST_CODE) {
                    //处理扫描结果（在界面上显示）
                    if (null != data) {
                        Bundle bundle = data.getExtras();
                        if (bundle == null) {
                            return;
                        }
                        if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                            String result = bundle.getString(CodeUtils.RESULT_STRING);
                            Toast.makeText(getActivity(), "解析二维码成功:" + result, Toast.LENGTH_SHORT).show();
                        } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {

                            Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
        }
    }

    /**
     * 添加广告条
     */
    private void addBannerAdapter() {
        BaseDelegateAdapter bannerAdapter = new BaseDelegateAdapter(getActivity(), new SingleLayoutHelper(), R.layout.vlayout_banner, 1, BANNER_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(R.mipmap.pic_home_banner_1);
                arrayList.add(R.mipmap.pic_home_banner_1);
                arrayList.add(R.mipmap.pic_home_banner_1);
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
     * 添加功能分类
     */
    private void addGridItemAdapter() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setPadding(10, 10, 10, 10);
        gridLayoutHelper.setVGap(10);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(10);// 控制子元素之间的水平间距
        gridLayoutHelper.setBgColor(Color.WHITE);
        BaseDelegateAdapter menuAdapter = new BaseDelegateAdapter(getActivity(), gridLayoutHelper, R.layout.vlayout_menu, 4, MENU_VIEW_TYPE) {

            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                holder.setText(R.id.tv_menu_title_home, ITEM_NAMES[position] + "");
                holder.setImageResource(R.id.iv_menu_home, IMG_URLS[position]);
                holder.getView(R.id.ll_menu_home).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                         Intent intent;
                        switch (position) {
                            case 0://预报订单
                                intent = new Intent(getActivity(), ForecastOrderActivity.class);
                                getActivity().startActivity(intent);
                                break;
                            case 1://价格试算
                                 intent = new Intent(getActivity(), CalculatePriceActivity.class);
                                getActivity().startActivity(intent);
                                break;
                            case 2://偏远查询
                                 intent = new Intent(getActivity(), RemoteQueryActivity.class);
                                getActivity().startActivity(intent);
                                break;
                            case 3://提货申请
                                 intent = new Intent(getActivity(), DeliveryGoodsApplicationActivity.class);
                                getActivity().startActivity(intent);
                                break;

                        }

                    }
                });
            }
        };
        adapters.add(menuAdapter);
    }

    /**
     * 滚动新闻条
     */
    private void addNewsAdapter() {
        //news
        BaseDelegateAdapter newsAdapter = new BaseDelegateAdapter(getActivity(), new LinearLayoutHelper()
                , R.layout.vlayout_news, 1, NEWS_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                MarqueeView marqueeView1 = holder.getView(R.id.marqueeView1);

                List<String> info1 = new ArrayList<>();
                info1.add("这个是用来搞笑的，不要在意这写小细节！");
                info1.add("这个是用来搞笑的，不要在意这写小细节！");
                info1.add("这个是用来搞笑的，不要在意这写小细节！");

                marqueeView1.startWithList(info1);
                // 在代码里设置自己的动画
                marqueeView1.startWithList(info1, R.anim.anim_bottom_in, R.anim.anim_top_out);

                marqueeView1.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, TextView textView) {
                        Toast.makeText(getActivity(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        adapters.add(newsAdapter);
    }



    /**
     * 布局
     */
//    private void addGridLayoutAdapter() {
//
//        OnePlusNLayoutHelper gridLayoutHelper1 = new OnePlusNLayoutHelper();
//        gridLayoutHelper1.setRowWeight(50f);
//        gridLayoutHelper1.setColWeights(new float[]{50f});
//        BaseDelegateAdapter girdAdapter = new BaseDelegateAdapter(getActivity(), gridLayoutHelper1, R.layout.vlayout_grid
//                , , GRID_VIEW_TYPE) {
//            @Override
//            public void onBindViewHolder(BaseViewHolder holder, final int position) {
//                super.onBindViewHolder(holder, position);
//                int item = GRID_URL[position];
//                ImageView iv = holder.getView(R.id.iv);
//                Glide.with(getContext()).load(item).into(iv);
//                iv.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(getActivity(), "item" + position, Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        };
//        adapters.add(girdAdapter);
//    }




    /**
     * 产品介绍
     */
    private void addGridItemImgAdapter() {
        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
        gridLayoutHelper1.setMargin(0, 0, 0, 0);
        gridLayoutHelper1.setPadding(0, 0, 0, 0);
        gridLayoutHelper1.setVGap(10);// 控制子元素之间的垂直间距
        gridLayoutHelper1.setHGap(10);// 控制子元素之间的水平间距
        BaseDelegateAdapter itemAdapter = new BaseDelegateAdapter(getActivity(), gridLayoutHelper1, R.layout.vlayout_grid
                , 6, GRID_ITEM_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                int item = ITEM_URL[position];
                ImageView iv = holder.getView(R.id.iv);
                Glide.with(getContext()).load(item).into(iv);
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
}
