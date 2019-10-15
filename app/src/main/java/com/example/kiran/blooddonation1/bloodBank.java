package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bloodBank extends AppCompatActivity {
    Button btnDonate,btnbck;
    TextView tvap,tvan,tvbp,tvbn,tvop,tvon,tvabp,tvabn;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);
        getSupportActionBar().setTitle("Blood bank");

        btnbck =(Button)findViewById(R.id.buttonbckbloodbnk);
        btnbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bloodBank.this,MainHome.class);
                startActivity(intent);
            }
        });
        btnDonate = (Button)findViewById(R.id.btnDonate);
        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bloodBank.this,Registration.class);
                startActivity(intent);
            }
        });

        db=new DatabaseHelper(this);

        tvap=(TextView)findViewById(R.id.textViewAp);
        tvan=(TextView)findViewById(R.id.textViewAn);

        tvbp=(TextView)findViewById(R.id.textViewBp);
        tvbn=(TextView)findViewById(R.id.textViewBn);

        tvabp=(TextView)findViewById(R.id.textViewABp);
        tvabn=(TextView)findViewById(R.id.textViewABn);

        tvop=(TextView)findViewById(R.id.textViewOp);
        tvon=(TextView)findViewById(R.id.textViewOn);




        tvap.setText(String.valueOf(db.getBloodReoprt("A+")));
        tvan.setText(String.valueOf(db.getBloodReoprt("A-")));

        tvbp.setText(String.valueOf(db.getBloodReoprt("B+")));
        tvbn.setText(String.valueOf(db.getBloodReoprt("B-")));

        tvabp.setText(String.valueOf(db.getBloodReoprt("AB+")));
        tvabn.setText(String.valueOf(db.getBloodReoprt("AB-")));

        tvop.setText(String.valueOf(db.getBloodReoprt("O+")));
        tvon.setText(String.valueOf(db.getBloodReoprt("O-")));

    }



}
