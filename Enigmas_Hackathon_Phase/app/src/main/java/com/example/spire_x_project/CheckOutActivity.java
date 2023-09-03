package com.example.spire_x_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.spire_x_project.API.FirebaseAPI;
import com.example.spire_x_project.list_views.PersonDataAdapter;
import com.example.spire_x_project.models.BookedTrip;
import com.example.spire_x_project.models.Order;
import com.example.spire_x_project.models.PersonData;
import com.example.spire_x_project.rec_views.package_list.Package;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {

    private Package selectedPackage;
    private BookedTrip bookedTrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        ImageView backButton=findViewById(R.id.back_button);
        TextView appTitle = findViewById(R.id.app_bar_title);
        Button confirmButton=findViewById(R.id.confirm_button);

        appTitle.setText("CHECKOUT");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView contactPersonName=findViewById(R.id.contact_person_name_tv);
        TextView conttactPersonMotherPlanet=findViewById(R.id.mother_planet_tv);

        Intent intent = getIntent();
        if (intent != null) {
            selectedPackage = (Package) intent.getSerializableExtra("package");
            bookedTrip=(BookedTrip) intent.getSerializableExtra("booked");
        }

        ListView listView=findViewById(R.id.list_view);
        ArrayList<PersonData> list = new ArrayList<PersonData>();

        int totalPassengers = bookedTrip.getAdultCount()+bookedTrip.getChildCount()+bookedTrip.getInfantCount();

        for (int i=1;i<=totalPassengers;i++){
            list.add(new PersonData("PASSENGER "+i,"Name","","Home Planet"));
        }



        PersonDataAdapter personDataAdapter=new PersonDataAdapter(this,R.layout.checkout_list_view_item,list);
        listView.setAdapter(personDataAdapter);


        View dialog= LayoutInflater.from(this).inflate(R.layout.payment_confirm_card,null);
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setView(dialog);
        AlertDialog alert=alertDialog.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Order order=new Order();
                order.setBookedTrip(bookedTrip);
                order.setSelectedPackage(selectedPackage);
                order.setPassengerDetails(list);

                alert.show();

            }
        });

        FirebaseAuth.getInstance()
                .signInAnonymously()
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        FirebaseAPI firebaseAPI=new FirebaseAPI(CheckOutActivity.this);
                        firebaseAPI.writeData();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }
}