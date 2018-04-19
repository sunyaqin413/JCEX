package cn.jcex.ui.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jcex.R;
import cn.jcex.base.BaseActivity;
import cn.jcex.view.CheckSwitchButton;

/**
 * 类描述：设置页面.
 *
 * @author sunyaqin
 * @version 1.0
 * @date 2018/04/13 14:07
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tv_left)
    TextView mTvLeft;
    @BindView(R.id.tv_header)
    TextView mTvHeader;
    @BindView(R.id.chkBtn_setting_sound)
    CheckSwitchButton mChkBtnSettingSound;
    @BindView(R.id.chkBtn_setting_vibration)
    CheckSwitchButton mChkBtnSettingVibration;
    @BindView(R.id.rl_setting_vibration)
    RelativeLayout mRlSettingVibration;
    @BindView(R.id.rl_feedback)
    RelativeLayout mRlFeedback;
    @BindView(R.id.rl_version)
    RelativeLayout mRlVersion;
    @BindView(R.id.rl_setting_about)
    RelativeLayout mRlSettingAbout;
    @BindView(R.id.btn_setting_logout)
    Button mBtnSettingLogout;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_setting);
        mTvHeader.setText(R.string.mine_setting);
        mTvLeft.setVisibility(View.VISIBLE);

        //添加消息声音设置改变监听
        mChkBtnSettingSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });

        //添加消息振动设置改变监听
        mChkBtnSettingVibration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });


    }

    @Override
    protected void initParams() {

    }


    // 是否打开声音


    @Override
    public void onResume() {
        super.onResume();
//        updateCacheSize();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_left, R.id.rl_feedback, R.id.rl_version, R.id.rl_setting_about, R.id.btn_setting_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_left://返回
                finish();
                break;
            case R.id.rl_feedback://意见反馈

                break;
            case R.id.rl_version://版本

                break;
            case R.id.rl_setting_about://关于

                break;
            case R.id.btn_setting_logout://退出登录

                break;
        }
    }

//    @Override
//    public void onClick(View view) {
//        Intent intent;
//        switch (view.getId()) {
//            case R.id.lv_common_top_back: {
//                this.finish();
//                break;
//            }
//            //消息声音
//            case R.id.rl_setting_sound: {
//                mChkBtnMessageSound.setChecked(!mChkBtnMessageSound.isChecked());
//
//                break;
//            }
//            //消息振动
//            case R.id.rl_setting_vibration: {
//                mChkBtnMessageVibration.setChecked(!mChkBtnMessageVibration.isChecked());
//                break;
//            }
//            //修改密码
//            case R.id.rl_setting_modify_password: {
//                intent = new Intent(getContext(), ModifyPasswordActivity.class);
//                startActivity(intent);
//                break;
//            }
//
//
//            //修改手机号
//            case R.id.rl_setting_modify_phone_num: {
//                doModifyPhoneNum();
//                break;
//            }
//            //清空缓存
//            case R.id.rl_setting_clean: {
//                cleanCache();
//                break;
//            }
//            //关于
//            case R.id.rl_setting_about: {
//                intent = new Intent(getContext(), AboutActivity.class);
//                startActivity(intent);
//                break;
//            }
//            //检查更新
//            case R.id.btn_setting_check_update: {
//                if (numberProgressBar.getVisibility() != View.VISIBLE) {
//                    numberProgressBar.setVisibility(View.VISIBLE);
//                }
//                checkUpdate();
//                break;
//            }
//            //注销
//            case R.id.btn_setting_logout: {
//                doLogout();
//                break;
//            }
//
//        }
//    }


    /**
     * 修改手机号.
     */
//    private void doModifyPhoneNum() {
//        new SweetAlertDialog(getContext(), SweetAlertDialog.NORMAL_TYPE)
//                .setTitleText("提示").setContentText(getString(R.string.modify_phone_num_alert)).show();
//    }

    /**
     * 更新缓存大小.
     */
//    private void updateCacheSize() {
//        try {
//            String size = DataCleanUtil.getCacheSize(ImageLoader.getInstance().getDiskCache().getDirectory().getParentFile());
//            mTvCacheSize.setText(size);
//        } catch (Exception e) {
//            Log.e(TAG, e.getLocalizedMessage());
//            mTvCacheSize.setText("0KB");
//        }
//    }

    /**
     * 清空缓存.
     */
//    private void cleanCache() {
//        dialog = new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE);
//        dialog.setTitleText(getString(R.string.clean_cache_warning));
//        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//            @Override
//            public void onClick(SweetAlertDialog sweetAlertDialog) {
//                DataCleanUtil.cleanInternalCache(getContext());
//                ImageLoader.getInstance().clearDiskCache();
//                ImageLoader.getInstance().clearMemoryCache();
//
//                updateCacheSize();
//                dialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
//                dialog.setTitleText(getString(R.string.clean_cache_success));
//                dialog.dismiss();
//            }
//        });
//        dialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//            @Override
//            public void onClick(SweetAlertDialog sweetAlertDialog) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }

    /**
     * 检查更新.
     */
//    private void checkUpdate() {
//
//        new InstallUtils(getContext(), APK_URL, CACHE_FILE_PATH, APK_NAME, new InstallUtils.DownloadCallBack() {
//            @Override
//            public void onStart() {
//                L.i(TAG, "onStart");
//                numberProgressBar.setProgress(0);
//            }
//
//            @Override
//            public void onComplete(String path) {
//                L.d(TAG, "onComplete:" + path);
//                InstallUtils.installAPK(getContext(), path);
//                numberProgressBar.setProgress(100);
//            }
//
//            @Override
//            public void onLoading(long total, long current) {
//                L.d(TAG, "onLoading:-----total:" + total + ",current:" + current);
//                numberProgressBar.setProgress((int) (current * 100 / total));
//            }
//
//            @Override
//            public void onFail(Exception e) {
//                if (numberProgressBar.getVisibility() != View.GONE) {
//                    numberProgressBar.setVisibility(View.GONE);
//                }
//
//                /**
//                 * 下载的错误信息.
//                 */
//                String eMessage = "下载失败!";
//                showProgressDialog();
//                progressDialog.changeAlertType(SweetAlertDialog.NORMAL_TYPE);
//
//                if (null != e.getMessage() && !"".equals(e.getMessage())) {
//                    if (e.getMessage().contains("ENETUNREACH")) {
//                        eMessage = "请检查网络连接";
//                    } else if (e.getMessage().contains("http")) {
//                        eMessage = "下载最新版本失败";
//                    }
//                } else {
//                    eMessage = "下载最新版本失败!";
//                }
//                L.d(TAG, "onFail:" + e.getMessage() + "eMessage:" + eMessage);
//
//                progressDialog.setTitleText("提示").setContentText(eMessage);
//            }
//        }).downloadAPK();
//    }

    /**
     * 注销登录.
     */
//    private void doLogout() {
//        progressDialog.setTitleText(getString(R.string.Are_logged_out));
//        showProgressDialog();
//
//        EaseHelper.getInstance().logout(false, new com.hyphenate.EMCallBack() {
//            @Override
//            public void onSuccess() {
//                getActivity().runOnUiThread(new Runnable() {
//                    public void run() {
//                        closeProgressDialog();
//
//                        //清除记录的账号
//                        SharedPrefsUtil.removeValue(getContext(), SharedPrefsUtil.SHARED_KEY_PASSWORD);
//
//                        EMClient.getInstance().logout(true, new EMCallBack() {
//
//                            @Override
//                            public void onSuccess() {
//                            }
//
//                            @Override
//                            public void onProgress(int progress, String status) {
//
//                            }
//                            @Override
//                            public void onError(int code, String message) {
//
//                            }
//                        });
//                        // 关闭当前页面
//                        setResult(SETTING_LOGOUT_RESULT_OK);
//                        finish();
//                    }
//                });
//            }
//
//            @Override
//            public void onError(int i, String s) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        closeProgressDialog();
//                        SharedPrefsUtil.removeValue(getContext(), SharedPrefsUtil.SHARED_KEY_PASSWORD);
//                        setResult(SETTING_LOGOUT_RESULT_ERROR);
//                        finish();
//                    }
//                });
//            }
//
//            @Override
//            public void onProgress(int i, String s) {
//
//            }
//        });
//    }
}

