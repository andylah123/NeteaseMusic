package com.example.neteasemusic;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZhuCe extends AppCompatActivity {

    EditText et1;
    EditText et2;
    private Context mContext;
    private Utils utiles;
    private EditText editname;
    private EditText edipwd;
    private Button btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);

        mContext = getApplicationContext();
        utiles = new Utils(mContext);
        getinfo();

        EditText et1 = findViewById(R.id.et1);
    }

    private  void getinfo(){
        editname = findViewById(R.id.et1);
        edipwd = findViewById(R.id.et2);
        btnregister = findViewById(R.id.btn_register);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strname = editname.getText().toString();
                String strpwd  = edipwd.getText().toString();
                utiles.saveuserinfo(strname,strpwd);
                finish();
            }
        });
    }

}
