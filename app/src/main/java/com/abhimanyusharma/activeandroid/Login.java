package com.abhimanyusharma.activeandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Abhimanyu Sharma on 22-06-2017.
 */
public class Login extends AppCompatActivity {
    Button signin, signup;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ActiveAndroid.initialize(this);
        signin=(Button)findViewById(R.id.signIn);
        signup=(Button)findViewById(R.id.signUp);
        email = (EditText) findViewById(R.id.email);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                finish();


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
