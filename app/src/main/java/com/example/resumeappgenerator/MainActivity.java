package com.example.resumeappgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void generate(View view) {

        startActivity(new Intent(MainActivity.this,Qualifiction.class));
    }


    public void logout(View view) {

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signOut();

        startActivity(new Intent(MainActivity.this,Registration.class));
    }

}
