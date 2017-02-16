package com.example.agupt23.tourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TouristAttractionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_layout);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new TouristAttractionsFragment())
                .commit();
    }
}
