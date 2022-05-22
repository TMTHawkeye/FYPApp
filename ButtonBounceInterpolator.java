package com.example.fyp_prototypefinal;

import android.view.animation.Interpolator;

public class ButtonBounceInterpolator implements Interpolator {
    private double amplitude=1;
    private double frquence=10;

    ButtonBounceInterpolator(double myamplitude, double frequency)
    {
        this.amplitude=myamplitude;
        this.frquence=frequency;
    }

    @Override
    public float getInterpolation(float time) {
        return (float)(-1*Math.pow(Math.E,-time/amplitude)*Math.cos(frquence*time)+1);
    }
}
