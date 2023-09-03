package com.example.spire_x_project.database_handle;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.spire_x_project.rec_views.station_list.Station;
import com.google.gson.Gson;

public class SharedPreferenceManager {

    private static final String PREFERENCES_NAME = "MyPrefs";
    private static final String STATION_KEY = "stationObject";

    // Method to store a Station object in SharedPreferences
    public static void saveStation(Context context, Station station) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String stationJson = gson.toJson(station);
        editor.putString(STATION_KEY, stationJson);

        editor.apply();
    }

    // Method to read the stored Station object from SharedPreferences
    public static Station getStation(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        String stationJson = sharedPreferences.getString(STATION_KEY, null);

        if (stationJson != null) {
            Gson gson = new Gson();
            return gson.fromJson(stationJson, Station.class);
        } else {
            return null;
        }
    }

    // Method to delete the stored Station object from SharedPreferences
    public static void deleteStation(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(STATION_KEY);
        editor.apply();
    }
}
