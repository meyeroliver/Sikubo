package com.example.sikubo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBarBig;
    private ProgressBar progressBarMedium;
    private ProgressBar progressBarSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarBig  = findViewById(R.id.big_bar);
        progressBarMedium  = findViewById(R.id.medium_bar);
        progressBarSmall  = findViewById(R.id.small_bar);

        startAsyncTask(progressBarBig);

    }

    public void startAsyncTask(View v) {
        ProgressBarAsyncTask task = new ProgressBarAsyncTask(this);
        task.execute(100);

    }

    private static class ProgressBarAsyncTask extends AsyncTask<Integer, Integer, Boolean> {

        private WeakReference<MainActivity> activityWeakReference;
        ProgressBarAsyncTask (MainActivity activity) {
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            MainActivity activity = activityWeakReference.get();

            if (activity == null || activity.isFinishing()){
                return;
            }
            activity.progressBarBig.setVisibility(View.VISIBLE);
            activity.progressBarMedium.setVisibility(View.VISIBLE);
            activity.progressBarSmall.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {

            for (int i = 0; i < integers[0]; i++) {
                publishProgress((i * 100) / integers[0]);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            MainActivity activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()){
                return;
            }
            activity.progressBarBig.setProgress(values[0]);
            activity.progressBarMedium.setProgress(values[0]);
            activity.progressBarSmall.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            MainActivity activity = activityWeakReference.get();
            Intent intent = new Intent(activity, TransportActivity.class);
            activity.startActivity(intent);
        }
    }

}
