package com.openfit.Adapters;

import static android.view.View.GONE;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.DTOs.ExerciseGetListDTO;
import com.openfit.R;

import java.util.List;

public class ExerciseListAdapter extends BaseRecyclerAdapter<ExerciseGetListDTO, ExerciseListAdapter.ExerciseListViewHolder> {
    public ExerciseListAdapter(Context context, List<ExerciseGetListDTO> items) {
        super(context, items);
    }

    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_exercise_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListViewHolder holder, int position) {
        ExerciseGetListDTO e = items.get(position);

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

    public static class ExerciseListViewHolder extends RecyclerView.ViewHolder {
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
}
