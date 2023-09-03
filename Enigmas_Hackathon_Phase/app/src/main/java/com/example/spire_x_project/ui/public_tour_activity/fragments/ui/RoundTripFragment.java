package com.example.spire_x_project.ui.public_tour_activity.fragments.ui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spire_x_project.PackageDetailsActivity;
import com.example.spire_x_project.R;
import com.example.spire_x_project.StationListViewActivity;
import com.example.spire_x_project.database_handle.SharedPreferenceManager;
import com.example.spire_x_project.models.BookedTrip;
import com.example.spire_x_project.rec_views.station_list.Station;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoundTripFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoundTripFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //identify depature or arrival clicks
    private boolean isDepartureClicked=false;
    private boolean isArrivalClicked=false;

    TextView departurePlace,departurePlanet,departureDate,departureDateName,arrivalDateName;
    TextView arrivalPlace,arrivalPlanet,arrivalDate;

    BookedTrip bookedTrip = new BookedTrip();

    //Pssenger count
    int adult=0;
    int child=0;
    int infant=0;

    //Passenger selected travel class
    int travelClass=-1;
    public RoundTripFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoundTripFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoundTripFragment newInstance(String param1, String param2) {
        RoundTripFragment fragment = new RoundTripFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_round_trip, container, false);

        departurePlace = view.findViewById(R.id.departure_place_tv);
        arrivalPlace = view.findViewById(R.id.arrival_place_tv);
        departurePlanet = view.findViewById(R.id.depature_pannet_tv);
        arrivalPlanet = view.findViewById(R.id.arrival_planet_tv);
        departureDate=view.findViewById(R.id.departure_date_tv);
        arrivalDate=view.findViewById(R.id.arrival_date_tv);
        departureDateName=view.findViewById(R.id.depature_date_name);
        arrivalDateName=view.findViewById(R.id.arrival_date_name);

        NumberPicker adultsPicker=view.findViewById(R.id.adults_picker);
        NumberPicker childPicker=view.findViewById(R.id.child_picker);
        NumberPicker infantsPicker=view.findViewById(R.id.infant_picker);

        RadioGroup classSelectRadio = view.findViewById(R.id.class_choice_radio_group);

        Button nextButton=view.findViewById(R.id.next_button);

        //Select travel class
        classSelectRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = view.findViewById(checkedId);
                String selectedChoice = radioButton.getText().toString();
                travelClass=checkedId;
                bookedTrip.setTripClass(checkedId);


            }
        });


        adultsPicker.setMinValue(0);
        adultsPicker.setMaxValue(10);

        childPicker.setMinValue(0);
        childPicker.setMaxValue(10);

        infantsPicker.setMinValue(0);
        infantsPicker.setMaxValue(10);

        adultsPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                adult=newVal;
                bookedTrip.setAdultCount(newVal);
            }
        });

        childPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                child=newVal;
                bookedTrip.setChildCount(newVal);
            }
        });

        infantsPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                infant=newVal;
                bookedTrip.setInfantCount(newVal);
            }
        });

        departurePlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StationListViewActivity.class));

                isDepartureClicked=true;
                isArrivalClicked=false;
            }
        });

        arrivalPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), StationListViewActivity.class));
                isArrivalClicked=true;
                isDepartureClicked=false;
            }
        });

        departureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDepartureDate();
            }
        });

        arrivalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickArrivalDate();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!departurePlanet.getText().toString().equals("---")){

                    if (!arrivalPlanet.getText().toString().equals("---")){

                        if (!departureDate.getText().toString().equals("---")){
                            if (!arrivalDate.getText().toString().equals("---")){



                                if (adult!=0 || child!=0 || infant!=0){

                                    //price factor setup
                                    if (travelClass!=-1){

                                        if (travelClass==0){
                                            bookedTrip.setPriceFactor(bookedTrip.getPriceFactor()+0.3f);
                                        }else
                                        if (travelClass==1){
                                            bookedTrip.setPriceFactor(bookedTrip.getPriceFactor()+0.2f);

                                        }else {
                                            bookedTrip.setPriceFactor(bookedTrip.getPriceFactor()+0.1f);
                                        }

                                        if (adult!=0){
                                            bookedTrip.setPriceFactor(bookedTrip.getPriceFactor()+0.2f*adult);
                                        }
                                        if (child!=0){
                                            bookedTrip.setPriceFactor(bookedTrip.getPriceFactor()+0.1f*adult);
                                        }

                                        Intent intent=new Intent(getActivity(), PackageDetailsActivity.class);
                                        intent.putExtra("booked_trip",bookedTrip);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(getContext(), "Please choose a travel class", Toast.LENGTH_SHORT).show();
                                    }

                                }else {
                                    Toast.makeText(getContext(), "Select at least one passenger", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(getContext(), "Please choose a departure date", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(getContext(), "Please choose a departure date", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(getContext(), "Please choose a arrival station", Toast.LENGTH_SHORT).show();

                    }

                }else {
                    Toast.makeText(getContext(), "Please choose a departure station", Toast.LENGTH_SHORT).show();

                }





            }
        });


       return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Station currentStation=new Station("","","","","");
        Station station= SharedPreferenceManager.getStation(getContext());
        if (station!=null){
            currentStation=station;
        }
        SharedPreferenceManager.deleteStation(getContext());

        if(isDepartureClicked){
            departurePlace.setText(currentStation.getCode());
            departurePlanet.setText(currentStation.getPlanetName());
            bookedTrip.setDepartureCode(currentStation.getCode());
            bookedTrip.setDeparturePlanet(currentStation.getPlanetName());

            isDepartureClicked=false;
        }

        if (isArrivalClicked){
            arrivalPlace.setText(currentStation.getCode());
            arrivalPlanet.setText(currentStation.getPlanetName());
            bookedTrip.setArrivalCode(currentStation.getCode());
            bookedTrip.setArrivalPlanet(currentStation.getPlaceName());

            isArrivalClicked=false;
        }

        //reset booked trip price factor for new factor
        bookedTrip.resetPriceFactor();
    }


    private void pickDepartureDate() {
        final Calendar c = Calendar.getInstance();

        // Initial values for year, month, and day.
        int year = 2160;
        int month = 7; // August (0-based)
        int day = 31;

        Calendar minDateCalendar = Calendar.getInstance();
        minDateCalendar.set(Calendar.YEAR, 2160);
        minDateCalendar.set(Calendar.MONTH, 7); // August (0-based)
        minDateCalendar.set(Calendar.DAY_OF_MONTH, 31);

        Calendar maxDateCalendar = Calendar.getInstance();
        maxDateCalendar.set(Calendar.YEAR, 2160);
        maxDateCalendar.set(Calendar.MONTH, 8); // September (0-based)
        maxDateCalendar.set(Calendar.DAY_OF_MONTH, 30);

        // Create a date picker dialog with min and max dates.
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Handle the selected date here.
                        String date = String.valueOf(dayOfMonth) + getMonth(monthOfYear);
                        departureDate.setText(date);
                        departureDateName.setText(getDayName(year-1900, monthOfYear, dayOfMonth));
                        bookedTrip.setDepartureDate(new Date(year-1900, monthOfYear, dayOfMonth));
                    }
                },
                year, month, day);

        // Set min and max dates for the date picker.
        datePickerDialog.getDatePicker().setMinDate(minDateCalendar.getTimeInMillis());
        datePickerDialog.getDatePicker().setMaxDate(maxDateCalendar.getTimeInMillis());

        datePickerDialog.show();
    }

    private void pickArrivalDate() {
        final Calendar c = Calendar.getInstance();

        // Initial values for year, month, and day.
        int year = 2160;
        int month = 8; // August (0-based)
        int day = 31;

        Calendar minDateCalendar = Calendar.getInstance();
        minDateCalendar.set(Calendar.YEAR, 2160);
        minDateCalendar.set(Calendar.MONTH, 8); // August (0-based)
        minDateCalendar.set(Calendar.DAY_OF_MONTH, 31);

        Calendar maxDateCalendar = Calendar.getInstance();
        maxDateCalendar.set(Calendar.YEAR, 2160);
        maxDateCalendar.set(Calendar.MONTH, 9); // September (0-based)
        maxDateCalendar.set(Calendar.DAY_OF_MONTH, 30);

        // Create a date picker dialog with min and max dates.
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // Handle the selected date here.
                        String date = String.valueOf(dayOfMonth) + getMonth(monthOfYear);
                        arrivalDate.setText(date);
                        arrivalDateName.setText(getDayName(year-1900, monthOfYear, dayOfMonth));
                        bookedTrip.setArrivalDate(new Date(year-1900, monthOfYear, dayOfMonth));
                    }
                },
                year, month, day);

        // Set min and max dates for the date picker.
        datePickerDialog.getDatePicker().setMinDate(minDateCalendar.getTimeInMillis());
        datePickerDialog.getDatePicker().setMaxDate(maxDateCalendar.getTimeInMillis());

        datePickerDialog.show();
    }

//    private void pickArrivalDate(){
//        final Calendar c = Calendar.getInstance();
//
//        // on below line we are getting
//        // our day, month and year.
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//
//        // on below line we are creating a variable for date picker dialog.
//        DatePickerDialog datePickerDialog = new DatePickerDialog(
//                // on below line we are passing context.
//
//                getContext(),
//                new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year,
//                                          int monthOfYear, int dayOfMonth) {
//                        // on below line we are setting date to our text view.
//
//                        //TODO Set correct way
//                        String date=String.valueOf(dayOfMonth)+getMonth(monthOfYear);
//
//                        arrivalDate.setText(date);
//                        arrivalDateName.setText(getDayName(year,month,day));
//                        bookedTrip.setArrivalDate(new Date(year,month,day));
//
//                    }
//                },
//                // on below line we are passing year,
//                // month and day for selected date in our date picker.
//                year, month, day);
//
//        datePickerDialog.show();
//    }




    private String getMonth(int monthOfYear){
        switch (monthOfYear){
            case 0:
                return "JAN";
            case 1:
                return "FEB";
            case 2:
                return "MAR";
            case 3:
                return "APR";
            case 4:
                return "MAY";
            case 5:
                return "JUN";
            case 6:
                return "JUL";
            case 7:
                return "AUG";
            case 8:
                return "SEP";
            case 9:
                return "OCT";
            case 10:
                return "NOV";
            case 11:
                return "DEC";
            default:
                return " ";
        }
    }

    public String getDayName(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] dayNames = dfs.getWeekdays();

        return dayNames[dayOfWeek];
    }



}