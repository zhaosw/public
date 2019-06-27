package com.example.haixl.androidtestapplication.util;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author zhaosw.
 * @date 2019/2/20.
 */
@RunWith(AndroidJUnit4.class)
public class CalendarTest {

    private static final String TAG = "CalendarTest";

    @BeforeClass
    public static void testBeforeClass(){
        Log.d(TAG,"testBeforeClass");
    }

    @AfterClass
    public static void testAfterCalss(){
        Log.d(TAG,"testAfterCalss");
    }


    @Spy
    private Calculator calculator;
    @InjectMocks
    private Calendar calendar2;
    @Captor
    private ArgumentCaptor<String> captor;

    @Before
    public void testBefore(){
        Log.d(TAG,"testBefore");
        MockitoAnnotations.initMocks(CalendarTest.this);
    }
    @Test
    public void testResetDate(){
        Calendar clander = mock(Calendar.class);
        when(clander.resetDate()).thenReturn("2019-1-1");
        assertEquals(clander.resetDate(),"2019-1-1");
        Calendar calendar1 = spy(Calendar.class);
        assertEquals(calendar1.resetDate(),"2019-2-22");
        doReturn("2019-1-1").when(calendar1).resetDate();
        assertEquals(calendar1.resetDate(),"2019-1-1");
        doCallRealMethod().when(calendar1).resetDate();
        assertEquals(calendar1.resetDate(),"2019-2-22");
        verify(calendar1,times(3)).resetDate();
        assertThat("test auto mock",1,equalTo(calendar2.getCalculator().getNum()));
        List<String> stringList = mock(List.class);
        stringList.add("a");
        stringList.add("b");
        assertEquals(stringList.get(1),captor.capture());
    }

    @After
    public void testAfter(){
        Log.d(TAG,"testAfter");
    }

    @Test(timeout = 1000)
    public void testGetDate(){
        Log.d(TAG,"testGetDate");
//        fail();
        fail("What's wrong with you?");
    }

    @Test
    public void testSetDate(){
        Log.d(TAG,"testSetDate");
        assertThat("assert Matcher error","zhaosw", CoreMatchers.startsWith("z"));
        assertThat("hengheng",2313,anything());
    }

    @Ignore
    @Test
    public void testIgnoreDate(){
        Log.d(TAG,"testIgnoreDate");
    }
}
