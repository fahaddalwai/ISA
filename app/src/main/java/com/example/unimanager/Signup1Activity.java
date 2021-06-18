package com.example.unimanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup1Activity extends AppCompatActivity {
    private static final String TAG = "1";
    EditText email;
    EditText password;
    Button signup1;
    static String uploadedusername;
    static String uploadedpassword;
    EditText retypepassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        retypepassword = findViewById(R.id.signupconfirm_password);
        signup1 = findViewById(R.id.signup2_button);
        mAuth = FirebaseAuth.getInstance();

        signup1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                uploadedusername = email.getText().toString();
                uploadedpassword = password.getText().toString();
                if (uploadedpassword.contentEquals(retypepassword.getText())) {
                    mAuth.createUserWithEmailAndPassword(uploadedusername, uploadedpassword)
                            .addOnCompleteListener(Signup1Activity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        goToSignupPage2Activity();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(getApplicationContext(), "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        Log.i("bruh", "dsgsgsg");
                                    }
                                }
                            });

                } else {
                    Toast.makeText(getApplicationContext(), "password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void goToSignupPage2Activity() {
        Intent intent = new Intent(getApplicationContext(), Signup2Activity.class);
        startActivity(intent);
    }
}
