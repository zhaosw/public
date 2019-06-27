package com.example.haixl.androidtestapplication.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaosw.
 * @date 2019/2/20.
 */
public class Calendar {

    private String calendar = null;

    private Calculator calculator;

    private CalendarHelper calendarHelper = new CalendarHelper();

    public static String getDate(){
        return "Today have fun";
    }

    public String resetDate(){
        return "2019-2-22";
    }

    public Calculator getCalculator(){
        return calculator;
    }

    //    为单元测试提供
    public void setCalendarHelper(CalendarHelper calendarHelper) {
        this.calendarHelper = calendarHelper;
    }

    //    为单元测试提供
    public CalendarHelper getCalendarHelper(){
        return calendarHelper;
    }

    public String flagTody(){
        return "flag:"+calendarHelper.flagToday();
    }

    public String getToday(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String dateStr = dateFormat.format(date);
        System.out.println(dateStr);
        return dateStr;
    }

    public String dateToNum(String date){
        if(null == date){
            throw new NullPointerException();
        }
        return date.replace("","-")
                .replace("",":")
                .replace(""," ");
    }

    public void resetCalendar(){
        resetCalandars();
    }

    public void resetCalandars(){
        this.calendar = "2019-2-20";
    }

}
