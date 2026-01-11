package com.openfit.Seeds;

import com.openfit.Models.ExerciseType;

public class ExerciseTypeSeeds {
    public static final int REPS_WEIGHT = 1;
    public static final int REPS_BODYWEIGHT = 2;
    public static final int TIME_WEIGHT = 3;
    public static final int TIME_BODYWEIGHT = 4;
    public static final ExerciseType[] seeds = {
            new ExerciseType(REPS_WEIGHT, "exercise_type_repsweight", "exercise_type_description_repsweight"),
            new ExerciseType(REPS_BODYWEIGHT, "exercise_type_repsbodyweight", "exercise_type_description_repsbodyweight"),
            new ExerciseType(TIME_WEIGHT, "exercise_type_timeweight", "exercise_type_description_timeweight"),
            new ExerciseType(TIME_BODYWEIGHT, "exercise_type_timebodyweight", "exercise_type_description_timebodyweight")
    };
}
