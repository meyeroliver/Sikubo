package com.example.sikubo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sikubo.view.RouteFragment;

public class RouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_route, new RouteFragment())
                    .commit();
        }
    }
}
