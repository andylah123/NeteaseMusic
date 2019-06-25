package com.example.neteasemusic.Wode_page;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.neteasemusic.Adapter.MyPagerAdapter;
import com.example.neteasemusic.R;

import java.util.ArrayList;
import java.util.List;

public class MineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        setVp();

    }


    private void setVp(){

        List<String> list  = new ArrayList<>();


        for (int i = 0 ; i< 3 ; i++){
            list.add("第" + i + "个View");
        }

        ViewPager vp = (ViewPager)findViewById(R.id.vp);
        vp.setAdapter(new MyPagerAdapter(this,list));
    }
}
