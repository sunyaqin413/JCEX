package cn.jcex.utils;

import android.util.Log;


/**
 * 类描述：Log统一管理类.
 *
 * @author 王徽生
 * @version 1.0
 * @date 2016/7/12 16:30
 */
public class L {
    /**
     * 是否打开.
     * 当测试时:true;
     * 发布版时:false;
     */
    public static boolean isShow =true;

    /**
     * 任何消息都会输出.
     *
     * @param tag 提示标志.
     * @param msg 显示的文本信息.
     */
    public static void v(String tag, String msg) {
        if (isShow) {
            Log.v(tag, msg);
        }
    }

    /**
     * 仅输出debug.
     *
     * @param tag 提示标志.
     * @param msg 显示的文本信息.
     */
    public static void d(String tag, String msg) {
        if (isShow) {
            Log.d(tag, msg);
        }
    }

    /**
     * 一般提示性的消息information.
     *
     * @param tag 提示标志.
     * @param msg 显示的文本信息.
     */
    public static void i(String tag, String msg) {
        if (isShow) {
            Log.e(tag, msg);
        }
    }

    /**
     * warning警告.
     *
     * @param tag 提示标志.
     * @param msg 显示的文本信息.
     */
    public static void w(String tag, String msg) {
        if (isShow) {
            Log.w(tag, msg);
        }
    }

    /**
     * error错误.
     *
     * @param tag 提示标志.
     * @param msg 显示的文本信息.
     */
    public static void e(String tag, String msg) {
        if (isShow) {
            Log.e("error:", msg);
        }
    }

    /**
     * error错误.
     *
     * @param tag 提示标志.
     * @param msg 显示的文本信息.
     * @param rg  具体的异常信息.
     */
    public static void e(String tag, String msg, Throwable rg) {
        if (isShow) {
            Log.e(tag, msg, rg);
        }
    }
}
