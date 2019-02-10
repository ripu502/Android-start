package com.example.loginlatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {


    private EditText email;
    private EditText pass;
    private Button login;
    private TextView signup;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // making instance of firebase
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user != null){
            finish();
            startActivity(new Intent(MainActivity.this, secondActivity.class));
        }


        signup = (TextView) findViewById(R.id.textView);
        login = (Button) findViewById(R.id.button);
        pass = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Intent mainIntent = new Intent(MainActivity.this,SignUp.class);
                        startActivity(mainIntent);
                    }
                },0);
            }
        });

     login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             validate(email.getText().toString(),pass.getText().toString());
         }
     });


    }

    private void validate(String userName, String userPassword){
        progressDialog.setMessage("Please wait....");
        progressDialog.show();
        if(userName.isEmpty() || userPassword.isEmpty() ){
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, "Please fill the details", Toast.LENGTH_SHORT).show();
        }else{
            firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        startActivity(new Intent(MainActivity.this, secondActivity.class));
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


}
