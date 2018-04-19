package cn.jcex.ui.fragment.home;

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
import cn.jcex.adapter.MessageAdapter;
import cn.jcex.base.BaseFragment;

/**
 * 类描述:消息fragment
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/10  15:19
 */

public class MessageFragment extends BaseFragment {

    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    private List<String> mDatas;


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, null);
        return view;
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();
        mDatas.add("异常运单号:5241522处理成功!");
    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText("消息");
        mTvLeft.setVisibility(View.VISIBLE);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        BaseQuickAdapter adapter=new MessageAdapter(R.layout.item_message,mDatas);
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
            case R.id.tv_left://取消 回退
                getActivity().onBackPressed();
                break;
        }
    }

}
