package com.example.spire_x_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.spire_x_project.API.DataReceivedListner;
import com.example.spire_x_project.API.FirebaseAPI;
import com.example.spire_x_project.models.BookedTrip;
import com.example.spire_x_project.rec_views.ItemClickListener;
import com.example.spire_x_project.rec_views.package_list.Package;
import com.example.spire_x_project.rec_views.package_list.RecViewAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PackageDetailsActivity extends AppCompatActivity {

    List<Package> packages;
    BookedTrip bookedTrip;

    Date selectedDate;

    ImageView filterButton;

    RecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);

        filterButton=findViewById(R.id.filter_button);
        ImageView backButton=findViewById(R.id.back_button);
        TextView appBarTitle=findViewById(R.id.app_bar_title);

        LottieAnimationView loadingBar=findViewById(R.id.loading_bar);

        //Visible only in this activity
        filterButton.setVisibility(View.VISIBLE);

        appBarTitle.setText("PACKAGE DETAILS");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            bookedTrip = (BookedTrip) intent.getSerializableExtra("booked_trip");

        }

        //get user selected date
        selectedDate = bookedTrip.getDepartureDate();
        //add packages after this date

        RecyclerView recyclerView=findViewById(R.id.rec_view);
        packages=new ArrayList<>();

        //Fetch package data
        FirebaseAuth.getInstance()
                .signInAnonymously()
                .addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Log.d("TAG", "auth:onSuccess");
                        FirebaseAPI firebaseAPI1=new FirebaseAPI(PackageDetailsActivity.this);


                        firebaseAPI1.searchPackages(bookedTrip.getDepartureCode(),bookedTrip.getArrivalCode(),formateDate(bookedTrip.getDepartureDate()),formateDate(bookedTrip.getArrivalDate()), new DataReceivedListner() {
                            @Override
                            public void OnDataReceived(ArrayList<Map<String, Object>> arrayList) {
                                for (Map<String, Object> item : arrayList){
                                    packages.add(new Package(
                                            item.get("package_name").toString(),
                                            ((Map<String, Object>) item.get("first_trip")).get("departure_time").toString(),
                                            ((Map<String, Object>) item.get("first_trip")).get("departure_date").toString(),
                                            "(UMT+5:30)",
                                            ((Map<String, Object>) item.get("first_trip")).get("departure_planet").toString(),
                                            item.get("flying_time").toString(),
                                            ((Map<String, Object>) item.get("vehicle")).get("driving_mode").toString(),
                                            ((Map<String, Object>) item.get("second_trip")).get("departure_time").toString(),
                                            ((Map<String, Object>) item.get("second_trip")).get("departure_date").toString(),
                                            "(UMT+5:30)",
                                            ((Map<String, Object>) item.get("second_trip")).get("departure_planet").toString(),
                                            item.get("flying_time").toString(),
                                            ((Map<String, Object>) item.get("first_trip")).get("arrival_time").toString(),
                                            ((Map<String, Object>) item.get("first_trip")).get("arrival_date").toString(),
                                            "(UMT+5:30)",
                                            ((Map<String, Object>) item.get("first_trip")).get("arrival_planet").toString(),
                                            ((Map<String, Object>) item.get("second_trip")).get("arrival_time").toString(),
                                            ((Map<String, Object>) item.get("second_trip")).get("arrival_date").toString(),
                                            "(UMT+5:30)",
                                            ((Map<String, Object>) item.get("second_trip")).get("arrival_planet").toString(),
                                            ((Map<String, Object>) item.get("culture")).get("clothing").toString()+((Map<String, Object>) item.get("culture")).get("feeding")+((Map<String, Object>) item.get("culture")).get("living"),
                                            ((Map<String, Object>) item.get("vehicle")).get("name").toString(),
                                            ((Map<String, Object>) item.get("vehicle")).get("vehicle_description").toString(),
                                            ((Map<String, Object>) item.get("vehicle")).get("image").toString(),
                                            ((Map<String, Object>) item.get("weather")).get("dust").toString(),
                                            ((Map<String, Object>) item.get("weather")).get("wind").toString(),
                                            ((Map<String, Object>) item.get("weather")).get("temp").toString(),
                                            ((Map<String, Object>) item.get("special_activities")).get("title").toString(),
                                            ((Map<String, Object>) item.get("special_activities")).get("description").toString(),
                                            String.valueOf("UC"+(int)(Integer.parseInt(item.get("price").toString().replace("UC","").trim())*bookedTrip.getPriceFactor())),
                                            "Special activities included",
                                            true

                                    ));
                                }

                                loadingBar.setVisibility(View.GONE);
                                adapter=new RecViewAdapter(PackageDetailsActivity.this, packages, new ItemClickListener() {
                                    @Override
                                    public void onItemClicked(int position) {
                                        Package selectedPackage = packages.get(position);
                                        Intent intent= new Intent(PackageDetailsActivity.this,PackageDescriptionActivity.class);
                                        intent.putExtra("package",selectedPackage);
                                        intent.putExtra("booked",bookedTrip);
                                        startActivity(intent);
                                    }
                                });
                                recyclerView.setLayoutManager(new LinearLayoutManager(PackageDetailsActivity.this));
                                recyclerView.setAdapter(adapter);
                            }
                        });



                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(PackageDetailsActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        loadingBar.setVisibility(View.GONE);
                    }
                });

        // title1111,  departureTime111, departureDate111, departureZone111,  departurePlanet111, duration111, pioletMode111,  backDepartureTime111,  backDepartureDate111, backDepartureZone111,  backDeparturePlanet111, backDuration111,  arrivalTime111,  arrivalDate111,  arrivalZone, arrivalPlanet,  backArrivalTime,  backArivalDate,  backArrivalZone,  backArrivalPlanet,  cultureDescription, vehicleName,  vehicleDescription,  vehicleImageIrl,  dust,  wind,  temp,  specialActivityTitle,  specialActivityDescription,  price, String tag, boolean selectCheckBox






    }

    public int compareDates(Date date1, Date date2) {
        return date1.compareTo(date2);

    }

    @Override
    protected void onStop() {
        filterButton.setVisibility(View.GONE);
        super.onStop();
    }

    private String formateDate(Date date){
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM d yyyy");

        // Format the date and print the result
        return outputFormat.format(date);
    }
}