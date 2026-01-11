package com.openfit.Services;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.openfit.App;
import com.openfit.DAOs.MuscleDAO;
import com.openfit.DTOs.ExerciseGetListDTO;
import com.openfit.DTOs.MuscleGetListDTO;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MuscleService extends BaseService {
    private final MuscleDAO dao;

    public MuscleService(Context context) {
        super(context);
        dao = App.getDB().muscleDAO();
    }
    public LiveData<List<MuscleGetListDTO>> getAll() {
        return Transformations.map(
                dao.getAll(),
                list -> {
                    for(MuscleGetListDTO m : list) {
                        m.name = getResourceStringDefaultToKey(m.name);
                    }
                    Collections.sort(list, (a, b) ->
                            a.name.compareToIgnoreCase(b.name)
                    );
                    return list;
                }
        );
    }

    public LiveData<List<String>> getAllGroups() {
        return Transformations.map(
                dao.getAllGroups(),
                list -> {
                    List<String> resolved = new ArrayList<>(list.size());

                    for (String g : list)
                        resolved.add(getResourceStringDefaultToKey(g));

                    Collections.sort(resolved, String::compareToIgnoreCase);
                    return resolved;
                }
        );
    }
}
