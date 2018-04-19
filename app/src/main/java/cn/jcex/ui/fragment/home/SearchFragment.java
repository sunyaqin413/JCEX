package cn.jcex.ui.fragment.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
import cn.jcex.utils.KeyBoardUtil;

/**
 * 类描述:
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/10  15:19
 */

public class SearchFragment extends BaseFragment {
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViewsOnCreate() {
        KeyBoardUtil.openKeyboard(getContext(),mEtSearch);

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



    @OnClick({ R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel://取消 回退
               getActivity().onBackPressed();
                break;
        }
    }
}
