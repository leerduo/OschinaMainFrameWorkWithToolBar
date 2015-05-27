package com.dystu.toolbar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Administrator on 2015/5/26.
 */
public class NewsTabPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public NewsTabPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.context = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        final int pattern = position % 3;
        NewsTab[] values = NewsTab.values();
        Fragment f = null;
        try {
            f = (Fragment) values[pattern].getClz().newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public int getCount() {
        return NewsTab.values().length;
    }

    @Override
    public final CharSequence getPageTitle(int i) {
        NewsTab tab = NewsTab.getTabByIdx(i);
        int idx = 0;
        CharSequence title = "";
        if (tab != null)
            idx = tab.getTitle();
        if (idx != 0)
            title = context.getResources().getString(idx);
        return title;
    }

}
