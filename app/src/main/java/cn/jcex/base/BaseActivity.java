package cn.jcex.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.lang.ref.WeakReference;

import cn.jcex.R;
import cn.jcex.global.CommonJCData;
import cn.jcex.global.JCApplication;
import cn.jcex.view.dialog.SweetAlertDialog;

/**
 * 类描述:activity
 *
 * @author Sunyaqin
 * @data 2018-03-30  16:39
 */

public abstract class BaseActivity extends FragmentActivity {
    /**
     * 日志标记.
     */
    protected final String TAG = this.getClass().getSimpleName();
    // 当前上下文.
    private Context context;
    // 应用全局的实例
    private JCApplication jcApplication;
    // 公共业务数据
    private CommonJCData commonData;

    //当前Activity的弱引用，防止内存泄露
    private WeakReference<Activity> activityWeakReference;

    //是否启用沉浸式状态栏
    private boolean isTranslucentStatusBar = true;

    //加载框
    public SweetAlertDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        jcApplication = JCApplication.getJcApplication();
        commonData = jcApplication.getCommonData();

        //将当前Activity压入栈
        activityWeakReference = new WeakReference<Activity>(this);
        jcApplication.pushTask(activityWeakReference);

        // 标头 一体化
        if (isTranslucentStatusBar) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setTranslucentStatus(true);
            }
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.word_orange);//设置标题栏颜色
        }

        //初始化加载框
        progressDialog = new SweetAlertDialog(getContext(), SweetAlertDialog.NORMAL_TYPE);

        //初始化参数
        initParams();
        //初始化view
        initView();
    }

    protected abstract void initView();

    protected abstract void initParams();

    /**
     * @return 当前Activity的Context.
     */
    protected Context getContext() {
        return context;
    }

    /**
     * @return 当前应用全局的实例.
     */
    public JCApplication getJCApplication() {
        return jcApplication;
    }

    /**
     * @return 获取公共业务数据.
     */
    public CommonJCData getCommonData() {
        return commonData;
    }

    /**
     * @return 当前Activity.
     */
    protected Activity getActivity() {
        if (null != activityWeakReference) {
            return activityWeakReference.get();
        } else {
            return null;
        }
    }

    /**
     * 设置是否启用沉浸式状态栏.
     *
     * @param translucentStatusBar 启用状态
     */
    public void setTranslucentStatusBar(boolean translucentStatusBar) {
        isTranslucentStatusBar = translucentStatusBar;
    }

    /**
     * 设置标题栏一体化.
     *
     * @param on
     */
    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();

        if (on) {
            Window window = getWindow();

            // 设置状态栏透明
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        // 设置导航栏透明
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

    }

    /**
     * 显示加载框.
     */
    public void showProgressDialog() {
        if (progressDialog != null && !getActivity().isFinishing()) {
            progressDialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
            progressDialog.show();
        }
    }

    /**
     * 关闭加载框.
     */
    public void closeProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
