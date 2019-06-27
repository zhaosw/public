package com.example.haixl.androidtestapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.haixl.androidtestapplication.util.CalculatorTest;
import com.example.haixl.androidtestapplication.util.CalendarTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalendarTest.class,CalculatorTest.class})
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.haixl.androidtestapplication", appContext.getPackageName());
    }
}
