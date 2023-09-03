package com.example.spire_x_project.list_views;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.spire_x_project.API.DataReceivedListner;
import com.example.spire_x_project.API.FirebaseAPI;
import com.example.spire_x_project.R;
import com.example.spire_x_project.models.PersonData;

import java.util.ArrayList;
import java.util.Map;

public class PersonDataAdapter extends ArrayAdapter<PersonData> {

    private static final String TAG = "PersonDataAdapter"; // Log tag

    // Member variables
    private Context context;
    private int resource;
    private FirebaseAPI firebaseAPI;
    private ArrayList<PersonData> objects;

    // Constructor
    public PersonDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<PersonData> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        firebaseAPI = new FirebaseAPI(context);
    }

    // Method to set up and return the custom view for each list item
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout for the list item
        convertView = inflater.inflate(resource, parent, false);

        // Get the data for the current item
        PersonData currentItem = getItem(position);

        // Initialize views from the custom layout
        TextView title = convertView.findViewById(R.id.title_tv);
        EditText uid = convertView.findViewById(R.id.editText);
        TextView personName = convertView.findViewById(R.id.person_name);
        TextView motherPlanet = convertView.findViewById(R.id.mother_planet);

        // Set data to the views
        title.setText(currentItem.getTitle());
        uid.setText(currentItem.getUid());
        personName.setText(currentItem.getName());
        motherPlanet.setText(currentItem.getPlanetName());

        // Add a text watcher to the UID EditText for live searching
        uid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this implementation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not needed for this implementation
            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = uid.getText().toString().trim();
                if (searchText.length() > 3) {
                    // Perform a search using the FirebaseAPI
                    firebaseAPI.search("users", "uid", searchText, new DataReceivedListner() {
                        @Override
                        public void OnDataReceived(ArrayList<Map<String, Object>> arrayList) {
                            if (arrayList.size() > 0) {
                                // Update the currentItem with data from the search result
                                currentItem.setUid(arrayList.get(0).get("uid").toString());
                                currentItem.setName(arrayList.get(0).get("name").toString());
                                currentItem.setPlanetName(arrayList.get(0).get("planet").toString());
                            }
                        }
                    });
                }
            }
        });

        return convertView; // Return the populated view for the list item
    }
}
