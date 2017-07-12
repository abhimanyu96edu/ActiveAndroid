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
import com.activeandroid.ActiveAndroid;

public class Login extends AppCompatActivity {
    Button signin, signup;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        signin=(Button)findViewById(R.id.signIn);
        signup=(Button)findViewById(R.id.signUp);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkIsEmpty();


            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void checkIsEmpty() {

        if(TextUtils.isEmpty(email.getText().toString())) {
            email.setError("Cannot be Empty !!");
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

        try {

            String pass = String.valueOf(Data.getPasswordValue(email.getText().toString()));

            if (pass.equals(password.getText().toString().trim())) {
                //Toast.makeText(Login.this, "Logged In", Toast.LENGTH_LONG).show();

                String name = String.valueOf(Data.getNameValue(email.getText().toString()));
                Toast.makeText(Login.this, "Welcome "+ name, Toast.LENGTH_LONG).show();
                Toast.makeText(Login.this, " Have A Great! ", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
        catch (Exception e){

            //email.setText("");
            password.setText("");
            Toast.makeText(Login.this, "Incorrect Data! Please Try Again!", Toast.LENGTH_SHORT).show();
        }
    }
}
