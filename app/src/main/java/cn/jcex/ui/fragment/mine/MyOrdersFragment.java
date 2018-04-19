package cn.jcex.ui.fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.adapter.MineOrderAdapter;
import cn.jcex.base.BaseFragment;

import static android.app.Activity.RESULT_OK;

/**
 * 类描述:
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/13  10:03
 */

public class MyOrdersFragment extends BaseFragment {
    private static final int REQUEST_CODE = 201;
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.tv_right)
    TextView mTvRight;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    private List<String> mDatas;


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_orders, null);
        return view;
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();
    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.mine_order);
        mTvLeft.setVisibility(View.VISIBLE);
        mTvRight.setVisibility(View.VISIBLE);
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

    @OnClick({R.id.tv_left, R.id.tv_right, R.id.tv_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left://返回
                getActivity().onBackPressed();
                getActivity().finish();
                break;
            case R.id.tv_right://回收箱

                break;
            case R.id.tv_scan://扫描
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                getActivity().startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

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
}
