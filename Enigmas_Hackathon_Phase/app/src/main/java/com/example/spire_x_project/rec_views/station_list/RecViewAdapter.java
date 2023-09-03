package com.example.spire_x_project.rec_views.station_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spire_x_project.R;
import com.example.spire_x_project.rec_views.ItemClickListener;

import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Station> stations;

    ItemClickListener itemClickListener;

    public RecViewAdapter(Context context, List<Station> stations,ItemClickListener itemClickListener) {
        this.context = context;
        this.stations = stations;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.station_rec_view_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.placeNameTv.setText(stations.get(position).getPlaceName());

        //Set details section of the card
        String detailText = stations.get(position).getCode()+stations.get(position).getPlanetName()+stations.get(position).getStationName();
        holder.detailsTv.setText(detailText);

        //List item click listner
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }
}
