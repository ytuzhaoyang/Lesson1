package com.tengyun.lesson1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawLayout;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawLayout = (DrawerLayout) findViewById(R.id.drawlayout);
        menu = (NavigationView) findViewById(R.id.menu);

        // 设置导航菜单的选中监听
        menu.setNavigationItemSelectedListener(this);

        //linearLayout.setOnClickListener(this);

        //actionBar的显示Home
        toggle = new ActionBarDrawerToggle(this, mDrawLayout, 0, 0);
        //三条横线的Menu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();
        //drawLayout的动作影响上面toggle的状态
        mDrawLayout.setDrawerListener(toggle);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            //%02d 代表2位整数，不足2位用0填充
            list.add(String.format("第%02d页",i));
        }
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(), list));

        tab = (TabLayout) findViewById(R.id.tab);
        //setAdapter之后调用
        tab.setupWithViewPager(pager);
    }

    /**
     * 监听menu的点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //toggle控制DeawLayout
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_1:
                startActivity(new Intent(MainActivity.this, SlidingActivity.class));
                break;
            case R.id.item_5:
                // 退出当前应用,最低api16
                finishAffinity();
                //兼容包
                //ActivityCompat.finishAffinity(this);

                break;
        }
        //关闭侧滑菜单
        mDrawLayout.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    public void onClick(View v) {
//        //关闭左侧，ＳＴＡＲＴ４.０以上版本
//        //mDrawLayout.closeDrawer(Gravity.START);
//        //兼容包写法
//        mDrawLayout.closeDrawer(GravityCompat.START);
//
//        startActivity(new Intent(MainActivity.this, SlidingActivity.class));
//    }


}
