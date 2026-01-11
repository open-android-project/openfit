package com.openfit;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.openfit.DAOs.ExerciseDAO;
import com.openfit.DAOs.ExerciseTypeDAO;
import com.openfit.DAOs.MuscleDAO;
import com.openfit.Models.Exercise;
import com.openfit.Models.ExerciseRoutine;
import com.openfit.Models.ExerciseType;
import com.openfit.Models.Muscle;
import com.openfit.Models.Routine;
import com.openfit.Models.Set;
import com.openfit.Models.Workout;

@Database(entities =
        {
                Exercise.class,
                ExerciseRoutine.class,
                ExerciseType.class,
                Routine.class,
                Set.class,
                Workout.class,
                Muscle.class
        },
        version = 3
        )
public abstract class AppDatabase extends RoomDatabase {
    public abstract MuscleDAO muscleDAO();
    public abstract ExerciseTypeDAO exerciseTypeDAO();
    public abstract ExerciseDAO exerciseDAO();
}
