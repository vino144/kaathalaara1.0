package com.vino.raven.kaathalaara.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.vino.raven.kaathalaara.MainActivity;
import com.vino.raven.kaathalaara.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("CHECK 2");
                Intent homePage=new Intent(SplashScreen.this, MainActivity.class);
                startActivity(homePage);
                SplashScreen.this.finish();
            }
        },2000);
    }
}
