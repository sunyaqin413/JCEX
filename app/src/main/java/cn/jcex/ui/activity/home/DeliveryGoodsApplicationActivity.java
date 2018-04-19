package cn.jcex.ui.activity.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import cn.jcex.R;
import cn.jcex.base.BaseActivity;
import cn.jcex.base.FragmentInstanceManager;
import cn.jcex.ui.fragment.home.DeliverApplicationFragment;

/**
 * 类描述:提货申请activity
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/4/11  10:07
 */

public class DeliveryGoodsApplicationActivity extends BaseActivity {
    @Override
    protected void initView() {
        setContentView(R.layout.activity_fragment_instance);
      addFragment(FragmentInstanceManager.getInstance().getFragment(DeliverApplicationFragment.class),false);
    }

    @Override
    protected void initParams() {

    }
    /**
     * 添加Fragment.
     *
     * @param fragment 被添加的页面
     */
    private void addFragment(Fragment fragment,boolean addToBackStack) {
        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        if (addToBackStack) {
            //添加回退栈
            Log.e(TAG, "swichToChildFragment: 添加到回退栈" + fragment.getClass().getSimpleName());
            fTransaction.addToBackStack(fragment.getTag());
        } else {
            if (fragment.isAdded()) {
                Log.e(TAG, "swichToChildFragment: 移除" + fragment.getClass().getSimpleName());
                fTransaction.remove(fragment);
            }
        }
        fTransaction.replace(R.id.fl_containers, fragment);
        fTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
