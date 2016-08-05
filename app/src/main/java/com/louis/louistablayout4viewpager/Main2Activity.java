package com.louis.louistablayout4viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.louis.louistablayout4viewpager.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    List<View> views=new ArrayList<>();
    TabLayout tabLayout;
    int nowPos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        for (int i=0;i<5;i++){
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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //
                updateSelected(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout= (TabLayout) findViewById(R.id.id_tl);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
               tab.setCustomView(getTabView(i));
                //tab.setIcon(R.mipmap.ic_launcher);
                //tab.setText("text1");
            }
        }
        updateSelected(0);//默认选择0

    }

    private void updateSelected(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                LinearLayout linearLayout = (LinearLayout) tab.getCustomView().findViewById(R.id.id_ll_tab_bg);
                TextView textView= (TextView) linearLayout.findViewById(R.id.id_tv);
                if(i==position) {
                    textView.setTextColor(Color.parseColor("#FF00FF"));
                }else{
                    textView.setTextColor(Color.parseColor("#000000"));

                }
            }
        }
    }

    public View getTabView(int position) {
        View v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.id_tv);
        tv.setText("菜单" + position);
        ImageView img = (ImageView) v.findViewById(R.id.id_iv);
        img.setImageResource(R.mipmap.ic_launcher);
        return v;
    }
}
