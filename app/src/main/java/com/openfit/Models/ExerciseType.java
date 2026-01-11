package com.openfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.openfit.Classes.NonAutoGenerateIdentity;

@Entity
public class ExerciseType extends NonAutoGenerateIdentity {
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "description")
    private String description;

    public ExerciseType() {
        super();
    }

    public ExerciseType(int id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
