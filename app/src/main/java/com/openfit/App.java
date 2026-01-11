package com.openfit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.openfit.DAOs.ExerciseDAO;
import com.openfit.DAOs.ExerciseTypeDAO;
import com.openfit.DAOs.MuscleDAO;
import com.openfit.Models.Exercise;
import com.openfit.Models.ExerciseType;
import com.openfit.Models.Muscle;
import com.openfit.Seeds.ExerciseSeeds;
import com.openfit.Seeds.ExerciseTypeSeeds;
import com.openfit.Seeds.MuscleSeeds;

import java.util.concurrent.Executors;

public class App extends Application {
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "openfitDB"
        ).fallbackToDestructiveMigration().build();

        Executors.newSingleThreadExecutor().execute(this::seedDB);
    }

    public static AppDatabase getDB(){
        return database;
    }

    private void seedDB() {
        if(database.muscleDAO().count() == 0)
            seedMuscles();
        if(database.exerciseTypeDAO().count() == 0)
            seedExerciseTypes();
        if(database.exerciseDAO().count() == 0)
            seedExercises();
    }

    private void seedMuscles() {
        MuscleDAO dao = database.muscleDAO();

        for (Muscle m : MuscleSeeds.seeds) {
            dao.insert(m);
        }
    }

    private void seedExerciseTypes() {
        ExerciseTypeDAO dao = database.exerciseTypeDAO();

        for (ExerciseType et : ExerciseTypeSeeds.seeds) {
            dao.insert(et);
        }
    }

    private void seedExercises() {
        ExerciseDAO dao = database.exerciseDAO();

        for (Exercise e: ExerciseSeeds.seeds) {
            dao.insert(e);
        }
    }
}
