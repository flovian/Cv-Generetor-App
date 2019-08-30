package com.example.resumeappgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

      Thread splash = new Thread(){
          @Override
          public void run() {
              try {
                  sleep(4000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              Intent go =  new Intent(SplashActivity.this,Registration.class);
              startActivity(go);
              finish();

          }
      };

      splash.start();

    }
}
