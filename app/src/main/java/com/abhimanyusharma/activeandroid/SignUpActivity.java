package com.abhimanyusharma.activeandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Abhimanyu Sharma on 23-06-2017.
 */
public class SignUpActivity extends AppCompatActivity {

    Button signup;
    EditText fname, lname, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup = (Button) findViewById(R.id.signUp);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add();

                Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void add() {

        Data tlc = new Data();
        tlc.userFirstName = fname.getText().toString();
        tlc.userLastName = lname.getText().toString();
        tlc.userFirstName = email.getText().toString();
        tlc.userFirstName = password.getText().toString();

        tlc.save();

        Toast.makeText(getApplicationContext(),"Data Inserted in Database", Toast.LENGTH_LONG).show();


    }
}
