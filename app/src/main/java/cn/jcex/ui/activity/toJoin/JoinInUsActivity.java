package cn.jcex.ui.activity.toJoin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.base.BaseActivity;
import cn.jcex.view.dialog.SweetAlertDialog;

/**
 * 类描述：加入我们.
 *
 * @author sunyaqin
 * @version 1.0
 * @date 2018/04/13 14:07
 */

public class JoinInUsActivity extends BaseActivity {

    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_email)
    EditText mEtEmail;
    @BindView(R.id.et_address)
    EditText mEtAddress;
    @BindView(R.id.et_money)
    EditText mEtMoney;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.btn_01)
    Button mBtn01;
    @BindView(R.id.btn_02)
    Button mBtn02;
    @BindView(R.id.btn_03)
    Button mBtn03;
    @BindView(R.id.btn_submit)
    Button mBtnSubmit;
    @BindView(R.id.rg_contact)
    RadioGroup mRgContact;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_join_us);
        mTvHeader.setText(R.string.join_to_jcex_request);
        mTvLeft.setVisibility(View.VISIBLE);
        mRgContact.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_01:

                        break;
                    case R.id.btn_02:

                        break;
                    case R.id.btn_03:

                        break;
                }
            }
        });
        String name = mEtName.getText().toString().trim();
        String phone = mEtPhone.getText().toString().trim();
        String email = mEtEmail.getText().toString().trim();
        String address = mEtAddress.getText().toString().trim();
        String price = mEtMoney.getText().toString().trim();
    }

    @Override
    protected void initParams() {

    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv_left, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left://返回
                finish();
                break;
            case R.id.btn_submit://提交
                progressDialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                progressDialog.setTitleText("预约成功,稍后客服会联系您!").show();
                break;
        }
    }
}

