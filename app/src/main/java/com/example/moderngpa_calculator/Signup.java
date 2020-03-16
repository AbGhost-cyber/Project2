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

public class Signup extends AppCompatActivity {

    EditText mname,mpassword;
    Button signup;
    TextView mLoginButton;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        mname=findViewById(R.id.username);
        mpassword=findViewById(R.id.pass);
        mLoginButton=findViewById(R.id.alreadyUse);
        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        signup=findViewById(R.id.signupbutton);


        if(fAuth.getCurrentUser() !=null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        signup.setOnClickListener(v -> {
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


            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful())
                {
                    Toast.makeText(Signup.this,"User Created",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }

                else
                {
                    Toast.makeText(Signup.this,"Error "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

        });


        mLoginButton.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),LoginMenu.class)));
    }
}






