package com.test.vehiclemanagement.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Holiday {
    private static final List<String> HOLIDAYS;

    static {
        HOLIDAYS = new ArrayList<>();
        HOLIDAYS.add("2024-01-06");
        HOLIDAYS.add("2023-01-06");
        HOLIDAYS.add("2022-01-06");
    }

    public static List<String> getHolidays() {
        return HOLIDAYS;
    }
}
