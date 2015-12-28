package com.tengyun.lesson1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/12/28.
 */
public class MyAdapter extends FragmentPagerAdapter {

    private List<String> list;

    public MyAdapter(FragmentManager fm,List<String> list ) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return  BlankFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //获取页的标题
    @Override
    public CharSequence getPageTitle(int position) {

        return list.get(position);
    }
}
