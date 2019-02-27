package com.example.sikubo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sikubo.view.RouteFragment;
import com.example.sikubo.view.StopsFragment;

public class StopsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stops);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_stops, new StopsFragment())
                    .commit();
        }
    }
}
