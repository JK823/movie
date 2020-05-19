package com.bw.movie.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.R;


public class MainActivity extends AppCompatActivity {

    private int time=2;
    private TextView guide_number;
    private Button button_tiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_tiao = findViewById(R.id.button_tiao);

        guide_number = findViewById(R.id.guide_number);
        handler.sendEmptyMessageDelayed(2,1000);

        /*button_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this, HomeActivity.class));
                finish();
            }
        });*/
    }

    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(time>0){
                time--;
                guide_number.setText("0"+time+"");
                handler.sendEmptyMessageDelayed(2,1000);
            }else{
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };


}
