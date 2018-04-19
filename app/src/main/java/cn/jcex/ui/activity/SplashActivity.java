package cn.jcex.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jcex.R;
import cn.jcex.base.BaseActivity;


/**
 * 类描述: 闪屏页面
 *
 * @author Sunyaqin
 * @data 2018-03-30  18:40
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.iv_splash)
    ImageView mIvSplash;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams();
        initView();
    }


    @Override
    protected void initParams() {

    }
    @Override
    protected void initView() {
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }


        // 渐变展示启动屏
        AlphaAnimation animation = new AlphaAnimation(0.2f, 1.0f);
        animation.setDuration(1500);
        animation.setFillAfter(true);
        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1500);
        scaleAnimation.setFillAfter(true);
        //动画集合
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(animation);
        set.addAnimation(scaleAnimation);
        //开启动画
        mIvSplash.startAnimation(set);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                doNext(MainActivity.class);
//                //已加载过引导页进入登录页面，否则进入引导页面
//                if (isGuided) {
//                    String loginName = SharedPrefsUtil.getValue(getContext(), SharedPrefsUtil.SHARED_KEY_USERNAME, null);
//                    String password = SharedPrefsUtil.getValue(getContext(), SharedPrefsUtil.SHARED_KEY_PASSWORD, null);
//
//                    if (!TextUtils.isEmpty(loginName) && !TextUtils.isEmpty(password)) {
//                        doLogin(loginName, password);
//                    } else {
//                        doNext(LoginActivity.class);
//                    }
//                } else {
//                    doNext(GuideActivity.class);
//                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }




    /**
     * 进入一下界面.
     */
    private void doNext(Class clazz) {
        Intent intent = new Intent(getApplicationContext(), clazz);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
    }

    /**
     *
     * @param loginName
     * @param password
     */
    private void doLogin(final String loginName, final String password) {


    }
}
