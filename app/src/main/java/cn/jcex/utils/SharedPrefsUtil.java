package cn.jcex.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 类描述：SharedPreferences工具类.
 *
 * @author 陈建邦
 * @version 1.0
 * @date 2015/12/9 9:20
 */
public class SharedPrefsUtil {

    //SharedPreferences记录文件名
    private static final String SHARED_PREFERENCES_FILE_NAME = "share_new_workers";

    //加载引导页 - boolean
    public static final String SHARED_KEY_GUIDE_LOADED = "SHARED_KEY_GUIDE_LOADED";
    //记录用户名 - String
    public static final String SHARED_KEY_USERNAME = "SHARED_KEY_USERNAME";
    //记录密码 - String
    public static final String SHARED_KEY_PASSWORD = "SHARED_KEY_PASSWORD";

    /**
     * 向SharedPreferences中写入int类型数据.
     *
     * @param context 上下文环境
     * @param key     键
     * @param value   值
     */
    public static void putValue(Context context, String key, int value) {
        Editor sp = getEditor(context);
        sp.putInt(key, value);
        sp.commit();
    }

    /**
     * 向SharedPreferences中写入boolean类型的数据.
     *
     * @param context 上下文环境
     * @param key     键
     * @param value   值
     */
    public static void putValue(Context context, String key, boolean value) {
        Editor sp = getEditor(context);
        sp.putBoolean(key, value);
        sp.commit();
    }

    /**
     * 向SharedPreferences中写入String类型的数据.
     *
     * @param context 上下文环境
     * @param key     键
     * @param value   值
     */
    public static void putValue(Context context, String key, String value) {
        Editor sp = getEditor(context);
        sp.putString(key, value);
        sp.commit();
    }

    /**
     * 向SharedPreferences中写入float类型的数据.
     *
     * @param context 上下文环境
     * @param key     键
     * @param value   值
     */
    public static void putValue(Context context, String key, float value) {
        Editor sp = getEditor(context);
        sp.putFloat(key, value);
        sp.commit();
    }

    /**
     * 向SharedPreferences中写入long类型的数据.
     *
     * @param context 上下文环境
     * @param key     键
     * @param value   值
     */
    public static void putValue(Context context, String key, long value) {
        Editor sp = getEditor(context);
        sp.putLong(key, value);
        sp.commit();
    }

    /**
     * 从SharedPreferences中读取int类型的数据.
     *
     * @param context  上下文环境
     * @param key      键
     * @param defValue 如果读取不成功则使用默认值
     * @return 返回读取的值
     */
    public static int getValue(Context context, String key, int defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getInt(key, defValue);
    }

    /**
     * 从SharedPreferences中读取boolean类型的数据.
     *
     * @param context  上下文环境
     * @param key      键
     * @param defValue 如果读取不成功则使用默认值
     * @return 返回读取的值
     */
    public static boolean getValue(Context context, String key, boolean defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(key, defValue);
    }

    /**
     * 从SharedPreferences中读取String类型的数据.
     *
     * @param context  上下文环境
     * @param key      键
     * @param defValue 如果读取不成功则使用默认值
     * @return 返回读取的值
     */
    public static String getValue(Context context, String key, String defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(key, defValue);
    }

    /**
     * 从SharedPreferences中读取float类型的数据.
     *
     * @param context  上下文环境
     * @param key      键
     * @param defValue 如果读取不成功则使用默认值
     * @return 返回读取的值
     */
    public static float getValue(Context context, String key, float defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getFloat(key, defValue);
    }

    /**
     * 从SharedPreferences中读取long类型的数据.
     *
     * @param context  上下文环境
     * @param key      键
     * @param defValue 如果读取不成功则使用默认值
     * @return 返回读取的值
     */
    public static long getValue(Context context, String key, long defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getLong(key, defValue);
    }

    /**
     * 从SharedPreferences中移除指定的数据.
     *
     * @param context 上下文环境
     * @param key     键
     */
    public static void removeValue(Context context, String key) {
        Editor sp = getEditor(context);
        sp.remove(key);
        sp.commit();
    }

    //获取Editor实例
    private static Editor getEditor(Context context) {
        return getSharedPreferences(context).edit();
    }

    //获取SharedPreferences实例
    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
    }
}
