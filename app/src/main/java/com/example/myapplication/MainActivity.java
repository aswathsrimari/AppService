package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private View v;
    private Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.buttonStart);
        stop = (Button) findViewById((R.id.buttonStop));

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    public void onButtonClick(View v){
        EditText e1 = (EditText)findViewById(R.id.editText6);
        EditText e2 = (EditText)findViewById(R.id.editText5);
        TextView t1 = (TextView)findViewById(R.id.textView);
        int num1 = Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
        int sum = num1+num2;
        t1.setText(Integer.toString(sum));

    }

    @Override
    public void onClick(View v) {
        if(v == start){
            startService(new Intent(this, MyService.class)) ;
        }
        else if(v==stop){
            stopService(new Intent(this, MyService.class)) ;

        }

    }
}
