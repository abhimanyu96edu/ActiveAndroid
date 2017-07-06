package com.abhimanyusharma.activeandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        //ActiveAndroid.initialize(this);

        signin=(Button)findViewById(R.id.signIn);
        signup=(Button)findViewById(R.id.signUp);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = String.valueOf(Data.getValue(email.getText().toString()));

                Toast.makeText(Login.this, result, Toast.LENGTH_LONG).show();

                if(result.equals(password.getText().toString()))
                {
                    Toast.makeText(Login.this, "Logged In", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                Toast.makeText(Login.this, "Logged In Error", Toast.LENGTH_LONG).show();
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
}
