package com.example.spire_x_project.ui.public_tour_activity.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.spire_x_project.ui.public_tour_activity.fragments.ui.OneWayFragment;
import com.example.spire_x_project.ui.public_tour_activity.fragments.ui.RoundTripFragment;

public class PageAdapter extends FragmentStateAdapter {
    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        // TODO implement this proper way
        if (position==0){
            return new RoundTripFragment();
        }else {
            return new OneWayFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
