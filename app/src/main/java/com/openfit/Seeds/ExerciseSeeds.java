package com.openfit.Seeds;

import static com.openfit.Seeds.MuscleSeeds.*;
import static com.openfit.Seeds.ExerciseTypeSeeds.*;

import com.openfit.Models.Exercise;

public class ExerciseSeeds {
    public static final Exercise[] seeds = {
            new Exercise("exercise_chest_fly", "aka_chest_fly",
                    MID_CHEST, -1, REPS_WEIGHT, "https://www.youtube.com/watch?v=FDay9wFe5uE"),
            new Exercise("exercise_chest_press_machine", "aka_chest_press_machine",
                    MID_CHEST, LOW_CHEST, REPS_WEIGHT , "https://www.youtube.com/watch?v=sqNwDkUU_Ps"),
            new Exercise("exercise_bench_press", "aka_bench_press",
                    MID_CHEST, LOW_CHEST, REPS_WEIGHT),
            new Exercise("exercise_incline_bench_press", "aka_incline_bench_press",
                    UP_CHEST, MID_CHEST, REPS_WEIGHT),
            new Exercise("exercise_barbell_row", "aka_barbell_row",
                    LOW_TRAP, UP_TRAP, REPS_WEIGHT),
            new Exercise("exercise_back_squat", "aka_back_squat",
                    QUAD, GLUTE, REPS_WEIGHT),
            new Exercise("exercise_deadlift", "aka_deadlift",
                    GLUTE, LOW_BACK, REPS_WEIGHT),
            new Exercise("exercise_lat_pulldown", "aka_lat_pulldown",
                    LAT, -1, REPS_WEIGHT)
    };
}
