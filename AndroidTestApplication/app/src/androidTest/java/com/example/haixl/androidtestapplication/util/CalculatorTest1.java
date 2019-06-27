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
public class CalculatorTest1 {

    private static final String TAG = "CalculatorTest";

    public int input_a;

    public int input_b;

    public int output_a;

    public CalculatorTest1(int a,int b,int c){
        input_a = a;
        input_b= b;
        output_a = c;
    }

    @Test
    public void testAdd(){
        Log.d(TAG,"testAdd");
        Calculator calculator = new Calculator();
        int result = calculator.add(input_a, input_b);
        Log.d(TAG,"testAdd:"+result);
        assertEquals(output_a, result);
    }


//
//    static class TestParameters{
//
//        //    @Parameterized.Parameter
//        public static int input_a;
//        //    @Parameterized.Parameter(1)
//        public static int input_b;
//        //    @Parameterized.Parameter(2)
//        public static int output_a;
//
//        public TestParameters(int a,int b,int c){
//            input_a = a;
//            input_b= b;
//            output_a = c;
//        }
//
//    }

    @Parameterized.Parameters
    public static Collection data(){
//        return Arrays.asList(new Object(1, 2, 3),
//                new TestParameters(-1, -2, -3),
//                new TestParameters(1, -1, 0),
//                new TestParameters(0, 1, 1));
        return Arrays.asList(new Object[][]{{1, 2, 3},{-1, -2, -3},{1, -1, 0},{0, 1, 1}});
//        List<int[][][]> list = new ArrayList<>();
//        list.add(new int[][][]{{{1, 2, 3},{-1, -2, -3},{1, -1, 0},{0, 1, 1}}});
////        list.add(new int[][][]{1, 2, 3});
////        list.add(new int[]{-1, -2, -3});
////        list.add(new int[]{1, -1, 0});
////        list.add(new int[]{0, 1, 1});
//        return list;
    }

}
