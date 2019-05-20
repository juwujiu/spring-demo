package demo;

import java.text.SimpleDateFormat;

public class Test10
{
    private static final SimpleDateFormat SD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception
    {
        String str = "2019-03-29 10:16:44";
        long time = SD.parse(str).getTime();
        System.out.println(time);
    }
}
