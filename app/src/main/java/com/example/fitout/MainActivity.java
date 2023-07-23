package com.example.fitout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.net.URL;

import io.grpc.okhttp.internal.proxy.HttpUrl;
import io.grpc.okhttp.internal.proxy.Request;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton workoutPlan = findViewById(R.id.imageButtonWorkoutPlan);
        ImageButton viewExercises = findViewById(R.id.imageButtonViewExercises);


        workoutPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WorkoutPlan.class));
            }
        });

        viewExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ViewExercises.class));
            }
        });
    }

public void fetchExecrcisees(String val){

    String URL = "https://musclewiki.p.rapidapi.com/exercises?name=";
}
}