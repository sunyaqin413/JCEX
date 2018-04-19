package cn.jcex.ui.fragment.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.base.BaseFragment;
import cn.jcex.bean.CalcuatePriceElseBean;
import cn.jcex.global.CommonJCData;
import cn.jcex.utils.L;
import cn.jcex.utils.T;

/**
 * 类描述:提货申请
 *
 * @author sunyaqin
 * @version 1.0
 * @data 2018/4/10  15:44
 */

public class DeliverApplicationFragment extends BaseFragment {
    private static final int REQUEST_DESTINATION = 105;
    private static final int REQUEST_TRANSPORT = 106;
    private static final int REQUEST_TYPE = 107;
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.rl_select_address)
    RelativeLayout mRlSelectAddress;
    @BindView(R.id.et_bags)
    EditText mEtBags;
    @BindView(R.id.et_weight)
    EditText mEtWeight;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.rl_select_time)
    RelativeLayout mRlSelectTime;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;


    private List<CalcuatePriceElseBean> mDatas;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliver_application, null);
        return view;
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();

    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.home_pick_up);
        mTvLeft.setVisibility(View.VISIBLE);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_DESTINATION:
                if (resultCode != Activity.RESULT_OK) {
                    return;
                } else {
                    String str = data.getStringExtra(CommonJCData.COUNTRY_NAME);
                    L.d("HOME", "目的地:" + str);
                }
                break;
            case REQUEST_TRANSPORT:
                if (resultCode != Activity.RESULT_OK) {
                    return;
                } else {
                    String str = data.getStringExtra(CommonJCData.TRANSPORT_MODE);
                    L.d("HOME", "运输方式:" + str);
//                    mTvTransportMode.setText(str);
                }
                break;


        }

    }


    @OnClick({R.id.tv_left, R.id.rl_select_address, R.id.rl_select_time, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                getFragmentManager().popBackStack();
                getActivity().finish();
                break;
            case R.id.rl_select_address:
                SelectOrderTypeFragment orderTypeFragment = new SelectOrderTypeFragment();
                orderTypeFragment.setTargetFragment(DeliverApplicationFragment.this, REQUEST_TYPE);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, orderTypeFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.rl_select_time:

                break;
            case R.id.btn_submit:
                T.showShort(getActivity(), "立即提交:");
                break;
        }
    }
}
