package com.example.spire_x_project.API;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface DataReceivedListner {
    void OnDataReceived(ArrayList<Map<String,Object>> arrayList);
}
