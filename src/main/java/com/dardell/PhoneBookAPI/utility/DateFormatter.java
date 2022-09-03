package com.dardell.PhoneBookAPI.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {
    public static String getFormattedDate(){
        String pattern = "dd.MM.yyyy 'в' HH:mm:ss z";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("ru", "RU"));
        String date = simpleDateFormat.format(new Date());
        return date;
    }
}
