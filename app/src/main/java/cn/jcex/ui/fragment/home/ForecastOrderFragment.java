package cn.jcex.ui.fragment.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.base.BaseFragment;
import cn.jcex.global.CommonJCData;
import cn.jcex.utils.L;
import cn.jcex.utils.T;
import cn.jcex.view.dialog.SweetAlertDialog;

/**
 * 类描述:预报订单
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/10  15:44
 */

public class ForecastOrderFragment extends BaseFragment {
    private static final int REQUEST_DESTINATION = 102;
    private static final int REQUEST_TRANSPORT = 103;
    private static final int REQUEST_TYPE = 104;
    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.tv_right)
    TextView mTvRight;
    @BindView(R.id.iv_top_scan)
    ImageView mIvTopScan;
    @BindView(R.id.tv_destination)
    TextView mTvDestination;
    @BindView(R.id.rl_select_destination)
    RelativeLayout mRlSelectDestination;
    @BindView(R.id.tv_transport_mode)
    TextView mTvTransportMode;
    @BindView(R.id.rl_select_transport_mode)
    RelativeLayout mRlSelectTransportMode;
    @BindView(R.id.tv_weight)
    EditText mTvWeight;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.tv_volume)
    EditText mTvVolume;
    @BindView(R.id.tv_order_id)
    EditText mTvOrderId;
    @BindView(R.id.rl_select_type)
    RelativeLayout mRlSelectType;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.recycleView)
    RecyclerView mRecycleView;
    @BindView(R.id.tv_name)
    EditText mTvName;
    @BindView(R.id.tv_count)
    EditText mTvCount;
    @BindView(R.id.et_price)
    EditText mEtPrice;
    @BindView(R.id.tv_add_info)
    TextView mTvAddInfo;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;
    @BindView(R.id.btn_save)
    Button mBtnSave;


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_order, null);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViewsOnCreate() {
        mTvHeader.setText(R.string.home_forecast_order_single);
//        mTvRight.setVisibility(View.VISIBLE);
        mTvLeft.setVisibility(View.VISIBLE);
//        mTvRight.setText(R.string.home_forecast_order_multi);

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

    @OnClick({R.id.tv_left, R.id.tv_right, R.id.rl_select_destination, R.id.rl_select_transport_mode,R.id.rl_select_type, R.id.tv_add_info, R.id.btn_submit, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left://返回
                dialog.changeAlertType(SweetAlertDialog.PROMPT_TYPE);
                dialog.setTitleText("已填写信息未保存,是否存为草稿?");
                dialog.showConfirmButton(true).showCancelButton(true).
                        setConfirmText("确定").setCancelText("不保存").show();
                dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        dialog.dismiss();
                        T.showShort(getActivity(), "已保存");
                        getFragmentManager().popBackStack();
                        getActivity().finish();
                    }
                });
                dialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        dialog.dismiss();
                        getFragmentManager().popBackStack();
                        getActivity().finish();
                    }
                });
                break;
            case R.id.tv_right://批量导入,暂留

                break;
            case R.id.rl_select_destination://选择目的地
                SelectDestinationFragment fragment=new SelectDestinationFragment();
                fragment.setTargetFragment(ForecastOrderFragment.this,REQUEST_DESTINATION);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, fragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.rl_select_transport_mode://选择运输方式
                SelectTransportModeFragment transportModeFragment=new SelectTransportModeFragment();
                transportModeFragment.setTargetFragment(ForecastOrderFragment.this,REQUEST_TRANSPORT);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, transportModeFragment)
                        .addToBackStack(null)
                        .commit();
            break;
            case R.id.rl_select_type://选择类型
                SelectOrderTypeFragment orderTypeFragment=new SelectOrderTypeFragment();
                orderTypeFragment.setTargetFragment(ForecastOrderFragment.this,REQUEST_TYPE);
                getFragmentManager().beginTransaction().replace(R.id.fl_containers, orderTypeFragment)
                        .addToBackStack(null)
                        .commit();
            break;
            case R.id.tv_add_info://添加申报信息

                break;
            case R.id.btn_submit://提交预报信息
                T.showShort(getActivity(), "提交成功");
                break;
            case R.id.btn_save://保存草稿
                  T.showShort(getActivity(), "已保存");

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_DESTINATION:
                if(resultCode != Activity.RESULT_OK){
                    return;
                }else{
                    String str = data.getStringExtra(CommonJCData.COUNTRY_NAME);
                    L.d("HOME","目的地:"+str);
                    mTvDestination.setText(str);
                }
                break;
                case REQUEST_TRANSPORT:
                if(resultCode != Activity.RESULT_OK){
                    return;
                }else{
                    String str = data.getStringExtra(CommonJCData.TRANSPORT_MODE);
                    L.d("HOME","运输方式:"+str);
                    mTvTransportMode.setText(str);
                }
                break;
        }

    }
}
