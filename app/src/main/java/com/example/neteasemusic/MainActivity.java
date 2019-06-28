package com.example.neteasemusic;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.springindicator.SpringIndicator;

public class MainActivity extends AppCompatActivity {


    private SpringIndicator springIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        ImageView user_name = findViewById(R.id.caidan);
        user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        //首先找到viewpager
        final ViewPager viewPager = findViewById(R.id.vp);

        //定义一个视图集合（用来装左右滑动的页面视图）
        final List<View> viewlist = new ArrayList<>();

        //定义两个视图，两个视图都加载同一个布局list_view.xml
        View view1 = getLayoutInflater().inflate(R.layout.wode,null);
        View view2 = getLayoutInflater().inflate(R.layout.faxian,null);

        //将两个视图添加到视图集合viewlist中
        viewlist.add(view1);
        viewlist.add(view2);


        //为viewpager设置监听器
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                //这个方法是返回总共有几个滑动页面（）
                return viewlist.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                //该方法判断是否由该对象生成界面
                return view==object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                //这个方法返回一个对象，该对象表明PagerAdapter选择那个对象放在当前的ViewPager中。
                //这里我们返回当前的页面
                viewPager.addView(viewlist.get(position));
                return viewlist.get(position);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                //congviewpager中移动当前的view（划过的时候）
                viewPager.removeView(viewlist.get(position));
            }
        });


        springIndicator = findViewById(R.id.indicator);
        springIndicator.setViewPager(viewPager);

    }

}
