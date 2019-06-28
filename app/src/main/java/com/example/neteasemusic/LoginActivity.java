package com.example.neteasemusic;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button denglu;
    private Button zhuce;
    private Utils sp;
    private EditText zhanghao;
    private EditText mima;
    private Context mcontect;
    private Utils utils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏系统自带标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }

        mcontect = getApplicationContext();
        utils = new Utils(mcontect);

        zhanghao = findViewById(R.id.et_zhanghao);
        mima = findViewById(R.id.et_mima);

        sp = new Utils(this);
        denglu = findViewById(R.id.btn_denglu);
        zhuce = findViewById(R.id.btn_zhuce);
        denglu.setOnClickListener(this);
        zhuce.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Map<String,String> data = utils.getuserinfo();
        String zh1 =data.get("username");
        String mm1 = data.get("password");
        zhanghao.setText(zh1);
        mima.setText(mm1);
    }

    @Override
    public void onClick(View view) {
        Map<String,String> data = utils.getuserinfo();
        String zh1 = data.get("username");
        String mm1 = data.get("password");
        String zh = zhanghao.getText().toString();
        String mm = mima.getText().toString();
        switch (view.getId()){
            case R.id.btn_denglu:
                //校验账号和密码是否正确
                if (TextUtils.isEmpty(zh)&&TextUtils.isEmpty(mm)){
//                Toast.makeText(this,"请输入账号和密码",Toast.LENGTH_SHORT).show();、
                    dialog3();
                }else if (zh.equals(zh1)&&mm.equals(mm1)){
//                Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    dialog4();
                }else if (TextUtils.isEmpty(zh)){
//                Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
                    dialog1();
                }else if(TextUtils.isEmpty(mm)){
//                Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
                    dialog2();
                }else if (zh!=(zh1)&&mm!=(mm1)){
//                Toast.makeText(LoginActivity.this,"账号密码不正确！",Toast.LENGTH_SHORT).show();
                    dialog5();
                }
                break;
            case R.id.btn_zhuce:
                Intent intent = new Intent(LoginActivity.this,ZhuCe.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    //提示窗口（账号）
    public void dialog1(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
        dialog.setTitle("警告");
        dialog.setMessage("请输入账号！");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    //提示窗口（密码）
    public void dialog2(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
        dialog.setTitle("警告");
        dialog.setMessage("请输入密码！");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    //提示窗口（账号和密码）
    public void dialog3(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
        dialog.setTitle("警告");
        dialog.setMessage("请输入账号和密码！");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

    //提示窗口（登陆成功）
    public void dialog4(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
        dialog.setTitle("恭喜您");
        dialog.setMessage("登陆成功！");
        dialog.setPositiveButton("开启我的音乐之旅", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }

    //提示窗口（账号和密码不正确）
    public void dialog5(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
        dialog.setTitle("警告");
        dialog.setMessage("账号或密码不正确！");
        dialog.setPositiveButton("重试", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }
}
