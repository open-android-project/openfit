package com.openfit.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.openfit.DTOs.RoutineGetListDTO;
import com.openfit.Models.Routine;

import java.util.List;

@Dao
public interface RoutineDAO {
    @Query("SELECT name FROM routine ORDER BY name")
    LiveData<List<RoutineGetListDTO>> getRoutineList();

    @Query("SELECT COUNT(*) FROM routine")
    LiveData<Integer> count();

    @Insert
    void insert(Routine routine);
}
