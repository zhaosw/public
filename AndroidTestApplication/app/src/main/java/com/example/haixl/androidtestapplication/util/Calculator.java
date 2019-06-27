package com.example.haixl.androidtestapplication.util;

import java.util.Random;

/**
 * @author zhaosw.
 * @date 2019/2/20.
 */
public class Calculator {

    public int add(int a, int b){
        return a + b;
    }

    public int getNum(){
        return 1;
    }

    public Calculator(){

    }

    public int dec(int a,int b){
        return decStatic(a,b);
    }

    public static int decStatic(int a,int b){
        return a - b;
    }

    public int addMulti(int ... values){
        return addMultiPrivate(values);
    }

    private int addMultiPrivate(int ...values){
        int result =0;
        for(int t = 0;t<values.length;t++){
            result += values[t];
        }
        return result;
    }

    public int getRendom(){
        return getRendomFinal();
    }

    public final int getRendomFinal(){
        Random random = new Random();
        return random.nextInt();
    }

    public int getTimes(){
        CalculatorHelper calculatorHelper = new CalculatorHelper(100);
        return calculatorHelper.getTimes();
    }

}
