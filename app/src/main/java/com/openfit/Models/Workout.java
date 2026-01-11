package com.openfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.openfit.Classes.AutoGenerateIdentity;

@Entity
public class Workout extends AutoGenerateIdentity {
    @ColumnInfo(name = "date")
    private long date;
    @ColumnInfo(name = "time_seconds")
    private int timeSeconds;

    public Workout() {
        super();
    }

    public Workout(long date, int timeSeconds) {
        this.date = date;
        this.timeSeconds = timeSeconds;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public void setTimeSeconds(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
}
