package com.example.spire_x_project.rec_views.package_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spire_x_project.R;
import com.example.spire_x_project.rec_views.ItemClickListener;
import com.example.spire_x_project.rec_views.station_list.Station;

import java.util.List;


public class RecViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Package> packages;

    ItemClickListener itemClickListener;


    public RecViewAdapter(Context context, List<Package> packages,ItemClickListener itemClickListener) {
        this.context = context;
        this.packages = packages;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.package_details_rec_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(packages.get(position).title);
        holder.departureTime.setText(packages.get(position).getDepartureTime());
        holder.departureDate.setText(packages.get(position).getDepartureDate());
        holder.departureZone.setText(packages.get(position).getDepartureZone());
        holder.departurePlanet.setText(packages.get(position).getDeparturePlanet());
        holder.duration.setText(packages.get(position).getDuration());
        holder.pioletMode.setText(packages.get(position).getPioletMode());
        holder.arrivalTime.setText(packages.get(position).getArrivalTime());
        holder.arrivalDate.setText(packages.get(position).getArrivalDate());
        holder.arrivalZone.setText(packages.get(position).getArrivalZone());
        holder.arrivalPlanet.setText(packages.get(position).getArrivalPlanet());
        holder.price.setText(packages.get(position).getPrice());
        holder.tag.setText(packages.get(position).getTag());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(position);
            }
        });




    }

    @Override
    public int getItemCount() {
        return packages.size();
    }
}
