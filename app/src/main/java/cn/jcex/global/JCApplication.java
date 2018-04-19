package cn.jcex.global;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.lang.ref.WeakReference;
import java.util.Stack;

import cn.jcex.R;


/**
 * 类描述:全局application
 *
 * @author Sunyaqin.
 * @data 2018-03-29 10:41:25
 */

public class JCApplication extends MultiDexApplication implements Thread.UncaughtExceptionHandler {
    private static JCApplication instance;
    private static JCApplication jcApplication;
    /**
     * 全局的上下文.
     */
    private Context context;

    /**
     * 寄存整个应用Activity.
     */
    private final Stack<WeakReference<Activity>> activitys = new Stack<>();
    /**
     * 公共业务数据.
     */
    private CommonJCData commonData;


    //下拉刷新 上拉加载
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new DeliveryHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }
    public static Context getAppContext(){
        return instance == null ? null : instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        jcApplication=this;
        context=this;
        //初始化zxing
        ZXingLibrary.initDisplayOpinion(this);
        //初始化百度地图
//        SDKInitializer.initialize(this);
    }
    /**
     * 获取工信应用的Application.
     *
     * @return nwApplication
     */
    public static JCApplication getJcApplication() {
        return jcApplication;
    }
    /**
     * 获取公共业务数据.
     *
     * @return commonData
     */
    public CommonJCData getCommonData() {
        return commonData;
    }
    /**
     * 将Activity压入Application栈.
     *
     * @param task 将要压入栈的Activity对象
     */
    public void pushTask(WeakReference<Activity> task) {
        activitys.push(task);
    }

    /**
     * 将传入的Activity对象从栈中移除.
     *
     * @param task 指定移除的Activity
     */
    public void removeTask(WeakReference<Activity> task) {
        activitys.remove(task);
    }

    /**
     * 根据指定位置从栈中移除Activity.
     *
     * @param taskIndex Activity栈索引
     */
    public void removeTask(int taskIndex) {
        if (activitys.size() > taskIndex)
            activitys.remove(taskIndex);
    }

    /**
     * 将栈中Activity移除至栈顶.
     */
    public void removeToTop() {
        int end = activitys.size();
        int start = 1;

        for (int i = end - 1; i >= start; i--) {
            Activity mActivity = activitys.get(i).get();
            if (null != mActivity && !mActivity.isFinishing()) {
                mActivity.finish();
            }
        }
    }

    /**
     * 移除全部（用于整个应用退出）.
     */
    public void removeAll() {
        for (WeakReference<Activity> task : activitys) {
            Activity mActivity = task.get();

            if (null != mActivity && !mActivity.isFinishing()) {
                mActivity.finish();
            }
        }
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        System.exit(0);
    }
}
