package com.openfit.Views.ExerciseNew;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.DTOs.MuscleGetListDTO;
import com.openfit.Models.Exercise;
import com.openfit.R;
import com.openfit.Seeds.ExerciseTypeSeeds;
import com.openfit.Seeds.MuscleSeeds;
import com.openfit.Services.ExerciseService;
import com.openfit.Services.MuscleService;
import com.openfit.Views.Dropdown.DropdownAdapter;
import com.openfit.Views.Dropdown.DropdownPopup;
import com.openfit.Views.ExerciseList.ExerciseListAdapter;

public class ExerciseNewActivity extends AppCompatActivity {
    private ExerciseService exerciseService;
    private MuscleService muscleService;
    private ExerciseNewMuscleListAdapter mainMuscleAdapter, secondaryMuscleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        exerciseService = new ExerciseService(this);
        muscleService = new MuscleService(this);

        setupCancelButton();
        setupAddButton();
        setupMuscleDropdowns();
    }

    private void setupCancelButton() {
        Button btn = findViewById(R.id.btnCancelNewExercise);

        btn.setOnClickListener(v -> {
            finish();
        });
    }

    private void setupAddButton() {
        Button btn = findViewById(R.id.btnAddExercise);

        btn.setOnClickListener(v -> {
            if(!addExercise()) return;
            finish();
        });
    }

    private void setupMuscleDropdowns() {
        muscleService.getAll().observe(this, muscles -> {
            // MAIN MUSCLE

            RecyclerView mainMuscleList = findViewById(R.id.exerciseNewMainMuscleList);
            mainMuscleAdapter = new ExerciseNewMuscleListAdapter(this, muscles);
            mainMuscleList.setLayoutManager(new LinearLayoutManager(this));
            mainMuscleList.setAdapter(mainMuscleAdapter);

            // SECONDARY MUSCLE

            RecyclerView secondaryMuscleList = findViewById(R.id.exerciseNewSecondaryMuscleList);
            secondaryMuscleAdapter = new ExerciseNewMuscleListAdapter(this, muscles);
            secondaryMuscleList.setLayoutManager(new LinearLayoutManager(this));
            secondaryMuscleList.setAdapter(secondaryMuscleAdapter);

        });
    }

    private boolean addExercise() {
        String exerciseName = ((EditText)findViewById(R.id.exerciseNewName)).getText().toString();
        int mainMuscleId = selectedMainMuscle(), secondaryMuscleId = selectedSecondaryMuscle();

        if(!isExerciseValid(exerciseName, mainMuscleId, secondaryMuscleId)) return false;

        String exerciseAka = ((EditText)findViewById(R.id.exerciseNewAka)).getText().toString();
        String exerciseDemoUrl =  ((EditText)findViewById(R.id.exerciseNewDemoUrl)).getText().toString();

        Exercise exercise = new Exercise
                (
                        exerciseName,
                        exerciseAka,
                        mainMuscleId,
                        secondaryMuscleId,
                        ExerciseTypeSeeds.REPS_WEIGHT, //TODO
                        exerciseDemoUrl,
                        true
                );

        exerciseService.insertExercise(exercise);

        return true;
    }

    private boolean isExerciseValid(String name, int mainMuscleId, int secondaryMuscleId) {
        boolean isValid = true;

        // TODO: CREATE POPUP WITH ERROR MESSAGE INSTEAD OF TOAST

        if(name == null || name.isEmpty()) {
            Toast t = Toast.makeText(getApplicationContext(), "Name cant be empty", LENGTH_SHORT);
            t.show();
            isValid = false;
        }

        if(mainMuscleId == -1) {
            Toast t = Toast.makeText(getApplicationContext(), "Main muscle cant be empty", LENGTH_SHORT);
            t.show();
            isValid = false;
        }

        if(mainMuscleId == secondaryMuscleId) {
            Toast t = Toast.makeText(getApplicationContext(), "Main muscle and secondary mustnt be equal", LENGTH_SHORT);
            t.show();
            isValid = false;
        }

        return isValid;
    }

    private int selectedMainMuscle() {
        if(mainMuscleAdapter == null || mainMuscleAdapter.getSelected() == null) return -1;
        return mainMuscleAdapter.getSelected().id;
    }

    private int selectedSecondaryMuscle() {
        if(secondaryMuscleAdapter == null || secondaryMuscleAdapter.getSelected() == null) return -1;
        return secondaryMuscleAdapter.getSelected().id;
    }
}