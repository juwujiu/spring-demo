package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test13
{
    private static final SimpleDateFormat SD = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static long HOUR8 = 28800000l;

    public static void main(String args[]) throws Exception
    {
        String str = "";
        FileReader reader1 = new FileReader("d:/time1.txt");
        BufferedReader bReader1 = new BufferedReader(reader1);
        List<String> list1 = new ArrayList<>();
        while ((str = bReader1.readLine()) != null)
        {
            list1.add(str);
        }
        List<String> list2 = new ArrayList<>();
        for (String time1 : list1)
        {
            long time = SD.parse(time1).getTime() + HOUR8;
            Date date2 = new Date(time);
            String time2 = SD.format(date2);
            // list2.add(time2);
            System.out.println(time2);
        }
    }
}
