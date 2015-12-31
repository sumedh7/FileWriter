package com.example.sumedh.filewriter;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3;
    public static String LOG_TAG = "MAIN_ACTIVITY";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.fileLogEnable = true;

        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button :
                Logger.LogD(LOG_TAG, "You have pressed right button");
                break;
            case R.id.button2 :
                Logger.LogW(LOG_TAG, "You have pressed warning button");
                break;
            case R.id.button3 :
                Logger.LogE(LOG_TAG, "You have pressed wrong button");
                break;
        }
    }
}
