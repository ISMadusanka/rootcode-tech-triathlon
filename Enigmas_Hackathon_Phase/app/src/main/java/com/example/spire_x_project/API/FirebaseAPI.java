package com.example.spire_x_project.API;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.spire_x_project.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class FirebaseAPI {
    private static final String DATABASE_PATH = "your_database_path"; // Replace with your actual database path
    private DatabaseReference databaseReference;

    private  FirebaseFirestore db;
    private Context context;
    public FirebaseAPI(Context context) {
        // Initialize Firebase
         db = FirebaseFirestore.getInstance();

         this.context=context;
    }

    // Method to write data to the database
    public void writeData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", "1815");

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });

    }

    // Method to read data from the database
    public void readData(String key,DataReceivedListner dataReceivedListner) {
        //databaseReference.child(key).addListenerForSingleValueEvent(listener);

        db.collection(key)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Map<String,Object>> arrayList=new ArrayList();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("DATA", document.getId() + " => " + document.getData());
                                arrayList.add(document.getData());
                            }

                            dataReceivedListner.OnDataReceived(arrayList);
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void search(String collection, String searchTag,String searchValue,DataReceivedListner dataReceivedListner) {
        db.collection(collection)
                .whereEqualTo(searchTag, searchValue)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Map<String,Object>> arrayList=new ArrayList();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                                arrayList.add(document.getData());
                            }

                            dataReceivedListner.OnDataReceived(arrayList);

                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }


    public void searchPackages(String departureCode,String arrivalCode,String depatureDate,String arrivalDate,DataReceivedListner dataReceivedListner) {
        db.collection("packages")
                .whereEqualTo(FieldPath.of("first_trip", "departure_code"), departureCode)
                .whereEqualTo(FieldPath.of("first_trip", "arrival_code"), arrivalCode)
                .whereEqualTo(FieldPath.of("first_trip", "departure_date"), depatureDate)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Map<String,Object>> arrayList=new ArrayList();
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                                if (arrayList.size()<1){
                                    arrayList.add(document.getData());
                                }
                            }


                            dataReceivedListner.OnDataReceived(arrayList);

                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public void setData(){
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("Orders")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(context, "add", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}

