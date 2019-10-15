package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
EditText Name;
EditText pass;
Spinner bloodgrp;
Spinner loc1;
EditText phoneno;
TextView login;
    EditText confpwd;
    Button reg;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().setTitle("Registration Form");

        //for adding content in array
        Spinner mySpin=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> myAdapter=  ArrayAdapter.createFromResource(this, R.array.location,android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(myAdapter);

        Spinner mySpin1=(Spinner)findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> myAdapter1=  ArrayAdapter.createFromResource(this, R.array.names,android.R.layout.simple_spinner_item);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin1.setAdapter(myAdapter1);


        db=new DatabaseHelper(this);
        Name=(EditText)findViewById(R.id.editTextNamereg);
        pass=(EditText)findViewById(R.id.editTextpassreg);
        bloodgrp=(Spinner)findViewById(R.id.spinner4);
        phoneno=(EditText)findViewById(R.id.editTextphnnoreg);
        login=(TextView)findViewById(R.id.textViewreg);
        reg=(Button)findViewById(R.id.btnRegister);
        confpwd=(EditText)findViewById(R.id.editTextconpass);
       loc1=(Spinner) findViewById(R.id.spinner2);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent=new Intent(Registration.this,Login.class);
                startActivity(loginIntent);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = Name.getText().toString().trim();
                String pwd = pass.getText().toString().trim();
                String bg = bloodgrp.getSelectedItem().toString();
                String phnno = phoneno.getText().toString().trim();
                String confpass = confpwd.getText().toString().trim();
                String location1 = loc1.getSelectedItem().toString();
                // String location1=loc1.getSelectedItem().toString();


                if (TextUtils.isEmpty(Name.getText())) {
                    Name.setError("Plz Enter Name Here");
                } else {


                    if (!isValidPhoneNumber(phoneno.getText())) {
                        phoneno.setError("invalid");

                    } else {

                        if (TextUtils.isEmpty(pass.getText())) {
                            pass.setError("Plz Enter password Here");
                        }

                        if (TextUtils.isEmpty(confpwd.getText())) {
                            confpwd.setError("plz enter confirm password");
                        } else if (pwd.equals(confpass)) {
                            long val = db.addUser(user, phnno, bg, pwd, location1);
                            if (val > 0) {
                                Toast.makeText(Registration.this, "Sucessfull reg  ", Toast.LENGTH_SHORT).show();
                                Name.setText("");
                                pass.setText("");
                                phoneno.setText("");
                                confpwd.setText("");


                            } else {
                                Toast.makeText(Registration.this, "Error reg  ", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(Registration.this, "pwd not matching", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

        });


    }


    public boolean isValidPhoneNumber(CharSequence phoneno) {


        if (!TextUtils.isEmpty(phoneno)) {
           if(TextUtils.isDigitsOnly(phoneno))
           {
               if(phoneno.length()==10)
               {
                   return true;
               }
           }
        }
        return false;

    }
}
