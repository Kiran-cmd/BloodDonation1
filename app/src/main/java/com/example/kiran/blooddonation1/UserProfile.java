package com.example.kiran.blooddonation1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class UserProfile extends AppCompatActivity {


    DatabaseHelper db;
    String username;
    EditText editText1,editText2;
    Spinner sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        username=this.getIntent().getStringExtra("uname");

        db=new DatabaseHelper(this);
        editText1=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        sp1=(Spinner) findViewById(R.id.spinnerprofilebg);
        sp2=(Spinner) findViewById(R.id.spinnerprofilelocation);

        String a[]=db.GetUserDetails(username);


editText1.setText(a[0]);
editText2.setText(a[1]);


/* dropdown tobe value to populated

        a[2]------------- blood group
         a[3]------------- location

*/



    }
}
