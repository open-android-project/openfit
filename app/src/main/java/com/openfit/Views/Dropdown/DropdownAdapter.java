package com.openfit.Views.Dropdown;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.openfit.R;

import java.util.List;

public class DropdownAdapter<T> extends ArrayAdapter<T> {
    private T selected;

    public DropdownAdapter(
            @NonNull Context context,
            @NonNull List<T> items
    ) {
        super(context, R.layout.dropdown_item, items);
        selected = null;
    }

    public void setSelected(@Nullable T selected) {
        this.selected = selected.equals(this.selected) ? null : selected;
        notifyDataSetChanged();
    }

    public T getSelected() {
        return selected;
    }

    @NonNull
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    private View createView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) (convertView != null
                ? convertView
                : LayoutInflater.from(getContext())
                .inflate(R.layout.dropdown_item, parent, false));

        T item = getItem(position);
        view.setText(item instanceof String ? (String)item : item.toString());
        view.setBackgroundColor(ContextCompat.getColor(
                getContext(),
                item != null && item.equals(selected) ?
                R.color.accent : R.color.light_background_1)
        );

        return view;
    }
}
