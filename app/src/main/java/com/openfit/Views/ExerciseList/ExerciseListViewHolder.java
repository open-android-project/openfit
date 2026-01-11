package com.openfit.Views.ExerciseList;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.R;

public class ExerciseListViewHolder extends RecyclerView.ViewHolder {
    private final TextView name, aka, muscles;
    private final Button demo;
    public ExerciseListViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.exerciseName);
        aka = itemView.findViewById(R.id.exerciseAka);
        muscles = itemView.findViewById(R.id.exerciseMuscles);
        demo = itemView.findViewById(R.id.btnDemo);
    }

    public TextView getName() {
        return name;
    }

    public TextView getAKA() {
        return aka;
    }

    public TextView getMuscles() {
        return muscles;
    }

    public Button getDemo() {
        return demo;
    }
}
