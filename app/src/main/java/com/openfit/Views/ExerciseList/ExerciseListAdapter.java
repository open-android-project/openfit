package com.openfit.Views.ExerciseList;

import static android.view.View.GONE;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.DTOs.ExerciseGetListDTO;
import com.openfit.R;

import java.util.List;

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListViewHolder> {
    private Context context;
    private List<ExerciseGetListDTO> exercises;

    public ExerciseListAdapter(Context context, List<ExerciseGetListDTO> exercises) {
        this.context = context;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_exercise_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListViewHolder holder, int position) {
        ExerciseGetListDTO e = exercises.get(position);

        holder.getName().setText(e.name);

        if(e.aka.isEmpty())
            holder.getAKA().setVisibility(GONE);
        else{
            int resId = context.getResources().getIdentifier("aka", "string", context.getPackageName());
            holder.getAKA().setText(context.getResources().getText(resId) + e.aka);
        }

        holder.getMuscles().setText(e.mainMuscle + (e.secondaryMuscle.isEmpty() || e.secondaryMuscle == null ? "" : " & " + e.secondaryMuscle));

        if(e.demoURL.isEmpty()) {
            holder.getDemo().setVisibility(GONE);
        }

        else {
            holder.getDemo().setOnClickListener(d -> {
                Intent openLink = new Intent(Intent.ACTION_VIEW, Uri.parse(e.demoURL));
                context.startActivity(openLink);
            });
        }

        /*
        if(!e.isCustom) {
            //holder.getDelete().setVisibility(GONE);
        }
        else {
            //holder.getDelete().setOnClickListener(d -> {
                // TODO
            //});
        }
         */
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
