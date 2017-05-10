package com.snslib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void login(View v) {
        Toast.makeText(this,"login test",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,LoginTestActivity.class));
    }

    public void share(View view) {
        Toast.makeText(this,"share test",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,ShareTestActivity.class));
    }

    public void green(View view) {
        Toast.makeText(this,"green dao test",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,GreenDaoActivity.class));
    }
}
