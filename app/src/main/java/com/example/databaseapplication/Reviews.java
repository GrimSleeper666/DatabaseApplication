package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Reviews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper db = new DatabaseHelper(this);
        setContentView(R.layout.activity_reviews);
        Long restaurantID = getIntent().getLongExtra("ID",0);
        Cursor restaurant = db.findRestaurant(Integer.valueOf(restaurantID.intValue()));

        restaurant.moveToFirst();

        String name = restaurant.getString(1);
        TextView label = findViewById(R.id.review_restauant_name_label);
        label.setText(name);

    }
}