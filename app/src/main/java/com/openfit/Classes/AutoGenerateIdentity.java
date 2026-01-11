package com.openfit.Classes;

import androidx.room.PrimaryKey;

public class AutoGenerateIdentity {
    @PrimaryKey(autoGenerate = true)
    protected int id;

    public AutoGenerateIdentity() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }
}
