package com.openfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.openfit.Classes.AutoGenerateIdentity;

@Entity
public class Routine extends AutoGenerateIdentity {
    @ColumnInfo(name = "name")
    private String name;

    public Routine() {
        super();
    }

    public Routine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
