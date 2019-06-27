package com.example.haixl.androidtestapplication.util;

import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author zhaosw.
 * @date 2019/2/20.
 */
@RunWith(Parameterized.class)
public class CalculatorTestParameters {

    private static final String TAG = "CalculatorTest";

    public int input_a;

    public int input_b;

    public int output_a;

    public CalculatorTestParameters(int a, int b, int c){
        input_a = a;
        input_b= b;
        output_a = c;
    }

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{{1, 2, 3},{-1, -2, -3},{1, -1, 0},{0, 1, 1}});
    }

    @Test
    public void testAdd(){
        Calculator calculator = new Calculator();
        int result = calculator.add(input_a, input_b);
        assertEquals(output_a, result);
    }


}
