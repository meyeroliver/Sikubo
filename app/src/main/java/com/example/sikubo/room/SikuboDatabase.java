
package com.example.sikubo.room;

import android.content.Context;

import com.example.sikubo.model.PublicTransportMotorVehicle;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PublicTransportMotorVehicle.class}, version = 1, exportSchema = false)
public abstract class SikuboDatabase extends RoomDatabase {

    private static SikuboDatabase instance;

    public abstract TransportDao transportDao();

    public static synchronized SikuboDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SikuboDatabase.class, "public_transport_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

