package demo;

import org.apache.commons.lang.StringUtils;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 cutter
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月12日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
public class Test02
{

    private static final Integer BYTE_SIZE = 127;
    private static final Integer TWO = 2;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer SIX = 6;
    private static final Integer SIXTEEN = 16;

    /**
     * TODO 增加功能描述
     * @author cutter
     * @date 2018年12月12日
     * @param args String[]
     */
    public static void main(String[] args)
    {
        String str = "nginx时延";
        System.out.println(string2Unicode(str));
    }

    /**
     * 将字符串转化成unicode码
     * @author shuai.ding
     * @param string String
     * @return String
     */
    public static String string2Unicode(String string)
    {

        if (StringUtils.isBlank(string))
        {
            return null;
        }

        char[] bytes = string.toCharArray();
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < bytes.length; i++)
        {
            char c = bytes[i];

            // 标准ASCII范围内的字符，直接输出
            if (c >= 0 && c <= BYTE_SIZE)
            {
                unicode.append(c);
            }
            else
            {
                String hexString = Integer.toHexString(bytes[i]);
                unicode.append("\\u");
                // 不够四位进行补0操作
                if (hexString.length() < FOUR)
                {
                    unicode.append("0000".substring(hexString.length(), FOUR));
                }
                unicode.append(hexString);
            }
        }
        return unicode.toString();
    }

    /**
     * 将unicode码转化成字符串
     * @author shuai.ding
     * @param unicode String
     * @return String
     */
    public static String unicode2String(String unicode)
    {
        if (StringUtils.isBlank(unicode))
        {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while ((i = unicode.indexOf("\\u", pos)) != -1)
        {
            sb.append(unicode.substring(pos, i));
            if (i + FIVE < unicode.length())
            {
                pos = i + SIX;
                sb.append((char) Integer.parseInt(unicode.substring(i + TWO, i + SIX), SIXTEEN));
            }
        }
        // 如果pos位置后，有非中文字符，直接添加
        sb.append(unicode.substring(pos));

        return sb.toString();
    }
}
