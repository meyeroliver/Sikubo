package com.example.sikubo.viewmodel;

import android.app.Application;

import com.example.sikubo.api.Repository;
import com.example.sikubo.model.LineUpdates;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class LineUpdatesViewModel extends AndroidViewModel {

    private LiveData<LineUpdates> railLineUpdates;
    private Repository repository;

    public LineUpdatesViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository();
    }

    public LiveData<LineUpdates> getRailLineUpdates(String id) {

        /**
         * TODO: I believe the configuration error is right here
         */
        if (this.railLineUpdates != null) {
            return null;
        }
        this.railLineUpdates = repository.getRailLineUpdates();
        return this.railLineUpdates;
    }
}
