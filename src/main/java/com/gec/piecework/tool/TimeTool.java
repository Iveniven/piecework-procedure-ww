package com.gec.piecework.tool;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author iven
 * @version 2021.2.3
 * @date 2023/2/25 23:47
 */
public class TimeTool {

    public static Date TimeReturn(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        Date time = null;
        try {
            time = simpleDateFormat.parse(simpleDateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
