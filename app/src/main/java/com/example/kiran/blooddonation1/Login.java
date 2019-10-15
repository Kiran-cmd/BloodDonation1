package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText Username;
    EditText Password;
    Button btnlog,backbtn;
    TextView reg;
    DatabaseHelper db;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");


        intent = new Intent(this, searchBlood.class);

        db=new DatabaseHelper(this);
        Username=(EditText)findViewById(R.id.editTextName);
        Password=(EditText)findViewById(R.id.editTextPass);
        btnlog=(Button) findViewById(R.id.btnLogin);
        reg=(TextView) findViewById(R.id.textViewReg);
        backbtn=(Button)findViewById(R.id.buttonbackLogin);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent=new Intent(Login.this,MainHome.class);
                startActivity(Intent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent=new Intent(Login.this,Registration.class);
                startActivity(regIntent);
            }
        });
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= Username.getText().toString().trim();
                String PWD= Password.getText().toString().trim();

                boolean res = db.chckuser(user,PWD);

                if (res == true)
                {

                        intent.putExtra("uname",user);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this,"Error  ",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }


}
