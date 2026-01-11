package com.openfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.openfit.Classes.OrderedExercise;

@Entity
public class ExerciseRoutine extends OrderedExercise {
    @ColumnInfo(name = "routine_id")
    private int routineId;

    public ExerciseRoutine() {
        super();
    }
    public ExerciseRoutine(int exerciseId, int routineId, int order) {
        super(exerciseId, order);
        this.routineId = routineId;
    }

    public int getRoutineId() {
        return routineId;
    }

    public void setRoutineId(int routine_id) {
        this.routineId = routine_id;
    }
}
