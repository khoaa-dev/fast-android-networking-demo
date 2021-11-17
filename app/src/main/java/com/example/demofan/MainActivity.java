package com.example.demofan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_food;
    ArrayList<Food> listFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_food = (RecyclerView) findViewById(R.id.rcv_food);

        loadData();
    }

    private void loadData() {
        AndroidNetworking.get("http://ec2-3-18-213-174.us-east-2.compute.amazonaws.com:3000/api/food/1")
                    .build()
                    .getAsJSONArray(new JSONArrayRequestListener() {
                        @Override
                        public void onResponse(JSONArray response) {
                            listFood = new ArrayList<>();
                            for(int i = 0; i < response.length(); i++) {
                                try {
                                    Food food = new Food();
                                    JSONObject obj = response.getJSONObject(i);
                                    food.setId(obj.getInt("id"));
                                    food.setName(obj.getString("nameFood"));
                                    food.setImageUrl(obj.getString("imageFood"));
                                    food.setPrice(obj.getInt("price"));
                                    food.setRestaurantId(obj.getInt("restaurantId"));

                                    listFood.add(food);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            FoodAdapter adapter = new FoodAdapter(getApplicationContext(), listFood);
                            rcv_food.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            rcv_food.setAdapter(adapter);
                        }

                        @Override
                        public void onError(ANError anError) {

                        }
                    });
    }
}