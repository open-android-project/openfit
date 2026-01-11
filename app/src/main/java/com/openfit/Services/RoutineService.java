package com.openfit.Services;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.openfit.App;
import com.openfit.DAOs.RoutineDAO;
import com.openfit.DTOs.RoutineGetListDTO;

import java.util.List;

public class RoutineService extends BaseService {
    private final RoutineDAO dao;

    public RoutineService(Context context) {
        super(context);
        dao = App.getDB().routineDAO();
    }
    public LiveData<List<RoutineGetListDTO>> getRoutinesList() {
        return dao.getRoutineList();
    }

    public LiveData<Integer> getCount() {
        return dao.count();
    }
}
