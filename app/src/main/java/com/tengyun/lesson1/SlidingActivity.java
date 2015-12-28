package com.tengyun.lesson1;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class SlidingActivity extends AppCompatActivity implements SlidingPaneLayout.PanelSlideListener {

    private SlidingPaneLayout sliding;
    private LinearLayout menu;
    private FrameLayout frameLayout;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);

        sliding = (SlidingPaneLayout) findViewById(R.id.sliding_pane);
        menu = (LinearLayout) findViewById(R.id.menu);
        frameLayout = (FrameLayout) findViewById(R.id.content);

//        sliding.closePane();
//        sliding.openPane();

        //滑动监听
        sliding.setPanelSlideListener(this);

            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        actionBar = this.getActionBar();
//        if (actionBar != null) {
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        }else {
//            Toast.makeText(SlidingActivity.this, "无标题",Toast.LENGTH_SHORT).show();
//        }



    }


    /**
     * 滑动中
     * @param panel
     * @param slideOffset 滑动偏移量[0-1]0关闭，1全部拉出
     */
    @Override
    public void onPanelSlide(View panel, float slideOffset) {
        //拉出时主布局缩放
        //设置锚点为起点，5.0以上默认中心点，5.0 以下默认为左上角
        frameLayout.setPivotX(0);
        //frameLayout.setPivotY(frameLayout.getHeight()/2);
        //设置缩放,宽高等比缩放
        frameLayout.setScaleX(1 - slideOffset * 0.5f);
        frameLayout.setScaleY(1 - slideOffset * 0.5f);

        //兼容包，兼容9
//        ViewCompat.setPivotX(frameLayout, 0);
//        ViewCompat.setScaleX(frameLayout, 1 - slideOffset * 0.5f);
//        ViewCompat.setScaleY(frameLayout, 1 - slideOffset * 0.5f);

        //控制menu的水平移动
        ViewCompat.setTranslationX(menu, -menu.getWidth() / 2 * (1-slideOffset));
    }

    //打开
    @Override
    public void onPanelOpened(View panel) {

    }

    /**
     * 关闭
     * @param panel
     */
    @Override
    public void onPanelClosed(View panel) {

    }
}
