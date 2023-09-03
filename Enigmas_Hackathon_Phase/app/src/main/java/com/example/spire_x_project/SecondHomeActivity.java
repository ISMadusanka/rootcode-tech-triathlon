package com.example.spire_x_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondHomeActivity extends AppCompatActivity {

    private static final String TAG = "SecondHomeActivity"; // Log tag for debugging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_home);

        try {
            setupUIElements();
            setupClickListeners();
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate: " + e.getMessage());
        }
    }

    // Initialize UI elements and set app bar title
    private void setupUIElements() {
        ImageView backButton = findViewById(R.id.back_button);
        TextView appBarTitle = findViewById(R.id.app_bar_title);
        appBarTitle.setText(" ");

        // Set a click listener for the back button to navigate back
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    // Set up click listeners for icons and cards
    private void setupClickListeners() {
        // Set a click listener for the right arrow icon to navigate to PublicTourActivity
        ImageView rightArrow = findViewById(R.id.right_arrow);
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToPublicTourActivity();
            }
        });

        // Set a click listener for the public tour CardView to navigate to PublicTourActivity
        CardView publicTour = findViewById(R.id.public_card_view);
        publicTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToPublicTourActivity();
            }
        });
    }

    // Navigate to the PublicTourActivity
    private void navigateToPublicTourActivity() {
        try {
            startActivity(new Intent(SecondHomeActivity.this, PublicTourActivity.class));
        } catch (Exception e) {
            Log.e(TAG, "Error navigating to PublicTourActivity: " + e.getMessage());
        }
    }
}
