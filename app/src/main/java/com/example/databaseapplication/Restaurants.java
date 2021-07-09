package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());

        Cursor restaurants = db.getRestaurants();
        restaurants.moveToFirst();

        while(!restaurants.isAfterLast()) {
            String name = restaurants.getString(0);
            restaurants.moveToNext();
        }


        setContentView(R.layout.activity_restaurants);
        Button btn = findViewById(R.id.restaurantSaveBtn);
        EditText rName = findViewById(R.id.restaurantNameText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name",rName.getText().toString());

                Long id = db.addRestaurant(values);
                Intent intent = new Intent(getApplicationContext(),Reviews.class);
                intent.putExtra("ID",id);
                startActivity(intent);

            }
        });
    }
}