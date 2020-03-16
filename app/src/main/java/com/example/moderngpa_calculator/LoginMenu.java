package com.example.moderngpa_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginMenu extends AppCompatActivity {

    EditText mname,mpassword;
    Button Login;
    TextView mSignup;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu);

        mname=findViewById(R.id.name);
        mpassword=findViewById(R.id.pass);
        mSignup=findViewById(R.id.signupText);
        fAuth= FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        Login=findViewById(R.id.LoginButton);
        Login.setOnClickListener(v -> {
            String email,password;
            email=mname.getText().toString().trim();
            password=mpassword.getText().toString().trim();


            if(TextUtils.isEmpty(email))
            {
                mname.setError("please input email");
                return;
            }

            if(TextUtils.isEmpty(password))
            {
                mpassword.setError("please input password");
                return;
            }

            if(password.length()<6)
            {
                mpassword.setError("password must be >=6 characters");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Toast.makeText(LoginMenu.this,"Logged in Successfully",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility (View.GONE);
                    Intent myintent=new Intent(this,MainActivity.class);
                    startActivity(myintent);
                    finish();



                }
                else
                {
                    Toast.makeText(LoginMenu.this,"Error! "+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility (View.GONE);
                }
            });

        });

       mSignup.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Signup.class)));


    }
}


