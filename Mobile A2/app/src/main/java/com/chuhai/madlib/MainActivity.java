package com.chuhai.madlib;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private int wordsLeft = 13;
    private int text1;
    private int text2;
    private String str;
    private String allText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scanner scanner=new Scanner(getResources().openRawResource(R.raw.data));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            allText += line;
        }
        scanner.close();
    }
    public void check(View v){
        TextView textView1 = findViewById(R.id.textview2);
        TextView textView2 = findViewById(R.id.textview3);
        EditText editText = findViewById(R.id.edittext);
        String editStr =editText.getText().toString();
        StringBuilder allText1 = new StringBuilder(allText);
       if(wordsLeft > 0){
               wordsLeft--;
               text1 = allText.indexOf("<");
               text2 = allText.indexOf(">");
               str = allText.substring(text1 + 1, text2);
               textView1.setText(wordsLeft +" word(s) left");
               textView2.setText("please type a/an/ "+str );
               allText1.replace(text1, text2 +1," "+ editStr);
               allText = allText1.toString();
               Toast.makeText(this,"Great! Keep going!",Toast.LENGTH_SHORT).show();
       }
       else{
           Intent intent = new Intent(this,Main2Activity.class);
           intent.putExtra("allText",allText);
           startActivity(intent);
       }
    }
    public void restart(View v){
        Toast.makeText(this,"Resetting!",Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
