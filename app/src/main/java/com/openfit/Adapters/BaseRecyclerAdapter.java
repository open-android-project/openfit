package com.openfit.Adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerAdapter<I, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {
    protected final Context context;
    protected final List<I> items;

    public BaseRecyclerAdapter(Context context, List<I> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
