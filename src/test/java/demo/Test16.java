package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test16
{
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd");

    private static final Map<String, String> DATE_MAP = new HashMap<String, String>()
    {
        {
            put("MM/dd/yyyy", "\\d{2}/\\d{2}/\\d{4}");
        }
    };

    public static void main(String[] args)
    {
        String str1 = "2018/12/26 周三  16:40:44.19";
        String str2 = "12/26/2018 周三  16:40:44.19";
        String str3 = "12/26/2018 周三 16:40:44.19;12/26/2018 周三 16:40:46.29;success";
        str3 = dateFormat(str3);
        System.out.println(str3);
    }

    private static String dateFormat(String str)
    {
        for (String key : DATE_MAP.keySet())
        {
            String sourceFormat = key;
            String matchStr = DATE_MAP.get(key);
            str = dateFormat(str, sourceFormat, matchStr);
        }
        return str;
    }

    private static String dateFormat(String str, String sourceFormat, String matchStr)
    {
        Pattern p = Pattern.compile(matchStr);
        Matcher m = p.matcher(str);
        if (m.find())
        {
            String dateStr1 = m.group(0);
            SimpleDateFormat sdf2 = new SimpleDateFormat(sourceFormat);
            try
            {
                Date date = sdf2.parse(dateStr1);
                String dateStr2 = SDF.format(date);
                str = str.replaceAll(dateStr1, dateStr2);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        return str;
    }
}
