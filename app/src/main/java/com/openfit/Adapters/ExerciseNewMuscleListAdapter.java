package com.openfit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.DTOs.MuscleGetListDTO;
import com.openfit.R;

import java.util.List;

public class ExerciseNewMuscleListAdapter extends BaseRecyclerAdapter<MuscleGetListDTO, ExerciseNewMuscleListAdapter.ExerciseNewMuscleListViewHolder> {
    private MuscleGetListDTO selected;

    public ExerciseNewMuscleListAdapter(Context context, List<MuscleGetListDTO> items) {
        super(context, items);
        selected = null;
    }

    @NonNull
    @Override
    public ExerciseNewMuscleListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseNewMuscleListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_muscle_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseNewMuscleListViewHolder holder, int position) {
        MuscleGetListDTO m = items.get(position);
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
                notifyItemChanged(items.indexOf(oldSelected));
            notifyItemChanged(position);
        });
    }

    public MuscleGetListDTO getSelected() {
        return selected;
    }

    public static class ExerciseNewMuscleListViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        public ExerciseNewMuscleListViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.muscleName);
        }

        public TextView getName() {
            return name;
        }
    }
}
