package cn.jcex.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 类描述：Toast统一管理类.
 *
 * @author 陈建邦
 * @date 2015/10/23 10:15
 * @version 1.0
 */
public class T {
    public static boolean isShow = true;

    private T() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 短时间显示Toast.
     *
     * @param context 上下文
     * @param message 显示的文本信息
     */
    public static void showShort(Context context, CharSequence message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 短时间显示Toast.
     *
     * @param context 上下文
     * @param resId 显示的文本对应的资源ID
     */
    public static void showShort(Context context, int resId) {
        if (isShow) {
            Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 长时间显示Toast.
     *
     * @param context 上下文
     * @param message 显示的文本信息
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 长时间显示Toast.
     *
     * @param context 上下文
     * @param resId 显示的文本对应的资源ID
     */
    public static void showLong(Context context, int resId) {
        if (isShow) {
            Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 自定义显示Toast时间.
     *
     * @param context 上下文
     * @param message 显示的文本信息
     * @param duration 自定义的显示时间
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow) {
            Toast.makeText(context, message, duration).show();
        }
    }

    /**
     * 自定义显示Toast时间.
     *
     * @param context 上下文
     * @param resId 显示的文本对应的资源ID
     * @param duration 自定义的显示时间
     */
    public static void show(Context context, int resId, int duration) {
        if (isShow) {
            Toast.makeText(context, resId, duration).show();
        }
    }
}
