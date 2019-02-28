package com.example.sikubo.room;

import com.example.sikubo.model.PublicTransportMotorVehicle;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TransportDao {

    @Insert
    void insertTransport(PublicTransportMotorVehicle vehicle);

    @Update
    void updateTransport(PublicTransportMotorVehicle vehicle);

    @Delete
    void deleteTransport(PublicTransportMotorVehicle vehicle);

    @Query("DELETE FROM public_transport_table")
    void deleteAllTransport();

    /**
     * TODO: use a where to identify the mode of transport
     *
     */
    @Query("SELECT * FROM public_transport_table")
    LiveData<List<PublicTransportMotorVehicle>> getAlltransport();



}
