package com.chuhai.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int target;
    private int min = 0;
    private int max = 99;
    private static final int request = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        target = pickRandomNumbers();
    }
    public int pickRandomNumbers(){
        Random randy = new Random();
        return randy.nextInt(100);
    }
    public void buttonOnClick(View view){
        EditText editText = findViewById(R.id.InputArea);
        int num = Integer.parseInt(editText.getText().toString());
        TextView AcceptedRange = findViewById(R.id.AcceptedRange);
        if(num == target){
            Intent intent = new Intent(this, BingoActivity.class);
            intent.putExtra("target1",target);
            startActivityForResult(intent,request);
        }
        else if(num < target){
            min = num;
            AcceptedRange.setText(min+"-"+max);
        }
        else {
            max = num;
            AcceptedRange.setText(min+"-"+max);
        }
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == request){
            String st = data.getStringExtra("Restarting");
            String s = "Restarting";
            if(st.equals(s)){
                target = pickRandomNumbers();
                min = 0;
                max = 99;
                TextView AcceptedRange = findViewById(R.id.AcceptedRange);
                AcceptedRange.setText(min+"-"+max);
                EditText editText = findViewById(R.id.InputArea);
                editText.setText("Enter a number");
            }
        }
    }

}
