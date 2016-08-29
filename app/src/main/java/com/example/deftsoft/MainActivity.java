package com.example.deftsoft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.deftsoft.first.AlternateColors;
import com.example.deftsoft.second.CartActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void firstStart(View view) {
        Intent intent = new Intent(this, AlternateColors.class);
        startActivity(intent);
    }

    public void secondStart(View view) {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}
