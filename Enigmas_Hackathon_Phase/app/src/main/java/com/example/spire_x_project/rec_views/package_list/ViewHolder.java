package com.example.spire_x_project.rec_views.package_list;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spire_x_project.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView title,departureTime,departureDate,departureZone,departurePlanet,duration,pioletMode;
    TextView arrivalTime,arrivalDate,arrivalZone,arrivalPlanet;
    CardView cardView;

    TextView price,tag;
    CheckBox selectCheckBox;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        title=itemView.findViewById(R.id.title_tv);
        departureTime=itemView.findViewById(R.id.departure_time_tv);
        departureDate=itemView.findViewById(R.id.departure_date_tv);
        departureZone=itemView.findViewById(R.id.departure_time_zone_tv);
        departurePlanet=itemView.findViewById(R.id.departure_planet_tv);
        duration=itemView.findViewById(R.id.duration_tv);
        pioletMode=itemView.findViewById(R.id.piolet_mode_tv);
        arrivalTime=itemView.findViewById(R.id.arrival_time_tv);
        arrivalDate=itemView.findViewById(R.id.arrival_date_tv);
        arrivalZone=itemView.findViewById(R.id.arrival_time_zone_tv);
        arrivalPlanet=itemView.findViewById(R.id.arrival_planet_tv);
        price=itemView.findViewById(R.id.price_tv);
        tag=itemView.findViewById(R.id.special_activity_tag_tv);
        selectCheckBox=itemView.findViewById(R.id.select_checkbox);

        cardView=itemView.findViewById(R.id.card_view);

    }
}
