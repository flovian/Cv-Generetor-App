package com.example.resumeappgenerator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PreviewActivity extends AppCompatActivity {

    CustomAdapter adapter;
    ArrayList<Item> details;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        listView = (ListView)findViewById(R.id.list);
        details=new ArrayList<>();
        adapter= new CustomAdapter(this,details);

        //connect the table to the db to get data

        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("resumeeTable");

        //start listening to the data as it comes in using valueE vent listener

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Clear you arraylist before using it to display data

                details.clear();

                //Wriite a loop to get the data and display

                for (DataSnapshot snap:dataSnapshot.getChildren()){
                    Item x = snap.getValue(Item.class);

                    //add the received data that is on variable x to the arraylist
                    details.add(x);

                    //finally notify your adapter that your data has changed in the arraylist

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
         //if the data in the db is false and false toast this message
                Toast.makeText(PreviewActivity.this, "Unlock your database", Toast.LENGTH_SHORT).show();

                //finally tell your list to use the adapter to display data


            }
        });
        listView.setAdapter(adapter);
    }
}
