package com.example.haixl.androidtestapplication.util;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * @author zhaosw.
 * @date 2019/2/21.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalendarTest {

    @Test
    public void flagToday(){
        Calendar calendar = new Calendar();
        CalendarHelper calendarHelper = mock(CalendarHelper.class);
        calendar.setCalendarHelper(calendarHelper);
        when(calendarHelper.flagToday()).thenReturn("20");
        String flagDay = calendar.flagTody();
        assertNotNull(flagDay);
        assertThat(flagDay,CoreMatchers.startsWith("flag"));
        assertThat(flagDay,CoreMatchers.endsWith("20"));
    }

    @Test
    public void getToday() {
        Calendar calendar = new Calendar();
        String today = calendar.getToday();
        assertNotNull(today);
        assertThat(today,CoreMatchers.startsWith("2019"));
        assertTrue("the method today format error:"+today,
                today.length() == 20);
    }

    @Test(expected = NullPointerException.class)
    public void testDateToNum(){
        Calendar calendar = new Calendar();
        calendar.dateToNum(null);
    }

    @Test
    public void testResetCalendar() {
        Calendar calendar = spy(Calendar.class);
        calendar.resetCalendar();
        verify(calendar,times(1)).resetCalandars();
    }

    @Test
    public void getCalculator() {
    }
}