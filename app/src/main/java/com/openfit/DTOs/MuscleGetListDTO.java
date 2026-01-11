package com.openfit.DTOs;

public class MuscleGetListDTO {
    public String name;
    public int id;
    public MuscleGetListDTO() {

    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (
                o != this ||
                !(o instanceof MuscleGetListDTO) ||
                ((MuscleGetListDTO) o).id != this.id
        )
            return false;

        return true;
    }
}
