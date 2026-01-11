package com.openfit.Views.Dropdown;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ListAdapter;

import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.content.ContextCompat;

import com.openfit.R;

public class DropdownPopup extends ListPopupWindow {
    public DropdownPopup(Context context, View trigger) {
        super(context);
        this.setModal(true);
        this.setWidth(350);
        this.setDropDownGravity(Gravity.END);
        this.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.box));

        this.setAnchorView(trigger);
        trigger.setOnClickListener(v -> show());
    }

    public DropdownPopup(Context context, View trigger, int gravity, int width) {
        this(context, trigger);
        this.setWidth(width);
        this.setDropDownGravity(gravity);
    }
}
