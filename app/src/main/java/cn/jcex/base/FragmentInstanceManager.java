package cn.jcex.base;

import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理所有的Fragment,获取Fragment只能通过这个类去构造
 * @author Sunyaqin
 * @date 2018-03-30 17:59:36
 * 
 */
public class FragmentInstanceManager {

    private FragmentInstanceManager() {
    }

    private static FragmentInstanceManager sInstance = new FragmentInstanceManager();

    public static FragmentInstanceManager getInstance() {

        return sInstance;
    }

    private Map<String, Fragment> mFragments = new HashMap<String, Fragment>();

    // 提供方法外部去获取Fragment
    public Fragment getFragment(Class<? extends Fragment> clazz) {

        String key = clazz.getSimpleName();
        Fragment fragment = mFragments.get(key);

        if (fragment == null) {

            synchronized (FragmentInstanceManager.class) {
                try {
                    if (fragment == null) {
                        fragment = clazz.newInstance();
                        mFragments.put(key, fragment);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }
        }

        return fragment;
    }

}
