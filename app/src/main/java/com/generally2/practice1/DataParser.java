package com.generally2.practice1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DataParser {

   private HashMap<String, String> getSinglePlace(JSONObject googleplaceJSON){
        HashMap<String, String> googlePlaceMap =  new HashMap<>();
        String nameOfPlace = "-NA-";
        String vicinity = "-NA-";
        String latitude;
        String longitude;
        String reference;

        try {
            if (!googleplaceJSON.isNull("name")){
                nameOfPlace = googleplaceJSON.getString("name");

            }
            if (!googleplaceJSON.isNull("vicinity")){
                vicinity = googleplaceJSON.getString("vicinity");

            }
            latitude = googleplaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googleplaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = googleplaceJSON.getString("reference");

            googlePlaceMap.put("place_name", nameOfPlace);
            googlePlaceMap.put("vicinity", vicinity);
            googlePlaceMap.put("lat", latitude);
            googlePlaceMap.put("lng", longitude);
            googlePlaceMap.put("reference", reference);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return googlePlaceMap;


    }

    private List<HashMap<String, String>> getAllNearbyPlaces(JSONArray jsonArray){

        int counter = jsonArray.length();
        List<HashMap<String, String>> NearbyPlacesList = new ArrayList<>();

        HashMap<String, String> NearbyPlaceMap = null;


        for (int i = 0; i < counter; i++) {
            try {
                NearbyPlaceMap = getSinglePlace((JSONObject) jsonArray.get(i));
                NearbyPlacesList.add(NearbyPlaceMap);
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return NearbyPlacesList;
        }

        List<HashMap<String, String>> parse(String jsonData){
            JSONArray jsonArray = null;

            try {
                JSONObject jsonObject = new JSONObject(jsonData);
                jsonArray = jsonObject.getJSONArray("results");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return getAllNearbyPlaces(jsonArray);


        }


    }


