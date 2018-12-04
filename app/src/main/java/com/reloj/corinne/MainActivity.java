package com.reloj.corinne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference points;
    EditText eFullname, eAge, eGender;
    ArrayList<String> keyList;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();
        points = db.getReference("relojcorinnelab9");
        eFullname = findViewById(R.id.editName);
        eAge = findViewById(R.id.editAge);
        eGender = findViewById(R.id.editGender);
        keyList = new ArrayList<>();
    }


    @Override
    protected void onStart() {
        super.onStart();
        points.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ss : dataSnapshot.getChildren()) {
                    keyList.add(ss.getKey());
                }
                Toast.makeText(MainActivity.this, keyList.get(0), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addRecord (View v){
        String fname = eFullname.getText().toString().trim();
        int age = Integer.parseInt(eAge.getText().toString().trim());
        String gender = eGender.getText().toString().trim();
        String key = points.push().getKey();
        userModel um = new userModel(fname, age, gender);
        points.child(key).setValue(um);
        keyList.add(key);
        Toast.makeText(this, "Record Inserted...", Toast.LENGTH_LONG).show();

    }
}
