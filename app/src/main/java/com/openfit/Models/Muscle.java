package com.openfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.openfit.Classes.AutoGenerateIdentity;
import com.openfit.Classes.NonAutoGenerateIdentity;

@Entity
public class Muscle extends NonAutoGenerateIdentity {
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "muscle_group")
    private String muscleGroup;

    public Muscle() {
        super();
    }

    public Muscle(int id, String name, String muscleGroup) {
        super(id);
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
}
