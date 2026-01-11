package com.openfit.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.openfit.DTOs.ExerciseGetListDTO;
import com.openfit.Models.Exercise;

import java.util.List;

@Dao
public interface ExerciseDAO {
    @Query("SELECT e.id, e.name, e.demoURL, e.aka, " +
            "mm.name AS mainMuscle, mm.muscle_group AS mainMuscleGroup, sm.name AS secondaryMuscle, sm.muscle_group AS secondaryMuscleGroup, e.is_custom AS isCustom " +
            "FROM exercise e " +
            "LEFT OUTER JOIN muscle mm ON e.main_muscle_id = mm.id " +
            "LEFT OUTER JOIN muscle sm ON e.secondary_muscle_id = sm.id")
    LiveData<List<ExerciseGetListDTO>> getExerciseList();

    @Query("SELECT COUNT(*) FROM exercise")
    int count();

    @Insert
    void insert(Exercise exercise);
}
