package com.abhimanyusharma.activeandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abhimanyusharma.activeandroid.tablemodel.Data;

public class SignUpActivity extends AppCompatActivity {

    Button signup;
    EditText name, email, password, number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup = (Button) findViewById(R.id.signUp);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CHECK WHETHER ANY FIELD IS EMPTY
                checkIsEmpty();

            }
        });

    }

    private void checkIsEmpty() {

        if(TextUtils.isEmpty(email.getText().toString())) {
            email.setError("Cannot be Empty !!");
            Toast.makeText(this, "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(name.getText().toString())) {
            name.setError("Cannot be Empty !!");
            Toast.makeText(this, "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(number.getText().toString())) {
            number.setError("Cannot be Empty !!");
            Toast.makeText(this, "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password.getText().toString())) {
            password.setError("Cannot be Empty !!");
            Toast.makeText(this, "Field Cannot be Empty", Toast.LENGTH_SHORT).show();
            return;
        }

        //SINCE NO FIELD IS EMPTY, NOW ADD THE DATA INTO THE DATABASE
        add();

    }

    private void add() {

        Data tlc = new Data();
        tlc.userName = name.getText().toString().trim();
        tlc.userNumber = String.valueOf(number.getText()).trim();
        tlc.userEmail = email.getText().toString().trim();
        tlc.userPassword = password.getText().toString().trim();

        tlc.save();

        Toast.makeText(getApplicationContext(),"Account Successfully Created", Toast.LENGTH_LONG).show();

        Intent i = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(i);
        finish();

    }
}
