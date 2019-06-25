package com.example.neteasemusic.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neteasemusic.R;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private Context mcontext;
    private List<String> mData;


    //viewpager适配器 上下文，list装载数据
    public MyPagerAdapter(Context context, List<String> list){
        mcontext = context;
        mData = list;
    }


    @Override
    public int getCount() {
        return mData.size();
    }



    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        //创建一个view并给这个view填充布局
        View view = View.inflate(mcontext, R.layout.page,null);
        TextView tv = (TextView)view.findViewById(R.id.tv);
        tv.setText(mData.get(position));
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View)object);
    }



    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view == object;
    }
}
