package com.example.sikubo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sikubo.view.LineUpdateFragment;

public class LineUpdatesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_updates);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_lineUpdates, new LineUpdateFragment())
                    .commit();
        }
    }
}
