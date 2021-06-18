package com.example.unimanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.unimanager.Signup1Activity.uploadedpassword;
import static com.example.unimanager.Signup1Activity.uploadedusername;

public class Signup2Activity extends AppCompatActivity {
    private static final String TAG = "-1";
    EditText contactnumber;
    EditText college;
    EditText branch;
    EditText regno;
    Button upload_data_to_firebase;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        contactnumber = findViewById(R.id.signup_contact);
        college = findViewById(R.id.signup_college);
        branch = findViewById(R.id.signup_branch);
        regno = findViewById(R.id.signup_registration_number);
        upload_data_to_firebase = findViewById(R.id.signup2_button);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        upload_data_to_firebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User userdetails = new User(uploadedusername, regno.getText().toString(), Integer.parseInt(String.valueOf(contactnumber.getText()))
                        , college.getText().toString(), branch.getText().toString());
                mDatabase.child("users").child(mAuth.getUid()).setValue(userdetails);
                goToMainActivity();
            }

        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


}

