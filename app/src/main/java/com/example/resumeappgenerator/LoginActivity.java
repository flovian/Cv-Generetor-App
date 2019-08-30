package com.example.resumeappgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText meditName, meditMail, meditPass;
    Button btn_log;
    TextView userReg_login;
    FirebaseAuth firebaseAuth;
    TextView Info;
    private int counter=5;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        meditName =(EditText)findViewById(R.id.editname);
        meditMail =(EditText)findViewById(R.id.editmail);
        meditPass =(EditText)findViewById(R.id.editpass);
        btn_log=(Button)findViewById(R.id.btnlog);
        userReg_login=(TextView)findViewById(R.id.tv_reg) ;
        Info=(TextView)findViewById(R.id.tv_info);

        Info.setText("No of attempts remaining: 5");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                validate(meditName.getText().toString(),meditPass.getText().toString());
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        userReg_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,Registration.class));
            }
        });
    }

    public void validate(String username,String userpass){

        progressDialog.setMessage(" Waiting for verification");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(username,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Login Failed "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    counter--;
                    Info.setText("No of attempts remaining "+counter);
                    progressDialog.dismiss();
                    if (counter==0){
                        btn_log.setEnabled(false);
                    }
                }

            }
        });



    }
}