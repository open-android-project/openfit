package com.openfit.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.openfit.DTOs.MuscleGetListDTO;
import com.openfit.Models.Muscle;

import java.util.List;

@Dao
public interface MuscleDAO {
    @Query("SELECT id, name FROM muscle")
    LiveData<List<MuscleGetListDTO>> getAll();

    @Query("SELECT DISTINCT muscle_group FROM muscle")
    LiveData<List<String>> getAllGroups();

    @Query("SELECT COUNT(*) FROM muscle")
    int count();

    @Insert
    void insert(Muscle muscle);
}
