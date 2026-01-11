package com.openfit.Services;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.openfit.App;
import com.openfit.DAOs.ExerciseTypeDAO;
import com.openfit.DTOs.ExerciseGetListDTO;
import com.openfit.DTOs.ExerciseTypeGetListDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExerciseTypeService extends BaseService {
    private final ExerciseTypeDAO dao;

    public ExerciseTypeService(Context context) {
        super(context);
        dao = App.getDB().exerciseTypeDAO();
    }
    public LiveData<List<ExerciseTypeGetListDTO>> getExerciseTypeList() {
        return Transformations.map(
                dao.getAll(),
                list -> {
                    for(ExerciseTypeGetListDTO e : list) {
                        e.name = getResourceStringDefaultToKey(e.name);
                        e.description = getResourceStringDefaultToKey(e.description);
                    }

                    return list;
                }
        );
    }
}
