package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private View v;
    private Button stop, resButton;
    boolean s;
    private SeekBar seekbar;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar = findViewById(R.id.seekBar);
        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        seekbar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekbar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        stop = (Button) findViewById((R.id.buttonStop));

        stop.setOnClickListener(this);

    }
    public void upButtonClick(View view){
        audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
        seekbar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this,"Volume Up", Toast.LENGTH_SHORT).show();
    }
    public void downButtonClick(View view){
        audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
        seekbar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        Toast.makeText(this,"Volume Down", Toast.LENGTH_SHORT).show();
    }

    public void onButtonClick(View v){
        EditText e1 = (EditText)findViewById(R.id.editText6);
        EditText e2 = (EditText)findViewById(R.id.editText5);
        TextView t1 = (TextView)findViewById(R.id.textView);
        int num1 = Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
        int sum = num1+num2;
        t1.setText(Integer.toString(sum));
        TextView t2 = (TextView)findViewById(R.id.textView);
        int res = Integer.parseInt(t2.getText().toString());
        if(res%2==0){
            s=true;
        }
        else{
            s=false;
        }
        if(s==true){
            startService(new Intent(this, MyService.class)) ;
        }



    }

    @Override
    public void onClick(View v) {
        if(v==stop){
            stopService(new Intent(this, MyService.class)) ;

        }

    }
}
