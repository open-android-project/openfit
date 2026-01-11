package com.openfit.Classes;

import androidx.room.PrimaryKey;

public class NonAutoGenerateIdentity {
    @PrimaryKey(autoGenerate = false)
    protected int id;

    public NonAutoGenerateIdentity() {

    }
    public NonAutoGenerateIdentity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }
}
