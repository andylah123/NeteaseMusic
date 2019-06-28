package com.example.neteasemusic;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;



import java.util.ArrayList;
import java.util.List;

import github.chenupt.springindicator.viewpager.ScrollerViewPager;

public class FaxianPage extends AppCompatActivity {


    private List<Integer> datas;
    private ScrollerViewPager scrollerViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.faxian);
        super.onCreate(savedInstanceState);

        scrollerViewPager = findViewById(R.id.view_pager);





    }


}



