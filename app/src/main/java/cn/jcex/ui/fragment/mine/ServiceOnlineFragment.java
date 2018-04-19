package cn.jcex.ui.fragment.mine;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.adapter.ServiceOnlineAdapter;
import cn.jcex.base.BaseFragment;
import cn.jcex.utils.T;

/**
 * 类描述:
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/13  10:03
 */

public class ServiceOnlineFragment extends BaseFragment {
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    private List<String> mDatas;


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service_online, null);
        return view;
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();
        mDatas.add("订单追踪");
        mDatas.add("运费计算");
        mDatas.add("偏远查询");
        mDatas.add("提货申请");
        mDatas.add("订单异常");
        mDatas.add("追踪查询");
        mDatas.add("追踪查询");
        mDatas.add("追踪查询");
    }

    @Override
    protected void initViewsOnCreate() {
        mRecycleView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        BaseQuickAdapter adapter = new ServiceOnlineAdapter(R.layout.item_service_online, mDatas);
        adapter.openLoadAnimation();
        mRecycleView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                T.showShort(getActivity(),mDatas.get(position));
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

    @OnClick({R.id.tv_left, R.id.tv_search, R.id.tv_service_people})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left://
                getActivity().onBackPressed();
                getActivity().finish();
                break;
            case R.id.tv_search://搜索

                break;
            case R.id.tv_service_people://人工客服

                break;
        }
    }
}
