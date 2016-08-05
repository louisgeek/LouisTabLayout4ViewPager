package com.louis.louistablayout4viewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.louis.louistablayout4viewpager.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;
/*
Android Material Design 中的TabLayout有两个比较有用的属性 app:tabMode、app:tabGravity，
（1）app:tabMode有两个值：fixed和scrollable。
（2）app:tabGravity有两个值：fill和center。
比较常用的是app:tabMode设置值scrollable，以及app:tabGravity设置值center。
比如，当app:tabMode设置值scrollable表示此TabLayout中当子view超出屏幕边界时候，将提供滑动以便滑出不可见的那些子view。
而app:tabGravity设置值center，在有些情况下，比如TabLayout中子view较少需要居中显示时候的情景。
 */
public class MainActivity extends AppCompatActivity {

    List<View> views=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i=0;i<9;i++){
            TextView textView=new TextView(this);
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(layoutParams);
            textView.setText("页面"+i);
            textView.setGravity(Gravity.CENTER);//Tab的重心，有填充和居中两个值，为别为fill和center。
            views.add(textView);
        }

        ViewPager viewPager= (ViewPager) findViewById(R.id.id_vp);
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(views);
        viewPager.setAdapter(myPagerAdapter);

        TabLayout tabLayout= (TabLayout) findViewById(R.id.id_tl);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

       /* for (int i=0;i<views.size();i++){
            TabLayout.Tab tlt=tabLayout.newTab().setText("xxx"+i);
            tabLayout.addTab(tlt);
        }*/

        tabLayout.setupWithViewPager(viewPager);



    }
}
