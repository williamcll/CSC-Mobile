package com.chuhai.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BingoActivity extends AppCompatActivity {
//    private int target;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bingo_main);
        Intent intent = getIntent();
        int n = intent.getIntExtra("target1",0);
        TextView textView = findViewById(R.id.Result);
        textView.setText("The game is finished, the number " +n+" that you guessed is correct!");
    }
    public void Replay(View v){
        Intent intent = new Intent();
        intent.putExtra("Restarting","Restarting");
        setResult(RESULT_OK,intent);
        finish();
    }
}
