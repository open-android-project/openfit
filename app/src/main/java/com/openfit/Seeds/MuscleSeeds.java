package com.openfit.Seeds;

import com.openfit.Models.Exercise;
import com.openfit.Models.Muscle;

public class MuscleSeeds {
    public static final int
            UP_CHEST = 1, MID_CHEST = 2, LOW_CHEST = 3,
            UP_TRAP = 4, LOW_TRAP = 5, LAT = 6,
            R_DELT = 7, F_DELT = 8, S_DELT = 9,
            BI = 10, TRI = 11, FORE = 12,
            ABS = 13, LOW_BACK = 14, OBL = 15,
            QUAD = 16, GLUTE = 17, HAM = 18, CALF = 19, ABD = 20, AD = 21;
    public static final Muscle[] seeds = {
            new Muscle(UP_CHEST, "muscle_upper_chest", "muscle_group_chest"),
            new Muscle(MID_CHEST, "muscle_mid_chest", "muscle_group_chest"),
            new Muscle(LOW_CHEST, "muscle_lower_chest", "muscle_group_chest"),
            new Muscle(UP_TRAP, "muscle_upper_trap", "muscle_group_back"),
            new Muscle(LOW_TRAP, "muscle_lower_trap", "muscle_group_back"),
            new Muscle(LAT, "muscle_lat", "muscle_group_back"),
            new Muscle(R_DELT, "muscle_rear_delt", "muscle_group_shoulders"),
            new Muscle(F_DELT, "muscle_front_delt", "muscle_group_shoulders"),
            new Muscle(S_DELT, "muscle_side_delt", "muscle_group_shoulders"),
            new Muscle(BI, "muscle_bicep", "muscle_group_arms"),
            new Muscle(TRI, "muscle_tricep", "muscle_group_arms"),
            new Muscle(FORE, "muscle_forearm", "muscle_group_arms"),
            new Muscle(ABS, "muscle_abs", "muscle_group_core"),
            new Muscle(LOW_BACK, "muscle_lower_back", "muscle_group_core"),
            new Muscle(OBL, "muscle_oblique", "muscle_group_core"),
            new Muscle(QUAD, "muscle_quad", "muscle_group_legs"),
            new Muscle(GLUTE, "muscle_glute", "muscle_group_legs"),
            new Muscle(HAM, "muscle_hamstring", "muscle_group_legs"),
            new Muscle(CALF, "muscle_calf", "muscle_group_legs"),
            new Muscle(ABD, "muscle_abductor", "muscle_group_legs"),
            new Muscle(AD, "muscle_adductor", "muscle_group_legs")
    };
}
