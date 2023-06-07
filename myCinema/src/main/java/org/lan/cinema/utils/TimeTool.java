package org.lan.cinema.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTool {
    public static void main(String[] args) {
        String l = "2022-01-02";
        final String substring = l.substring(5);
        System.out.println(substring);
    }

    public static String getDetailTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getBirthdayQuery(String birthdayType){
        if ("".equals(birthdayType)) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)+Integer.parseInt(birthdayType));
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        return dateFormat.format(calendar.getTime());
    }
}
