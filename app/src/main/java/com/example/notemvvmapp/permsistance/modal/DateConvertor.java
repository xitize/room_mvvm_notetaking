package com.example.notemvvmapp.permsistance.modal;

import android.text.format.DateFormat;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;

public class DateConvertor {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }


    public static String getDayMonth(Date date) {
        String day = (String) DateFormat.format("dd", date);
        String month = (String) DateFormat.format("MMM", date);
        return day + month;
    }

}



/*Room Database
 * 1. Entity
 * 2. DAO - Data Access Objects
 * 3. Create Database
 * 4. Repository
 * 5. ViewModal*/