package com.chuhai.madlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String allText =intent.getStringExtra( "allText");
        TextView textView = findViewById(R.id.textView5);
        textView.setText(allText);
    }
    public void reset(){
    }
}
