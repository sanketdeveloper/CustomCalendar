package com.sanketindia.customcalendar;


import java.util.ArrayList;
import java.util.Calendar;


public class Utils {
    public static ArrayList<ModelDay> getDays(int month, int year) {
        ArrayList<ModelDay> temp = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.YEAR, year);
        int dayinweek = c.get(Calendar.DAY_OF_WEEK);
        for (int i = 1; i < dayinweek; i++) {
            temp.add(new ModelDay("", month - 1, year));
        }
        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInMonth; i++) {
            temp.add(new ModelDay(String.valueOf(i), month - 1, year));
        }
        return temp;
    }


}
