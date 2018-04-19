package cn.jcex.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类描述: tabLayout绑定Adapter .
 *
 * @author SUNYAQIN
 * @version 1.0
 * @date 2018-04-09.
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {
    private Context context;
    private  List<String> titles;
    private List<Fragment> fragments;


    public TabFragmentAdapter(Context context, List<Fragment> fragments, List<String> title, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
        this.titles=title;
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
