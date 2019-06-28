package com.example.neteasemusic;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private Context mcontext;

    public Utils(Context mcontext){
        this.mcontext = mcontext;
    }

    //保存账号和登陆密码，到data。xml文件中
    public void saveuserinfo(String username, String password){
        SharedPreferences.Editor edit = mcontext.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
        edit.putString("username",username);
        edit.putString("password",password);
        edit.commit();
        Toast.makeText(mcontext,"信息已写入SharePreference中",Toast.LENGTH_SHORT).show();
    }
    //从data。xml文件中获取存储的账号和密码
    Map<String,String> getuserinfo(){
        Map<String,String>data = new HashMap<String, String>();
        SharedPreferences sp = mcontext.getSharedPreferences("data",Context.MODE_PRIVATE);
        data.put("username",sp.getString("username",""));
        data.put("password",sp.getString("password",""));
        return data;
    }
}
