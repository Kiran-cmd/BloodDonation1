package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainHome extends AppCompatActivity {
Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        getSupportActionBar().setTitle("Home Screen");
        btn1=(Button)findViewById(R.id.btnSearchDonorMainHome);
        btn2=(Button)findViewById(R.id.btnBloodBank);

        btn3=(Button)findViewById(R.id.btnDonorLogin);

        btn4=(Button)findViewById(R.id.btnRegDonor);

//to search blood group
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainHome.this,Home.class);
                startActivity(intent);
            }
        });

//To  Donor Login

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainHome.this,Login.class);
                startActivity(intent);
            }
        });

//To Reg Page

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainHome.this,Registration.class);
                startActivity(intent);
            }
        });
    }
}
