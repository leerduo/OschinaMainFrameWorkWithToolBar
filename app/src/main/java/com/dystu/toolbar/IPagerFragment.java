package com.dystu.toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public interface IPagerFragment {

    public FragmentStatePagerAdapter getPagerAdapter();

    public ViewPager getViewPager();

    public Fragment getCurrentFragment();
}
