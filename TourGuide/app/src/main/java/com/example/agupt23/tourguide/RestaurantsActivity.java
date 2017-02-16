package com.example.agupt23.tourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_layout);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new RestaurantsFragment())
                .commit();
    }
}
