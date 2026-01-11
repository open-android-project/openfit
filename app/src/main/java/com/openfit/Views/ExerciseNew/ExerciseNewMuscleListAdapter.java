package com.openfit.Views.ExerciseNew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.DTOs.MuscleGetListDTO;
import com.openfit.R;

import java.util.List;

public class ExerciseNewMuscleListAdapter extends RecyclerView.Adapter<ExerciseNewMuscleListViewHolder> {
    private Context context;
    private List<MuscleGetListDTO> muscles;
    private MuscleGetListDTO selected;

    public ExerciseNewMuscleListAdapter(Context context, List<MuscleGetListDTO> muscles) {
        this.context = context;
        this.muscles = muscles;
        selected = null;
    }

    @NonNull
    @Override
    public ExerciseNewMuscleListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseNewMuscleListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_muscle_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseNewMuscleListViewHolder holder, int position) {
        MuscleGetListDTO m = muscles.get(position);
        holder.getName().setText(m.name);

        boolean isSelected = selected != null && selected.equals(m);
        holder.itemView.setBackgroundColor(
                ContextCompat.getColor(
                        context,
                        isSelected ? R.color.accent : android.R.color.transparent
                )
        );
        holder.itemView.setOnClickListener(v -> {
            MuscleGetListDTO oldSelected = selected;
            selected = isSelected ? null : m;

            if (oldSelected != null)
                notifyItemChanged(muscles.indexOf(oldSelected));
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return muscles.size();
    }

    public MuscleGetListDTO getSelected() {
        return selected;
    }
}
