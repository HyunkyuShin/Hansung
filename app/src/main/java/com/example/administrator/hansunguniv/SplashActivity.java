package com.example.administrator.hansunguniv;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * Created by Administrator on 2016-12-04.
 */

public class SplashActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.e("bsos1202","SplashActivity income!");
        Handler hd= new Handler();
        hd.postDelayed(new Runnable(){
            public void run() {
                finish();



            }
        }, 3000); //3초 후 이미지 닫기.
    }

}
