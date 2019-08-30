package com.example.resumeappgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Qualifiction extends AppCompatActivity {

    EditText mName,mWorkDeprt,mNationality,mEducationalBg,mPostal,
            mCountry,mStreet,mEmail,mWorkExp, mProfile, mLinks,mskills,mLanguages,mReferees,mHobbies;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualifiction);
        mName=findViewById(R.id.pname);
        mWorkDeprt=findViewById(R.id.pWorkDprt);
        mNationality=findViewById(R.id.pNationality);
        mEducationalBg=findViewById(R.id.pEdBg);
        mPostal=findViewById(R.id.editPostal);
        mCountry=findViewById(R.id.editCountry);
        mStreet=findViewById(R.id.editStreet);
        mEmail=findViewById(R.id.editEmail);
        mWorkExp = findViewById(R.id.editWorkExp);
        mProfile = findViewById(R.id.editProfile);
        mLinks = findViewById(R.id.editLinks);
        mskills = findViewById(R.id.editskills);
        mLanguages = findViewById(R.id.editlanguages);
        mReferees = findViewById(R.id.editreferees);
        mHobbies = findViewById(R.id.editHobbies);
    }


    public void save(View view) {
        //Write the saving codde here
        //Start by getting data from the user
        String name = mName.getText().toString().trim();
        String WorkDpt =  mWorkDeprt.getText().toString().trim();
        String nationality =  mNationality.getText().toString().trim();
        String edbg =  mEducationalBg.getText().toString().trim();
        String postal =  mPostal.getText().toString().trim();
        String country =  mCountry.getText().toString().trim();
        String street  =  mStreet.getText().toString().trim();
        String email =  mEmail.getText().toString().trim();
        String wExp =  mWorkExp.getText().toString().trim();
        String profile  =  mProfile.getText().toString().trim();
        String links  =  mLinks.getText().toString().trim();
        String skills  =  mskills.getText().toString().trim();
        String languages  =  mLanguages.getText().toString().trim();
        String Referees  =  mReferees.getText().toString().trim();
        String Hobbies  =  mHobbies.getText().toString().trim();
        long time = System.currentTimeMillis();

        //Convert the long time to string
        String timeConv = String.valueOf(time);

        //Check if the user is submitting empty fields
        if (name.isEmpty() || WorkDpt.isEmpty() || nationality.isEmpty() ||edbg.isEmpty() || postal.isEmpty() ||
                country.isEmpty() || street.isEmpty() || email.isEmpty() || wExp.isEmpty() || profile.isEmpty() ||email.isEmpty() || links.isEmpty()||
                skills.isEmpty() ||languages.isEmpty()||Referees.isEmpty() ||Hobbies.isEmpty()){
            Toast.makeText(this, "Fill", Toast.LENGTH_SHORT).show();
        }else {
            //Save into the db
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("resumeeTable");
            Item x = new Item(name,WorkDpt,nationality,edbg,postal,country,street,email,wExp,profile,
                    links,skills,languages,Referees,Hobbies,timeConv);
            ref.push().setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Qualifiction.this, "Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Qualifiction.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void preview(View view) {
        //Write an intent to take you to the preview page
        startActivity(new Intent(Qualifiction.this, PreviewActivity.class));
    }
}
