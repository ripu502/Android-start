package com.example.loginlatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp extends AppCompatActivity {

    private EditText emailS;
    private EditText passS;
    private Button register;
    private TextView login;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        emailS = (EditText) findViewById(R.id.etemailS);
        passS = (EditText) findViewById(R.id.etpassS);
        register = (Button) findViewById(R.id.btregister);

        // typecasting and findkeyByvalue
        login = (TextView) findViewById(R.id.tvlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler hand = new Handler();
                hand.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Intent mainIntnt = new Intent(SignUp.this,MainActivity.class);
                        startActivity(mainIntnt);
                    }
                },0);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String email = emailS.getText().toString().trim();
                    String pass = passS.getText().toString().trim();
                    progressDialog.setMessage("Please wait....");
                    progressDialog.show();


                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                Toast.makeText(SignUp.this, "Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, MainActivity.class));
                            }else {
                                progressDialog.dismiss();
                                Toast.makeText(SignUp.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(SignUp.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public Boolean validate(){
        Boolean flag = false;
        if(emailS.getText().toString().isEmpty() || passS.getText().toString().isEmpty() ){
            Toast.makeText(SignUp.this, "Please fill the details", Toast.LENGTH_SHORT).show();
        }else{
            flag = true;
        }
        return  flag;
    }
}
