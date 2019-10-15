package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Button btnSearchHome, btnBackHome;
    DatabaseHelper db;
    ArrayList<String> list;
    ArrayAdapter adpt;
    Intent intent;

    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Search Donor");
        list = new ArrayList<>();
        db =new DatabaseHelper(this);

        //for adding items in the arrar/Dropdown list
         final Spinner mySpink = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpink.setAdapter(myAdapter);

         final Spinner mySpin1k = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> myAdapter1 = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin1k.setAdapter(myAdapter1);


        btnSearchHome = (Button) findViewById(R.id.btnSearchBloodGrp);

        intent = new Intent(this, searchResult.class);
        btnSearchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(db.hasBloodResult( mySpin1k.getSelectedItem().toString(),mySpink.getSelectedItem().toString())) {
                    intent.putExtra("loc", mySpin1k.getSelectedItem().toString());

                    intent.putExtra("bgrp", mySpink.getSelectedItem().toString());

                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Home.this,"No Donor Available!!!",Toast.LENGTH_SHORT).show();

                }

            }
        });
        btnBackHome = (Button) findViewById(R.id.btnbackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Home.this, MainHome.class);

                startActivity(intent);

            }
        });

    }



    //retrive



}


