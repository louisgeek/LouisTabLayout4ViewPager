package com.louis.louistablayout4viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by louisgeek on 2016/8/5.
 */
public class MyViewPager extends ViewPager {
    private boolean isCanScroll = false;

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyViewPager(Context context) {
        super(context);
    }

    public void setCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    /**
     * 如果return true,那么表示该方法消费了此次事件，如果return false，
     * 那么表示该方法并未处理完全，该事件仍然需要以某种方式传递下去继续等待处理
     * @param arg0
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        /* return false;//super.onTouchEvent(arg0); */
        if (!isCanScroll)
        { return false;}
        else
        {  return super.onTouchEvent(arg0);}
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (!isCanScroll)
           { return false;}
        else
          {  return super.onInterceptTouchEvent(arg0);}
    }
}