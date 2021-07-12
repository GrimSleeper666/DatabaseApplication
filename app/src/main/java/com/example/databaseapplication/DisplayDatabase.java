package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayDatabase extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            DatabaseHelper db = new DatabaseHelper(this);
            setContentView(R.layout.activity_display_database);


            Button returnRBtn = findViewById(R.id.returnButton);

            returnRBtn.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            });


            Long restaurantID = getIntent().getLongExtra("ID",0);
            Cursor restaurant = db.findRestaurant(Integer.valueOf(restaurantID.intValue()));

            restaurant.moveToFirst();

            String name = restaurant.getString(1);
            TextView label = findViewById(R.id.review_restauant_name_label);
            label.setText(name);
            
        }
}