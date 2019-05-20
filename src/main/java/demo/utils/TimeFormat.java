
package demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 wWX459444
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2017年6月20日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
@SuppressWarnings("all")
public class TimeFormat
{
    private static final Logger LOGGER = Logger.getLogger(TimeFormat.class);

    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_16 = 16;

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param map
     */
    // public static void transferTimeStampToLong(Map map)
    // {
    // if (null != map.get("createdOn"))
    // {
    // map = reversalWithUTC(map, "createdOn", "yyyy-MM-dd HH:mm:ss");
    // }
    // if (null != map.get("updatedOn"))
    // {
    // map = reversalWithUTC(map, "updatedOn", "yyyy-MM-dd HH:mm:ss");
    // }
    // if (null != map.get("dueDate"))
    // {
    // map = reversalWithUTC(map, "dueDate", "yyyy-MM-dd");
    // }
    //
    // if (null != map.get("planningReleaseDate"))
    // {
    // map = reversalWithUTC(map, "planningReleaseDate", "yyyy-MM-dd");
    // }
    //
    // if (null != map.get("actualDevelopCompletionDate"))
    // {
    // map = reversalWithUTC(map, "actualDevelopCompletionDate", "yyyy-MM-dd
    // HH:mm:ss");
    // }
    //
    // if (null != map.get("actualReleaseDate"))
    // {
    // map = reversalWithUTC(map, "actualReleaseDate", "yyyy-MM-dd");
    // }
    //
    // if (null != map.get("planningDevelopCompletionDate"))
    // {
    // map = reversalWithUTC(map, "planningDevelopCompletionDate", "yyyy-MM-dd
    // HH:mm:ss");
    // }
    // if (null != map.get("startDate"))
    // {
    // map = reversalWithUTC(map, "startDate", "yyyy-MM-dd");
    // }
    // if (null != map.get("test_finish_time"))
    // {
    // map = reversalWithUTC(map, "test_finish_time",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("developStartTime"))
    // {
    // map = reversalWithUTC(map, "developStartTime",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("jadeTestStartTime"))
    // {
    // map = reversalWithUTC(map, "jadeTestStartTime",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("jadeTestFinishTime"))
    // {
    // map = reversalWithUTC(map, "jadeTestFinishTime",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("fatTestStartTime"))
    // {
    // map = reversalWithUTC(map, "fatTestStartTime",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("fatTestFinishTime"))
    // {
    // map = reversalWithUTC(map, "fatTestFinishTime",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("uatTestStartTime"))
    // {
    // map = reversalWithUTC(map, "uatTestStartTime",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("uatTestFinishTime"))
    // {
    // map = reversalWithUTC(map, "uatTestFinishTime",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("accepted_time"))
    // {
    // map = reversalWithUTC(map, "accepted_time", "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("testdesign_finish_time"))
    // {
    // map = reversalWithUTC(map, "testdesign_finish_time",
    // "yyyy-MM-dd'T'HH:mm:ss'Z'");
    // }
    // if (null != map.get("release_date"))
    // {
    // map = reversalWithUTC(map, "release_date", "yyyy-MM-dd");
    // }
    // if (null != map.get("release_finish_date"))
    // {
    // map = reversalWithUTC(map, "release_finish_date", "yyyy-MM-dd");
    // }
    // if (null != map.get("develop_plan_time"))
    // {
    // map = reversalWithUTC(map, "develop_plan_time", "yyyy-MM-dd HH:mm:ss");
    // }
    // if (null != map.get("develop_finish_time"))
    // {
    // map = reversalWithUTC(map, "develop_finish_time", "yyyy-MM-dd HH:mm:ss");
    // }
    // }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param map
     * @param name
     * @param format
     * @return Map
     */
    private static Map reversalWithUTC(Map map, String name, String format)
    {
        if (null != map.get(name))
        {
            String str = (String) map.get(name);
            SimpleDateFormat df = new SimpleDateFormat(format);
            df.setTimeZone(TimeZone.getTimeZone("UTC"));
            long num = 0;
            try
            {
                num = df.parse(str).getTime();
            }
            catch (ParseException e)
            {
                LOGGER.error("ReversalwithUTC error, ParseException");
            }
            map.put(name, num);
        }
        return map;
    }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param dateString
     * @param longDateFormat
     * @return String
     */
    public static String revUTCByString(String dateString, boolean longDateFormat)
    {
        if (StringUtils.isEmpty(dateString))
        {
            return null;
        }

        SimpleDateFormat df;
        if (longDateFormat == true)
        {
            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        else
        {
            df = new SimpleDateFormat("yyyy-MM-dd");
        }
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        long num = 0;
        try
        {
            num = df.parse(dateString).getTime();
        }
        catch (ParseException e)
        {
            LOGGER.error("revUTCByString error, ParseException");
        }

        return String.valueOf(num);
    }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param time
     * @return String
     */
    public static final String longReversal(Long time)
    {
        if (time == null)
        {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date(time));
        return date;
    }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param time
     * @param formatType
     * @return String
     */
    public static final String longReversal(Long time, String formatType)
    {
        if (time == null)
        {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatType);
        String date = sdf.format(new Date(time));
        return date;
    }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param longDates
     * @return List
     */
    public static List longReversalList(List longDates)
    {
        List stringDates = new ArrayList();
        if (longDates != null && longDates.size() > 0)
        {
            for (Object object : longDates)
            {
                stringDates.add(longReversal(Long.valueOf(object.toString())));
            }
        }

        return stringDates;
    }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param time
     * @param longDateFormat
     * @return String
     */
    public static final String longReversalUTCString(Long time, boolean longDateFormat)
    {
        if (time == null)
        {
            return null;
        }

        SimpleDateFormat df;
        if (longDateFormat)
        {
            df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        }
        else
        {
            df = new SimpleDateFormat("yyyy-MM-dd");
        }
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String date = df.format(new Date(time));
        return date;
    }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param dateStr
     * @return long
     */
    public static long datestrToLong(String dateStr)
    {
        long num = 0;
        try
        {
            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat df = new SimpleDateFormat(format);
            num = df.parse(dateStr).getTime();
        }
        catch (ParseException e)
        {
            LOGGER.error("datestrToLong error, ParseException");
        }

        return num;
    }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param date
     * @return String
     */
    public static String dateToString(Date date)
    {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    /**
     * 按照format格式化日期
     * @author lWX605537
     * @date 2019年4月8日
     * @param date Date
     * @param format String
     * @return String
     */
    public static String dateToString(Date date, String format)
    {
        if (org.springframework.util.StringUtils.isEmpty(format))
        {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    /**
     * TODO 增加功能描述
     * @author wWX459444
     * @date 2017年6月20日
     * @param date
     * @return String
     */
    public static String dateToTimeString(Date date)
    {
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    /**
     * long 转日期 TODO 增加功能描述
     * @author yWX572504
     * @date 2018年9月6日
     * @param millSec millSec
     * @return String
     */
    public static String transferLongToDate(Long millSec)
    {
        if (millSec == 0)
        {
            return "--";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(millSec);
        return sdf.format(date);
    }

}