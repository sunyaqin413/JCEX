package cn.jcex.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import butterknife.ButterKnife;
import cn.jcex.R;
import cn.jcex.global.CommonJCData;
import cn.jcex.global.JCApplication;
import cn.jcex.view.dialog.SweetAlertDialog;

/**
 * 类描述: Fragment的基类
 *
 * @author Sunyaqin
 * @data 2018-03-30  16:40
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";

    protected Activity mActivity;//当做Context去使用, MainActivity
    protected View mViewRoot;

    //布局视图资源名称
    private int layoutRes;
    // 公共业务数据.
    private CommonJCData commonData;
    public SweetAlertDialog dialog;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JCApplication application=JCApplication.getJcApplication();
        commonData = application.getCommonData();
        mActivity = getActivity();
        dialog = new SweetAlertDialog(getContext(),SweetAlertDialog.NORMAL_TYPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //判断为空，为空就去加载布局，onCreateView在界面切换的时候会被多次调用,防止界面跳转回来的时候显示空白
        if (mViewRoot == null) {
            mViewRoot =  createView(inflater, container, savedInstanceState);
            ButterKnife.bind(this,mViewRoot);
            initData();
            //初始化控件属性
            initViewsOnCreate();
            requestNetData();

            mViewRoot.setFocusable(true);
            mViewRoot.setFocusableInTouchMode(true);
            mViewRoot.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        //不一定是要触发返回栈，可以做一些其他的事情，我只是举个栗子。
                        getActivity().onBackPressed();
                        return true;
                    }
                    return false;
                }
            });
        }
        return mViewRoot;
    }


    //提供方法Fragment切换方法
    public void swichToChildFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (addToBackStack) {
            //添加回退栈
            Log.e(TAG, "swichToChildFragment: 添加到回退栈" + fragment.getClass().getSimpleName());
            transaction.addToBackStack(fragment.getTag());
        } else {
            if (fragment.isAdded()) {
                Log.e(TAG, "swichToChildFragment: 移除" + fragment.getClass().getSimpleName());
                transaction.remove(fragment);
            }
        }
        transaction.replace(R.id.fl_container, fragment);
        transaction.commit();
    }

    public void swichToChildFragment(Fragment fragment, boolean addToBackStack, Bundle bundle) {
        fragment.setArguments(bundle);
        swichToChildFragment(fragment, addToBackStack);
    }

    //切换到底部导航的Fragment
    public void switchNavigationFragment(int checkedId) {

    }
    /**
     * 创建 fragment 对应的 View
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    abstract protected View createView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState);


    /**
     * 初始化控件的数据
     */
    protected abstract void initData();
    /**
     * 初始化控件属性.
     *  initData()初始化业务参数之后执行.如绑定控件事件，设置控件基本属性.
     */
    protected abstract void initViewsOnCreate();


    /**
     * 请求网络数据
     */
    protected abstract void requestNetData();

    private int getLayoutRes() {
        return layoutRes;
    }

    /**
     * 设置视图资源名称.
     *
     * @param layoutRes 布局资源
     */
    public void setLayoutRes(@LayoutRes int layoutRes) {
        this.layoutRes = layoutRes;
    }

    //当前的界面被切换出去的时候被调用,解决ViewGroup只有一个子View的bug
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mViewRoot != null) {
            ViewParent parent = mViewRoot.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(mViewRoot);
            }
        }
    }



}
