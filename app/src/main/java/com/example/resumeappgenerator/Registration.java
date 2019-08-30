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
import com.google.firebase.auth.FirebaseAuthException;

public class Registration extends AppCompatActivity {

    EditText meditName, meditMail, meditPass;
    Button btn_reg;
    TextView userlogin_reg;
    FirebaseAuth firebaseAuth;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupViews();
        firebaseAuth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Registering");
        dialog.setMessage("Please wait...");

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (validate());

             String usermail=meditMail.getText().toString().trim();
             String userpass=meditPass.getText().toString().trim();
             dialog.show();

             firebaseAuth.createUserWithEmailAndPassword(usermail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     dialog.dismiss();

                     if (task.isSuccessful()){

                         Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                         startActivity(new Intent(Registration.this,LoginActivity.class));
                         firebaseAuth.signOut();


                     }else {
                         try {
                             throw task.getException();
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                         Toast.makeText(Registration.this, "Registration Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                     }
                 }
             });
            }
        });


        userlogin_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this,LoginActivity.class));
            }
        });

    }

    public  void setupViews(){
        meditName =findViewById(R.id.editname);
        meditMail =findViewById(R.id.editmail);
        meditPass =findViewById(R.id.editpass);
        btn_reg= findViewById(R.id.btnreg);
        userlogin_reg=findViewById(R.id.tv_text);

    }
    public Boolean validate() {

        Boolean results = false;

        String name = meditName.getText().toString();
        String email = meditName.getText().toString();
        String password = meditName.getText().toString();

        if (name.isEmpty() && email.isEmpty() && password.isEmpty()) {

            Toast.makeText(Registration.this, "Please enter all the details required", Toast.LENGTH_SHORT).show();
        } else {
            results = true;
        }

        return results;
    }

}