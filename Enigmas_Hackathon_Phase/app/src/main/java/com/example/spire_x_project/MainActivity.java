package com.example.spire_x_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.spire_x_project.API.FirebaseAPI;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // Log tag for debugging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFirebaseApp();

        loadGifImage();

        setupMainButton();

        initializeFirebaseAPI();
    }

    // Initialize FirebaseApp
    private void initializeFirebaseApp() {
        FirebaseApp.initializeApp(this);
    }

    // Load GIF image using Glide library
    private void loadGifImage() {
        ImageView gifImageView = findViewById(R.id.gifImageView);
        Glide.with(this).asGif().load(R.drawable.home_main).into(gifImageView);
    }

    // Set up the click listener for the main button
    private void setupMainButton() {
        Button mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondHomeActivity();
            }
        });
    }

    // Initialize FirebaseAPI instance
    private void initializeFirebaseAPI() {
        FirebaseAPI firebaseAPI = new FirebaseAPI(this);
    }

    // Open the SecondHomeActivity
    private void openSecondHomeActivity() {
        Intent intent = new Intent(MainActivity.this, SecondHomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: MainActivity started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: MainActivity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: MainActivity destroyed");
    }
}
