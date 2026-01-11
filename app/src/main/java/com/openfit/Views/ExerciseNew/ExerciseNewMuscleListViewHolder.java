package com.openfit.Views.ExerciseNew;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.R;

public class ExerciseNewMuscleListViewHolder extends RecyclerView.ViewHolder {
    private final TextView name;
    public ExerciseNewMuscleListViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.muscleName);
    }

    public TextView getName() {
        return name;
    }
}
