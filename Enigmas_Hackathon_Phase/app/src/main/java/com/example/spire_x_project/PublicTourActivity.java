package com.example.spire_x_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spire_x_project.ui.public_tour_activity.fragments.PageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class PublicTourActivity extends AppCompatActivity {

    private static final int YOUR_REQUEST_CODE = 145;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_tour);

        ImageView backButton=findViewById(R.id.back_button);
        TextView appBarTitle=findViewById(R.id.app_bar_title);
        appBarTitle.setText("PUBLIC TOUR");
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        //Initialize TabLayout
        TabLayout tabLayout=findViewById(R.id.tab_layout);

        //Initialize ViewPager2
        ViewPager2 viewPager2=findViewById(R.id.view_pager2);

        PageAdapter pageAdapter=new PageAdapter(this);

        viewPager2.setAdapter(pageAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Objects.requireNonNull(tabLayout.getTabAt(position)).select();
            }
        });
    }

}