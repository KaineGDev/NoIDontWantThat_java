package com.example.noidontwantthat_java.gui;

import javax.swing.text.DateFormatter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DateLabelFormatter extends DateFormatter {

    private String datePattern = "yyyy-mm-dd";
    private SimpleDateFormat dateFormatter;

    public DateLabelFormatter() {
        dateFormatter = new SimpleDateFormat(datePattern);
        super.setFormat(dateFormatter);
    }

    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    @Override
    public String valueToString(Object value) throws  ParseException {
        if (value instanceof Date) {
            return dateFormatter.format(value);
        } else if (value instanceof GregorianCalendar) {
            return dateFormatter.format(((GregorianCalendar) value).getTime());
        }
        return "";
    }
}
