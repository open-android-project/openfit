package com.openfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.openfit.Classes.OrderedExercise;

@Entity
public class Set extends OrderedExercise {
    @ColumnInfo(name = "workout_id")
    private int workoutId;
    @ColumnInfo(name = "weight")
    private float weight;
    @ColumnInfo(name = "time_seconds")
    private int timeSeconds;
    @ColumnInfo(name = "reps")
    private int reps;

    public Set(){
        super();
    }

    public Set(int exercise_id, int workoutId, float weight, int timeSeconds, int reps, int order) {
        super(exercise_id, order);
        this.workoutId = workoutId;
        this.weight = weight;
        this.timeSeconds = timeSeconds;
        this.reps = reps;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if(weight < 0.0) throw new IllegalArgumentException("Weight can't be negative");
        this.weight = weight;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public void setTimeSeconds(int timeSeconds) {
        if(timeSeconds < 0) throw new IllegalArgumentException("Time can't be negative");
        this.timeSeconds = timeSeconds;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        if(reps < 0) throw new IllegalArgumentException("Reps can't be negative");
        this.reps = reps;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workout_id) {
        this.workoutId = workout_id;
    }
}
