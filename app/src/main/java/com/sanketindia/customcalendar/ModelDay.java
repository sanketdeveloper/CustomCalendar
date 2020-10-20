package com.sanketindia.customcalendar;

public class ModelDay {
    public boolean isFullDay() {
        return isFullDay;
    }

    public void setFullDay(boolean fullDay) {
        isFullDay = fullDay;
    }

    public boolean isFullDay=false;
    public boolean isHalfDay() {
        return isHalfDay;
    }

    public void setHalfDay(boolean halfDay) {
        isHalfDay = halfDay;
    }

    boolean isHalfDay = false;
    public int getColor() {
        return Color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    String year,month;
    public void setColor(int color) {
        Color = color;
    }

    int Color = R.color.leave;
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    boolean isSelected = false;
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    String day ="";
    public ModelDay(String day, int month, int year) {
        this.day = day;
        this.month = String.valueOf(month);
        this.year = String.valueOf(year);
    }

    public String getDateString(){
        return String.format("%s-%2s-%2s", year, getTwoDigitNumber(Integer.parseInt(month)+1), getTwoDigitNumber(day));
    }

    private String getTwoDigitNumber(int i) {

        try {
            return String.format("%02d", i);
        }catch (Exception e){

            e.printStackTrace();
            return "";
        }
    }

    private String getTwoDigitNumber(String number) {
        try {
            int i = Integer.parseInt(number);
            return String.format("%02d", i);
        }catch (Exception e){

            e.printStackTrace();
            return "";
        }

    }

}
