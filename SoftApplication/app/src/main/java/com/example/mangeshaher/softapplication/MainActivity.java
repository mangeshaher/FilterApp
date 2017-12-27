package com.example.mangeshaher.softapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addMethod(View view){
        startActivity(new Intent(this,InsertInfo.class));
    }

    public void viewMethod(View view){
        startActivity(new Intent(this,ViewList.class));
    }
}
