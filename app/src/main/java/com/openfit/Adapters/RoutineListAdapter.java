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
import com.openfit.DTOs.RoutineGetListDTO;
import com.openfit.R;

import java.util.List;

public class RoutineListAdapter extends BaseRecyclerAdapter<RoutineGetListDTO, RoutineListAdapter.RoutineListViewHolder> {
    public RoutineListAdapter(Context context, List<RoutineGetListDTO> items) {
        super(context, items);
    }

    @NonNull
    @Override
    public RoutineListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RoutineListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_routine_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RoutineListViewHolder holder, int position) {
        RoutineGetListDTO e = items.get(position);
        holder.getName().setText(e.name);
    }

    public static class RoutineListViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        public RoutineListViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.routineName);
        }

        public TextView getName() {
            return name;
        }
    }
}
