package com.chuhai.madlibs;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import java.io.File;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File f=getFilesDir();


    }

    public void playTheGame(View view) {
        Intent intent=new Intent(this,FillActivity.class);
        startActivity(intent);
    }
}
