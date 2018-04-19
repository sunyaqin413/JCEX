package cn.jcex.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.jcex.R;
import cn.jcex.base.BaseActivity;
import cn.jcex.utils.StatusBarUtil;


/**
 * 类描述: 登录页面
 *
 * @author Sunyaqin
 * @data 2018-03-30  18:25
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarUtil.immersive(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initParams() {

    }

}
