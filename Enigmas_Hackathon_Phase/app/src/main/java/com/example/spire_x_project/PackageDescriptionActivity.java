package com.example.spire_x_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.spire_x_project.models.BookedTrip;
import com.example.spire_x_project.rec_views.package_list.Package;

public class PackageDescriptionActivity extends AppCompatActivity {

    TextView packageName;

    //first trip departure details holders
    TextView firstDepartureTime,firstDepartureDate,firstDepatureZone,firstDeparturePlanet;

    //first trip arrival details holders
    TextView firstArrivalTime,firstArrivalDate,firstArrivalZone,firstArrivalPlanet;

    //second trip departure details
    TextView secondDepartureTime,secondDepartureDate,secondDepatureZone,secondDeparturePlanet;

    //second trip arrival details
    TextView secondArrivalTime,secondArrivalDate,secondArrivalZone,secondArrivalPlanet;

    TextView cultureDescription;
    TextView dust,wind,temp;

    TextView specialActivityTitle,specialActivityDescription;
    TextView vehicleName,vehicleDescription;
    ImageView vehicleImage;
    TextView price;
    Button proceedButton;


    Package selectedPackage;
    BookedTrip bookedTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pavkage_description);

        Intent intent = getIntent();
        if (intent != null) {
            selectedPackage = (Package) intent.getSerializableExtra("package");
            bookedTrip=(BookedTrip) intent.getSerializableExtra("booked");
        }




        initViews();

        setValuesToViews();

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PackageDescriptionActivity.this,CheckOutActivity.class);
                intent.putExtra("package",selectedPackage);
                intent.putExtra("booked",bookedTrip);
                startActivity(intent);
            }
        });

    }

    private void initViews(){
        packageName=findViewById(R.id.package_name_tv);

        firstDepartureTime=findViewById(R.id.d_departure_time_tv);
        firstDepartureDate = findViewById(R.id.d_departure_date_tv);
        firstDepatureZone = findViewById(R.id.d_departure_time_zone_tv);
        firstDeparturePlanet = findViewById(R.id.d_departure_planet_tv);

        firstArrivalTime=findViewById(R.id.d_arrival_time_tv);
        firstArrivalDate = findViewById(R.id.d_arrival_date_tv);
        firstArrivalZone = findViewById(R.id.d_arrival_time_zone_tv);
        firstArrivalPlanet = findViewById(R.id.d_arrival_planet_tv);

        secondDepartureTime =findViewById(R.id.a_departure_time_tv);
        secondDepartureDate = findViewById(R.id.a_departure_date_tv);
        secondDepatureZone = findViewById(R.id.a_departure_time_zone_tv);
        secondDeparturePlanet = findViewById(R.id.a_departure_planet_tv);

        secondArrivalTime =findViewById(R.id.a_arrival_time_tv);
        secondArrivalDate = findViewById(R.id.a_arrival_date_tv);
        secondArrivalZone = findViewById(R.id.a_arrival_time_zone_tv);
        secondArrivalPlanet = findViewById(R.id.a_arrival_planet_tv);

        cultureDescription=findViewById(R.id.culture_description_tv);
        dust =findViewById(R.id.dust_tv);
        wind=findViewById(R.id.wind_tv);
        temp=findViewById(R.id.temp_tv);

        specialActivityTitle=findViewById(R.id.special_activity_title_tv);
        specialActivityDescription=findViewById(R.id.special_activity_description_tv);

        vehicleName=findViewById(R.id.vehicle_name_tv);
        vehicleDescription=findViewById(R.id.vehicle_description_tv);
        vehicleImage=findViewById(R.id.vehicle_image_view);

        price=findViewById(R.id.price_tv);
        proceedButton=findViewById(R.id.proceed_button);
    }

    private void setValuesToViews(){
        packageName.setText(selectedPackage.getTitle());
        firstDepartureTime.setText(selectedPackage.getDepartureTime());
        firstDepartureDate.setText(selectedPackage.getDepartureDate());
        firstDepatureZone.setText(selectedPackage.getDepartureZone());
        firstDeparturePlanet.setText(selectedPackage.getDeparturePlanet());

        firstArrivalTime.setText(selectedPackage.getArrivalTime());
        firstArrivalDate.setText(selectedPackage.getArrivalDate());
        firstArrivalZone.setText(selectedPackage.getArrivalZone());
        firstArrivalPlanet.setText(selectedPackage.getArrivalPlanet());

        secondDepartureTime.setText(selectedPackage.getBackDepartureTime());
        secondDepartureDate.setText(selectedPackage.getBackDepartureDate());
        secondDepatureZone.setText(selectedPackage.getBackDepartureZone());
        secondDeparturePlanet.setText(selectedPackage.getBackDeparturePlanet());

        secondArrivalTime.setText(selectedPackage.getBackArrivalTime());
        secondArrivalDate.setText(selectedPackage.getBackArivalDate());
        secondArrivalZone.setText(selectedPackage.getBackArrivalZone());
        secondArrivalPlanet.setText(selectedPackage.getBackArrivalPlanet());

        cultureDescription.setText(selectedPackage.getCultureDescription());
        dust.setText(selectedPackage.getDust());
        wind.setText(selectedPackage.getWind());
        temp.setText(selectedPackage.getTemp());

        specialActivityTitle.setText(selectedPackage.getSpecialActivityTitle());
        specialActivityDescription.setText(selectedPackage.getSpecialActivityDescription());

        vehicleName.setText(reformatString(selectedPackage.getVehicleName()));
        vehicleDescription.setText(selectedPackage.getVehicleDescription());
        Glide.with(this)
                .load(selectedPackage.getVehicleImageIrl())
                .into(vehicleImage);
        //vehicleImage.setImageURI("");


        price.setText(selectedPackage.getPrice());
    }

    //To reformate string vertically
    public String reformatString(String input) {
        StringBuilder reformatted = new StringBuilder();

        for (char c : input.toCharArray()) {
            reformatted.append("\n").append(c);
        }

        return reformatted.toString();
    }



}