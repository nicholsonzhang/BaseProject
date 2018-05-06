package com.user.base.modules.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.user.base.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/8/3.
 */

public class MainAdapter extends FragmentPagerAdapter implements BottomNavigationBar.OnTabSelectedListener{
    private List<BaseFragment> fragments = new ArrayList<>();
    private BottomNavigationBar mBottomNavigationBar;
    private ViewPager mViewPager;

    public MainAdapter(FragmentManager fm, BottomNavigationBar bottomNavigationBar, ViewPager viewPager) {
        super(fm);
        mBottomNavigationBar = bottomNavigationBar;
        mViewPager = viewPager;
        mViewPager.setAdapter(this);
        mBottomNavigationBar.setTabSelectedListener(this);
        mViewPager.setOffscreenPageLimit(4);
    }
    public void addItem(BottomNavigationItem item,BaseFragment baseFragment){
        mBottomNavigationBar.addItem(item);

        fragments.add(baseFragment);
        notifyDataSetChanged();

    }
    public void setFirstSelectedPosition(int position){
        mBottomNavigationBar.setFirstSelectedPosition(position);
    }
    public void initialise(){
        mBottomNavigationBar.initialise();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void onTabSelected(int position) {
        mViewPager.setCurrentItem(position,false);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
