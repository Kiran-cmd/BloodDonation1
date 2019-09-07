package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    Button btnSearchHome, btnBackHome;
    DatabaseHelper db;
    ArrayList<String> list;
    ArrayAdapter adpt;

    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Search Donor");
        list = new ArrayList<>();
      //  list1 = (ListView) findViewById(R.id.Userlist);

        //for adding items in the arrar/Dropdown list
        Spinner mySpin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(myAdapter);

        Spinner mySpin1 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> myAdapter1 = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin1.setAdapter(myAdapter1);
/*btnSearchHome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      //  db = new DatabaseHelper(this);
        Cursor cursor =db.addData();
        if (cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"No data  ",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                Toast.makeText(getApplicationContext(),"Name"+cursor.getString(2),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"PhoneNo"+cursor.getString(3),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Blood Group"+cursor.getString(4),Toast.LENGTH_SHORT).show();
            }
        }


    }
});
*/
        btnSearchHome = (Button) findViewById(R.id.btnSearchBloodGrp);
        btnSearchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inti = new Intent(Home.this, searchResult.class);

                startActivity(inti);
//viewData();
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


