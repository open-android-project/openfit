package com.openfit.Services;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.openfit.App;
import com.openfit.DAOs.ExerciseDAO;
import com.openfit.DTOs.ExerciseGetListDTO;
import com.openfit.Helpers.StringHelper;
import com.openfit.Models.Exercise;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseService extends BaseService {
    private final ExerciseDAO dao;

    public ExerciseService(Context context) {
        super(context);
        dao = App.getDB().exerciseDAO();
    }
    public LiveData<List<ExerciseGetListDTO>> getExerciseList(String nameFilter, String muscleGroupFilter) {
        return Transformations.map(
                dao.getExerciseList(),
                list -> {
                    ArrayList<ExerciseGetListDTO> filtered = new ArrayList<>(list);
                    for(ExerciseGetListDTO e : list) {
                        if(!e.isCustom) {
                            e.name = getResourceStringDefaultToKey(e.name);
                            e.aka = getResourceStringDefaultToKey(e.aka);
                        }
                        e.mainMuscle = getResourceStringDefaultToKey(e.mainMuscle);
                        e.mainMuscleGroup = getResourceStringDefaultToKey(e.mainMuscleGroup);
                        e.secondaryMuscle = getResourceStringDefaultToKey(e.secondaryMuscle);
                        e.secondaryMuscleGroup = getResourceStringDefaultToKey(e.secondaryMuscleGroup);
                        if(!e.demoURL.startsWith("http://") && !e.demoURL.startsWith("https://") && !e.demoURL.isEmpty())
                            e.demoURL = "http://" + e.demoURL;

                        if(nameFilter != null && !nameFilter.isEmpty() && !isExerciseInNameFilter(e.name, e.aka, nameFilter))
                            filtered.remove(e);
                        if(muscleGroupFilter != null && !muscleGroupFilter.isEmpty() && !isExerciseInMuscleFilter(e.mainMuscleGroup, e.secondaryMuscleGroup, muscleGroupFilter))
                            filtered.remove(e);
                    }

                    Collections.sort(filtered, (a, b) ->
                            a.name.compareToIgnoreCase(b.name)
                    );
                    return filtered;
                }
        );
    }

    public void insertExercise(Exercise exercise) {
        AsyncTask.execute(() -> dao.insert(exercise));
    }

    private boolean isExerciseInNameFilter(String exerciseName, String exerciseAKA, String nameFilter) {
        String[] filterWords = nameFilter.split(" ");
        int numWords = filterWords.length, numWordsInName = 0, numWordsInAKA = 0;

        for (String word : filterWords) {
            if(StringHelper.stringContains(exerciseName, word))
                numWordsInName++;

            if(StringHelper.stringContains(exerciseAKA, word))
                numWordsInAKA++;
        }

        return numWordsInName == numWords || numWordsInAKA == numWords;
    }

    private boolean isExerciseInMuscleFilter(String mainMuscleGroup, String secondaryMuscleGroup, String muscleGroupFilter) {
        return mainMuscleGroup.equals(muscleGroupFilter) || secondaryMuscleGroup.equals(muscleGroupFilter);
    }
}
