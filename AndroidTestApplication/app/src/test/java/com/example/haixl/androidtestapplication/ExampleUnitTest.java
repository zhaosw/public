package com.example.haixl.androidtestapplication;

import com.example.haixl.androidtestapplication.util.CalculatorTest;
import com.example.haixl.androidtestapplication.util.CalendarTest;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@Suite.SuiteClasses({CalendarTest.class, CalculatorTest.class})
public class ExampleUnitTest {
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    @PrepareForTest
    public void verryfyAdd(){
        List<Integer> list = spy(List.class);
        when(list.get(0)).thenReturn(3);
        assertEquals(3,(int)list.get(0));
        PowerMockito.mockStatic(Calendar.class);

    }

}