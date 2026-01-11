package com.openfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.openfit.Classes.AutoGenerateIdentity;

@Entity
public class Exercise extends AutoGenerateIdentity {
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "demoURL")
    private String demoURL;
    @ColumnInfo(name = "aka")
    private String aka;
    @ColumnInfo(name = "type_id")
    private int typeId;
    @ColumnInfo(name = "main_muscle_id")
    private int mainMuscleId;
    @ColumnInfo(name = "secondary_muscle_id")
    private int secondaryMuscleId;
    @ColumnInfo(name = "is_custom")
    private boolean isCustom;

    public Exercise() {
        super();
    }

    public Exercise(String name, String aka, int mainMuscleId, int secondaryMuscleId, int typeId) {
        this.name = name;
        this.demoURL = "";
        this.aka = aka;
        this.mainMuscleId = mainMuscleId;
        this.secondaryMuscleId = secondaryMuscleId;
        this.typeId = typeId;
        this.isCustom = false;
    }

    public Exercise(String name, String aka, int mainMuscleId, int secondaryMuscleId, int typeId, String demoURL) {
        this(name, aka, mainMuscleId, secondaryMuscleId, typeId);
        this.demoURL = demoURL;
    }

    public Exercise(String name, String aka, int mainMuscleId, int secondaryMuscleId, int typeId, String demoURL, boolean isCustom) {
        this(name, aka, mainMuscleId, secondaryMuscleId, typeId, demoURL);
        this.isCustom = isCustom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDemoURL() {
        return demoURL;
    }

    public void setDemoURL(String demoURL) {
        this.demoURL = demoURL;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int type_id) {
        this.typeId = type_id;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
    }

    public String getAka() {
        return aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    public int getMainMuscleId() {
        return mainMuscleId;
    }

    public void setMainMuscleId(int mainMuscleId) {
        this.mainMuscleId = mainMuscleId;
    }

    public int getSecondaryMuscleId() {
        return secondaryMuscleId;
    }

    public void setSecondaryMuscleId(int secondaryMuscleId) {
        this.secondaryMuscleId = secondaryMuscleId;
    }
}
