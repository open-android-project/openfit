package com.openfit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.openfit.DTOs.ExerciseTypeGetListDTO;
import com.openfit.R;

import java.util.List;

public class ExerciseNewTypeListAdapter extends BaseRecyclerAdapter<ExerciseTypeGetListDTO, ExerciseNewTypeListAdapter.ExerciseNewTypeListViewHolder> {
    public ExerciseNewTypeListAdapter(Context context, List<ExerciseTypeGetListDTO> items) {
        super(context, items);
    }

    @NonNull
    @Override
    public ExerciseNewTypeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseNewTypeListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_exercise_type_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseNewTypeListViewHolder holder, int position) {
        ExerciseTypeGetListDTO t = items.get(position);
        holder.getName().setText(t.name);
        holder.getDescription().setText(t.description);
    }

    public int getTypeByPosition(int position) {
        return items.get(position).id;
    }

    public static class ExerciseNewTypeListViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView description;
        public ExerciseNewTypeListViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.exerciseTypeName);
            description = itemView.findViewById(R.id.exerciseTypeDesc);
        }

        public TextView getName() {
            return name;
        }
        public TextView getDescription() {
            return description;
        }
    }
}
