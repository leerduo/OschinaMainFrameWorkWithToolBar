package com.dystu.toolbar.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dystu.toolbar.IMainTab;
import com.dystu.toolbar.IPagerFragment;
import com.dystu.toolbar.NewsTabPagerAdapter;
import com.dystu.toolbar.R;
import com.dystu.toolbar.tab.SlidingTabLayout;

/**
 * Created by Administrator on 2015/5/26.
 */
public class NewsViewPagerFragment extends Fragment implements IPagerFragment{
    private ViewPager mViewPager;
    private NewsTabPagerAdapter mTabAdapter;
    private SlidingTabLayout mSlidingTabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.v2_fragment_viewpager2, container,
                false);
        //mTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        Activity parentActivity = getActivity();
        if (parentActivity instanceof IMainTab) {
            mSlidingTabLayout = ((IMainTab) parentActivity).getSlidingTabLayout();
        } else {
            throw new RuntimeException(NewsViewPagerFragment.class.getSimpleName() + "'s parent activity must be a IMainTab");
        }
        //(SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setCustomTabView(R.layout.v2_tab_indicator2, R.id.tv_name);

        mViewPager = (ViewPager) view.findViewById(R.id.main_tab_pager);

        if (mViewPager.getAdapter() == null &&
                mTabAdapter == null) {
            mTabAdapter = new NewsTabPagerAdapter(getChildFragmentManager(),getActivity());
        }
        mViewPager.setOffscreenPageLimit(mTabAdapter.getCount());
        mViewPager.setAdapter(mTabAdapter);
        //mViewPager.setOnPageChangeListener(this);
        //mTabStrip.setViewPager(mViewPager);

        Resources res = getResources();
        mSlidingTabLayout.setSelectedIndicatorColors(res.getColor(R.color.tab_selected_strip));
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);

        mSlidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        return view;
    }


    @Override
    public FragmentStatePagerAdapter getPagerAdapter() {
        return mTabAdapter;
    }

    @Override
    public ViewPager getViewPager() {
        return mViewPager;
    }

    @Override
    public Fragment getCurrentFragment() {
        return mTabAdapter.getItem(mViewPager.getCurrentItem());
    }


}