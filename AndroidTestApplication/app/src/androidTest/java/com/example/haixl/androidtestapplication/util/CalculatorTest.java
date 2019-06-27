package com.example.haixl.androidtestapplication.util;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author zhaosw.
 * @date 2019/2/20.
 */
public class CalculatorTest {

    private static final String TAG = "CalculatorTest";

    private Calculator calculator = null;

    @Before
    public void testInit(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        Log.d(TAG,"testAdd");
        assertEquals(calculator.add(1,1),2);
        assertThat("",calculator.add(2,3), equalTo(5));
        HashMap<String,Calendar> map = new HashMap<>();
        map.values().toArray(new Calculator[0]);
    }

}
