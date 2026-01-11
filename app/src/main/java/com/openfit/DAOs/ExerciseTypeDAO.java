package com.openfit.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.openfit.DTOs.ExerciseTypeGetListDTO;
import com.openfit.Models.ExerciseType;

import java.util.List;

@Dao
public interface ExerciseTypeDAO {
    @Query("SELECT id, name, description FROM exercisetype ORDER BY id ASC")
    LiveData<List<ExerciseTypeGetListDTO>> getAll();
    @Query("SELECT COUNT(*) FROM exercisetype")
    int count();
    @Insert
    void insert(ExerciseType exerciseType);
}
