package cn.jcex.ui.fragment.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
 * 类描述:偏远查询
 *
 * @author sunyaqin
 * @version 1.0
 * @data 2018/4/10  15:44
 */

public class RemoteQueryFragment extends BaseFragment {
    private static final int REQUEST_DESTINATION = 105;
    private static final int REQUEST_TRANSPORT = 106;
    private static final int REQUEST_TYPE = 107;
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.iv_top_scan)
    ImageView mIvTopScan;
    @BindView(R.id.tv_remote_class)
    TextView mTvRemoteClass;
    @BindView(R.id.rl_select_class)
    RelativeLayout mRlSelectClass;
    @BindView(R.id.tv_destination)
    TextView mTvDestination;
    @BindView(R.id.rl_select_country)
    RelativeLayout mRlSelectCountry;
    @BindView(R.id.et_postcode)
    EditText mEtPostcode;
    @BindView(R.id.et_address)
    EditText mEtAddress;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;

    private List<CalcuatePriceElseBean> mDatas;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remote_query, null);
        return view;
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<>();

    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.home_remote_query);
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
                    mTvDestination.setText(str);
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
            case REQUEST_TYPE:
                if (resultCode != Activity.RESULT_OK) {
                    return;
                } else {
                    String str = data.getStringExtra(CommonJCData.PACKAGE_TYPE);
                    L.d("HOME", "包裹类型:" + str);
//                    mTvTransportMode.setText(str);
                }
                break;
        }

    }


    @OnClick({R.id.tv_left, R.id.rl_select_class, R.id.rl_select_country, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left:
                getFragmentManager().popBackStack();
                getActivity().finish();
                break;
            case R.id.rl_select_class://
                SelectOrderTypeFragment orderTypeFragment = new SelectOrderTypeFragment();
                orderTypeFragment.setTargetFragment(RemoteQueryFragment.this, REQUEST_TYPE);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, orderTypeFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.rl_select_country:
                SelectDestinationFragment fragment = new SelectDestinationFragment();
                fragment.setTargetFragment(RemoteQueryFragment.this, REQUEST_DESTINATION);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, fragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_submit:
                T.showShort(getActivity(), "查询结果:");
                break;
        }
    }
}
