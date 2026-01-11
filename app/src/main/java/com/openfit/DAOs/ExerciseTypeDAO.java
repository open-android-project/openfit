package com.openfit.DAOs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.openfit.Models.ExerciseType;

import java.util.List;

@Dao
public interface ExerciseTypeDAO {
    @Query("SELECT * FROM exercisetype")
    List<ExerciseType> getAll();
    @Query("SELECT * FROM exercisetype WHERE id = :id")
    ExerciseType getById(int id);
    @Query("SELECT COUNT(*) FROM exercisetype")
    int count();
    @Insert
    void insert(ExerciseType exerciseType);
}
