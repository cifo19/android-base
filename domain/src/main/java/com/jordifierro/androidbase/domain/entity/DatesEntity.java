package com.jordifierro.androidbase.domain.entity;

/**
 * Created by cafer on 10/16/17.
 */

public class DatesEntity {
    private String minimum;
    private String maximum;

    public DatesEntity() {
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }
}
