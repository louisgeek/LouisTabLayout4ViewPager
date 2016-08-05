package com.louis.louistablayout4viewpager.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.louis.louistablayout4viewpager.R;
import com.louis.louistablayout4viewpager.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    List<View> views=new ArrayList<>();

    public ParentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParentFragment newInstance(String param1, String param2) {
        ParentFragment fragment = new ParentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_parent, container, false);
        TabLayout tabLayout= (TabLayout) view.findViewById(R.id.id_tab_top);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.id_vp_child);
        initViews();

        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(views);
        viewPager.setAdapter(myPagerAdapter);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
       /* for (int i=0;i<views.size();i++){
            TabLayout.Tab tlt=tabLayout.newTab().setText("xxx"+i);
            tabLayout.addTab(tlt);
        }*/
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    private void initViews() {
        for (int i=0;i<9;i++){
            TextView textView=new TextView(getActivity());
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(layoutParams);
            textView.setText(mParam1+"中子页面"+i);
            textView.setGravity(Gravity.CENTER);//Tab的重心，有填充和居中两个值，为别为fill和center。
            views.add(textView);
        }

    }

}
