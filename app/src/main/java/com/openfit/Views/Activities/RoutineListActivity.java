package com.openfit.Views.Activities;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.Adapters.RoutineListAdapter;
import com.openfit.R;
import com.openfit.Services.RoutineService;

public class RoutineListActivity extends AppCompatActivity {

    private RoutineService routineService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_routine_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        routineService = new RoutineService(this);

        setupNewRoutineButton();

        routineService.getCount().observe(this, count ->  {
            if(count == 0) {
                findViewById(R.id.routinesList).setVisibility(GONE);
                findViewById(R.id.searchbarRoutine).setVisibility(GONE);
                findViewById(R.id.noRoutinesInfoText).setVisibility(VISIBLE);
            }
            else {
                displayRoutineList();
            }
        });
    }

    private void displayRoutineList() {
        routineService.getRoutinesList().observe(this, list -> {
            RecyclerView routineList = findViewById(R.id.routinesList);
            routineList.setLayoutManager(new LinearLayoutManager(this));
            routineList.setAdapter(new RoutineListAdapter(this, list));
        });
    }

    private void setupNewRoutineButton() {
        findViewById(R.id.btnNewRoutine).setOnClickListener(v -> {
            Intent in = new Intent(this, RoutineNewActivity.class);
            startActivity(in);
        });
    }
}