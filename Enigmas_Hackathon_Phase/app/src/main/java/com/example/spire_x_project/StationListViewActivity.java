package com.example.spire_x_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.spire_x_project.API.DataReceivedListner;
import com.example.spire_x_project.API.FirebaseAPI;
import com.example.spire_x_project.database_handle.SharedPreferenceManager;
import com.example.spire_x_project.rec_views.ItemClickListener;
import com.example.spire_x_project.rec_views.package_list.Package;
import com.example.spire_x_project.rec_views.station_list.RecViewAdapter;
import com.example.spire_x_project.rec_views.station_list.Station;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StationListViewActivity extends AppCompatActivity {

    private List<Station> stationList;
    private int position;
    private RecViewAdapter adapter;
    private LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_list_view);

        setupUI();

        // Initialize the recycler view and data fetching
        initRecyclerViewAndData();
    }

    private void setupUI() {
        ImageView backButton = findViewById(R.id.back_button);
        TextView appBarTitle = findViewById(R.id.app_bar_title);
        lottieAnimationView = findViewById(R.id.loading_bar);

        appBarTitle.setText("STATIONS");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initRecyclerViewAndData() {
        RecyclerView recyclerView = findViewById(R.id.rec_view);
        stationList = new ArrayList<>();

        FirebaseAuth.getInstance()
                .signInAnonymously()
                .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Log.d("StationListView", "Authentication success");
                        FirebaseAPI firebaseAPI = new FirebaseAPI(StationListViewActivity.this);
                        firebaseAPI.readData("stations", new DataReceivedListner() {
                            @Override
                            public void OnDataReceived(ArrayList<Map<String, Object>> arrayList) {
                                processReceivedData(arrayList);
                            }
                        });
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        handleAuthFailure(e);
                    }
                });
    }

    private void processReceivedData(ArrayList<Map<String, Object>> arrayList) {
        for (Map<String, Object> item : arrayList) {
            stationList.add(new Station(
                    item.get("station_id").toString(),
                    item.get("town").toString(),
                    item.get("planet").toString(),
                    item.get("station_id").toString(),
                    item.get("station").toString()
            ));
        }

        lottieAnimationView.setVisibility(View.GONE);

        adapter = new RecViewAdapter(StationListViewActivity.this, stationList, new ItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                updatePosition(position);
                onBackPressed();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(StationListViewActivity.this));
        recyclerView.setAdapter(adapter);
    }

    private void handleAuthFailure(Exception e) {
        Toast.makeText(StationListViewActivity.this, "Authentication failed: " + e.toString(), Toast.LENGTH_SHORT).show();
        lottieAnimationView.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        SharedPreferenceManager.saveStation(StationListViewActivity.this, stationList.get(position));
        super.onBackPressed();
    }

    private void updatePosition(int position) {
        this.position = position;
    }
}
