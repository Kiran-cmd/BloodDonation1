package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class searchBlood extends AppCompatActivity {


    Intent intent,intentProfile;
    Spinner mySpin1, mySpin;
    String username;
    Button bckbtn;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_blood);
        getSupportActionBar().setTitle("Search Blood");
            username=this.getIntent().getStringExtra("uname");

        intentProfile=new Intent(this,UserProfile.class);
        db= new DatabaseHelper(this);




        intent = new Intent(this, searchResult.class);


        bckbtn = (Button)findViewById(R.id.buttonSearchBloodBack);
        bckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(searchBlood.this,Login.class);
                startActivity(intent);
            }
        });
        mySpin = (Spinner) findViewById(R.id.SpLoc);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(myAdapter);

        mySpin1 = (Spinner) findViewById(R.id.SpBloodgrp);
        ArrayAdapter<CharSequence> myAdapter1 = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin1.setAdapter(myAdapter1);


        Button b1 = findViewById(R.id.btnSearch2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.hasBloodResult(mySpin.getSelectedItem().toString(),mySpin1.getSelectedItem().toString())) {
                    intent.putExtra("loc", mySpin.getSelectedItem().toString());

                    intent.putExtra("bgrp", mySpin1.getSelectedItem().toString());

                    startActivity(intent);

                }else
                {
                    Toast.makeText(searchBlood.this,"No Donor Available!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button b2=findViewById(R.id.profile);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentProfile.putExtra("uname",username);
                startActivity(intentProfile);


            }
        });

    }
}
