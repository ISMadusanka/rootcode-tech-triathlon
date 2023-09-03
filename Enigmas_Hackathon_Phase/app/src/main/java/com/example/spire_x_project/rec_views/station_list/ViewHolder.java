package com.example.spire_x_project.rec_views.station_list;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spire_x_project.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView placeNameTv,detailsTv;
    Button viewButton;
    RelativeLayout relativeLayout;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        placeNameTv=itemView.findViewById(R.id.place_name_tv);
        detailsTv=itemView.findViewById(R.id.details_tv);
        viewButton=itemView.findViewById(R.id.view_button);
        relativeLayout=itemView.findViewById(R.id.relative_layout);
    }
}
