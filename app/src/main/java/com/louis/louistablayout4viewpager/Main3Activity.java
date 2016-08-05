package com.louis.louistablayout4viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.louis.louistablayout4viewpager.adapter.ParentFragmentPagerAdapter;
import com.louis.louistablayout4viewpager.fragments.ParentFragment;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {
    List<Fragment> mFragmentList=new ArrayList<>();
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        MyViewPager myViewPager = (MyViewPager) findViewById(R.id.id_vp_parent);


        initFragData();
        ParentFragmentPagerAdapter parentFragmentPagerAdapter=new ParentFragmentPagerAdapter(getSupportFragmentManager(),mFragmentList);
        myViewPager.setAdapter(parentFragmentPagerAdapter);
        myViewPager.setCanScroll(false);
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //
        tabLayout= (TabLayout) findViewById(R.id.id_tab_bottom);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(myViewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(getTabView(i));
                //tab.setIcon(R.mipmap.ic_launcher);
                //tab.setText("text1");
            }
        }

        updateSelected(0);

    }

    private void initFragData() {
        for (int i = 0; i <4; i++) {
            mFragmentList.add(ParentFragment.newInstance("页面"+(i+1),""));
        }
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
