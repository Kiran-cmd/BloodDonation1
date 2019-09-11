package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class searchBlood extends AppCompatActivity {


    Intent intent,intentProfile;
    Spinner mySpin1, mySpin;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_blood);

            username=this.getIntent().getStringExtra("uname");

        intentProfile=new Intent(this,UserProfile.class);




        intent = new Intent(this, searchResult.class);


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
                intent.putExtra("loc", mySpin.getSelectedItem().toString());

                intent.putExtra("bgrp", mySpin1.getSelectedItem().toString());

                startActivity(intent);


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
