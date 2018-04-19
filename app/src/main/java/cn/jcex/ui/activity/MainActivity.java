package cn.jcex.ui.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jcex.R;
import cn.jcex.base.FragmentInstanceManager;
import cn.jcex.ui.fragment.HomeFragment;
import cn.jcex.ui.fragment.MineFragment;
import cn.jcex.ui.fragment.StationFragment;
import cn.jcex.ui.fragment.ToJoinFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;
    @BindView(R.id.rb_fragment_home)
    RadioButton mRbFragmentHome;
    @BindView(R.id.rb_fragment_join)
    RadioButton mRbFragmentJoin;
    @BindView(R.id.rb_fragment_station)
    RadioButton mRbFragmentStation;
    @BindView(R.id.rb_cfragment_mine)
    RadioButton mRbCfragmentMine;
    @BindView(R.id.rg_fragment)
    RadioGroup mRgFragment;

    private FragmentManager mFragmentManager;
    private long exitTime;
    //是否启用沉浸式状态栏
    private boolean isTranslucentStatusBar = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        mRgFragment.setOnCheckedChangeListener(this);
        mRgFragment.check(R.id.rb_fragment_home);
        // 标头 一体化
        if (isTranslucentStatusBar) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setTranslucentStatus(true);
            }
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.word_orange);//设置标题栏颜色
        }

    }

    //切换到底部导航的Fragment
    public void switchNavigationFragment(int checkedId) {
        mRgFragment.check(checkedId);
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
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {
            case R.id.rb_fragment_home:
                switchFragment(FragmentInstanceManager.getInstance().getFragment(HomeFragment.class));
                break;
            case R.id.rb_fragment_join:
                switchFragment(FragmentInstanceManager.getInstance().getFragment(ToJoinFragment.class));
                break;
            case R.id.rb_fragment_station:
                switchFragment(FragmentInstanceManager.getInstance().getFragment(StationFragment.class));
                break;
            case R.id.rb_cfragment_mine:
                switchFragment(FragmentInstanceManager.getInstance().getFragment(MineFragment.class));
                break;
            default:
                break;
        }
    }
    //提供方法切换Fragment，点击RadioButton的时候需要清空回退栈
    public void switchFragment(Fragment fragment) {

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        //循环的的pop回退栈
        int backStackEntryCount = mFragmentManager.getBackStackEntryCount();
        while (backStackEntryCount > 0) {
            mFragmentManager.popBackStack();
            backStackEntryCount--;
        }
        transaction .setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        transaction.replace(R.id.fl_container, fragment);
        transaction.commit();
    }

    /**
     * 如果Fragment任务栈里有任务 则执行Fragment的回退
     * 如果任务栈为空则响应activity的回退事件
     */
    @Override
    public void onBackPressed() {
        mFragmentManager.popBackStack();
        if (mFragmentManager.getBackStackEntryCount() == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        }
    }
}

