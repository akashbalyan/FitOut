    package com.example.fitout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText firstname = findViewById(R.id.editTextTextFIrstName);
        EditText lastname = findViewById(R.id.editTextTextLastName);
        EditText username = findViewById(R.id.editTextTextUsername);
        EditText password = findViewById(R.id.editTextPassword);

        Button signUp = findViewById(R.id.btnSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               FirebaseFirestore db = FirebaseFirestore.getInstance();
                // Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("FirstName", firstname.toString());
                user.put("LastName", lastname.toString());
                user.put("Username", username.toString());
                user.put("Password", password.toString());


                // Add a new document with a generated ID
                db.collection("Users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getApplicationContext(),"User created Successfully",Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Error Creating User",Toast.LENGTH_LONG).show();
                            }
                        });

                startActivity(new Intent(SignUp.this,Login.class));
            }
        });

    }
}