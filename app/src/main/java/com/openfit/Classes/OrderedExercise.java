package com.openfit.Classes;

import androidx.room.ColumnInfo;

public class OrderedExercise extends AutoGenerateIdentity {
    @ColumnInfo(name = "exercise_id")
    private int exerciseId;
    @ColumnInfo(name = "order")
    private int order;

    public OrderedExercise() {
        super();
    }
    public OrderedExercise(int exerciseId, int order) {
        this.exerciseId = exerciseId;
        this.order = order;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exercise_id) {
        this.exerciseId = exercise_id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
