package com.rrbofficial.btrapplock;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ROHIT on 07/09/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context ;
    private LayoutInflater layoutInflater;
    private Integer[] images ={R.drawable.onew,R.drawable.wtwo,R.drawable.wthree,R.drawable.wfour,R.drawable.wfive,R.drawable.wsix,R.drawable.wseven,
            R.drawable.weight,R.drawable.wnine,R.drawable.wten};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp =(ViewPager)container;
        View view =(View)object;
        vp.removeView(view);

    }
}
