package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test09
{

    public static void main(String[] args)
    {
        String t1 = "2019-02-01 05:00:00.0";
        int timDiff = -480;
        System.out.println(openeco2JADTime(t1, timDiff));
    }

    private static String openeco2JADTime(String t, Integer timmDiff)
    {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Long time = 0l;
        try
        {
            timmDiff += 480;
            Date date1 = sdf1.parse(t);
            time = date1.getTime();
            time -= timmDiff;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        Date date2 = new Date(time);
        return sdf2.format(date2);
    }
}