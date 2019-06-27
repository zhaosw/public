package com.example.haixl.androidtestapplication.util;

/**
 * @author zhaosw.
 * @date 2019/3/1.
 */
public class CalculatorHelper {

    private int times = 0;

    public CalculatorHelper(int defaultTimes){
        this.times = defaultTimes;
    }

    public int getTimes(){
        return times;
    }

}
