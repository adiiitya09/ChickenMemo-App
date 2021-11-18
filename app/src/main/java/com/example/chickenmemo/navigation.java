package com.example.chickenmemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.cert.Extension;

public class navigation extends AppCompatActivity implements View.OnClickListener {
    Button b31,b32;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        b31=(Button) findViewById(R.id.btn_add);
        b32=(Button) findViewById(R.id.btn_list);

        b31.setOnClickListener(this);
        b32.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_add:
                Intent it=new Intent(navigation.this,addRecord.class);
                startActivity(it);
                break;

            case R.id.btn_list:
                Intent t=new Intent(navigation.this,viewList.class);
                startActivity(t);
                break;

        }

    }
}
