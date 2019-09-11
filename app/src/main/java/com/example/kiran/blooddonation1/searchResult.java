package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class searchResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        DatabaseHelper db = new DatabaseHelper(this);
        db=new DatabaseHelper(this);

        Intent intent = getIntent();

        ArrayList<HashMap<String, String>> userList = db.GetSearchBloodResult(intent.getStringExtra("loc"), intent.getStringExtra("bgrp"));
        ListView lv = (ListView) findViewById(R.id.searchView);
        ListAdapter adapter = new SimpleAdapter(searchResult.this, userList, R.layout.list_row, new String[]{"name", "phoneNO", "location", "bloodgroup"}, new int[]{R.id.sname, R.id.sphone, R.id.sloc, R.id.sbloodg});


        lv.setAdapter(adapter);


    }
}
