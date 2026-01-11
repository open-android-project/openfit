package com.openfit.Views.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.Adapters.ExerciseListAdapter;
import com.openfit.R;
import com.openfit.Services.ExerciseService;
import com.openfit.Services.MuscleService;
import com.openfit.Views.Popups.DropdownPopup;
import com.openfit.Adapters.DropdownAdapter;

public class ExerciseListActivity extends AppCompatActivity {
    private ExerciseService exerciseService;
    private MuscleService muscleService;
    private DropdownAdapter<String> muscleFilterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        exerciseService = new ExerciseService(this);
        muscleService = new MuscleService(this);

        setupSearchbar();
        setupMuscleFilter();
        setupNewExerciseButton();
        displayExerciseList();
    }

    private void displayExerciseList() {
        exerciseService.getExerciseList(nameFilter(), selectedMuscleGroup()).observe(this, list -> {
            RecyclerView exerciseList = findViewById(R.id.exercisesList);
            exerciseList.setLayoutManager(new LinearLayoutManager(this));
            exerciseList.setAdapter(new ExerciseListAdapter(this, list));
        });
    }

    private void setupSearchbar() {
        EditText searchbar = findViewById(R.id.searchbarExercise);
        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) { displayExerciseList(); }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    private void setupMuscleFilter() {
        muscleService.getAllGroups().observe(this, muscles -> {
            ImageButton muscleFilterButton = findViewById(R.id.btnMuscleFilter);
            muscleFilterAdapter = new DropdownAdapter<>(this, muscles);
            DropdownPopup popup = new DropdownPopup(this, muscleFilterButton);

            popup.setAdapter(muscleFilterAdapter);
            popup.setOnItemClickListener((parent, view, position, id) -> {
                muscleFilterAdapter.setSelected((String)parent.getItemAtPosition(position));
                displayExerciseList();
            });
        });
    }

    private void setupNewExerciseButton() {
        findViewById(R.id.btnNewExercise).setOnClickListener(v -> {
            Intent in = new Intent(this, ExerciseNewActivity.class);
            startActivity(in);
        });
    }

    private String nameFilter() {
        return ((EditText)findViewById(R.id.searchbarExercise)).getText().toString();
    }

    private String selectedMuscleGroup() {
        return muscleFilterAdapter == null ? null : muscleFilterAdapter.getSelected();
    }
}