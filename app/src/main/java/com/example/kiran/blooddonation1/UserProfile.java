package com.example.kiran.blooddonation1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {


    DatabaseHelper db;
    String username;
    EditText editText2;
    TextView editText1;
    Spinner sp1,sp2;
    Button up,back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("User Profile");
        setContentView(R.layout.activity_user_profile);

        username=this.getIntent().getStringExtra("uname");

        db=new DatabaseHelper(this);
        editText1=(TextView)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        sp1=(Spinner) findViewById(R.id.spinnerprofilebg);
        sp2=(Spinner) findViewById(R.id.spinnerprofilelocation);
        up=(Button)findViewById(R.id.btnupdate);
        back=(Button)findViewById(R.id.buttonback);
        String a[]=db.GetUserDetails(username);


        editText1.setText(a[0]);
        editText2.setText(a[1]);


        sp1=(Spinner) findViewById(R.id.spinnerprofilebg);
        ArrayAdapter<CharSequence> myAdapter1 = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_spinner_item);
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(myAdapter1);

        sp2=(Spinner) findViewById(R.id.spinnerprofilelocation);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(myAdapter);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdate = db.updateData(editText1.getText().toString()
                        , editText2.getText().toString()
                        , sp1.getSelectedItem().toString()
                        , sp2.getSelectedItem().toString());


                    if (!isValidPhoneNumber(editText2.getText())) {
                        editText2.setError("invalid");

                    }else{
                    if (isupdate == true)

                    {
                        Toast.makeText(UserProfile.this, "Updated  ", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(UserProfile.this, "Error  ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UserProfile.this,searchBlood.class);
                startActivity(intent);
            }
        });

    }
    private boolean isValidPhoneNumber(CharSequence phoneno) {


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
