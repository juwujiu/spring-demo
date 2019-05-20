
package demo.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

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
 * @param <T>
 */
@SuppressWarnings("all")
@Component
public class ExcelUtil<T>
{

    private static final int NUMBER_2 = 2;

    private static final int NUMBER_6 = 6;

    private static final int NUMBER_12 = 12;

    private static final int NUMBER_16 = 16;

    private static final int NUMBER_30 = 30;

    private static final double NUMBER_35_7 = 35.7;

    private static final int NUMBER_60 = 60;

    private static final int NUMBER_80 = 80;

    private static final int NUMBER_255 = 255;

    private static final int NUMBER_1023 = 1023;

    /**
     * 这是一个通用的方法，可以将放置在JAVA集合中并且符合一定条件的数据以EXCEL 的形式输出到指定IO设备上
     * @param headerField 要导出的Excel标题行描述
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out 与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param param 文件参数：{"sheetName":"","pattern":"yyyy-MM-dd"}
     * @return String
     */
    public String exportExcel(Map<String, String> headerField, Collection<T> dataset, OutputStream out, Map<String, String> param)
    {
        String pattern = param.get("pattern");
        String sheetName = param.get("sheetName");
        String reqType = param.get("reqType");

        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);

        // 设置表格默认列宽度为16个字节
        sheet.setDefaultColumnWidth((short) NUMBER_16);
        // 生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();
        // XSSFCellStyle styleAutoLine = workbook.createCellStyle();
        // 设置表头样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);// 单元格背景色
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) NUMBER_12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 生成并设置内容样式
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        XSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);

        // 生成超练级样式
        XSSFCellStyle linkStyle = workbook.createCellStyle();
        XSSFFont cellFont = workbook.createFont();
        cellFont.setUnderline((byte) 1);
        cellFont.setColor(HSSFColor.BLUE.index);
        linkStyle.setFont(cellFont);
        linkStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        linkStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        linkStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        linkStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        linkStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        linkStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        linkStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        linkStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        // 声明一个画图的顶级管理器
        XSSFDrawing patriarch = sheet.createDrawingPatriarch();

        XSSFFont font3 = workbook.createFont();

        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        row.setHeightInPoints((short) NUMBER_30);
        style.setWrapText(true);// 开启自动换行需要setWrapText（true）

        ArrayList<String> fieldList = new ArrayList<String>();
        Iterator iterator = headerField.entrySet().iterator();
        int ii = 0;
        while (iterator.hasNext())
        {
            Map.Entry<String, String> me = (Entry<String, String>) iterator.next();

            XSSFCell cell = row.createCell(ii);
            cell.setCellStyle(style);
            XSSFRichTextString text = new XSSFRichTextString(me.getValue());
            cell.setCellValue(text);
            ii++;

            // 保存一份字段代码名称
            fieldList.add(me.getKey());
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        try
        {
            while (it.hasNext())
            {
                index++;
                row = sheet.createRow(index);
                T t = it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                for (short i = 0; i < fieldList.size(); i++)
                {
                    XSSFCell cell = row.createCell(i);
                    cell.setCellStyle(style2);

                    String fieldName = fieldList.get(i);
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    if (null == value)
                    {
                        continue;
                    }
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Long)
                    {
                        // 时间数据如果是0,说明数据库中没有存储,则产生的excel单元格的数据为"",否则转换为指定格式的时间数据
                        if ((long) value != 0)
                        {
                            textValue = TimeFormat.longReversal((Long) value, pattern);
                        }
                        else
                        {
                            textValue = "";
                        }
                    }
                    else if (value instanceof byte[])
                    {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(NUMBER_60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (NUMBER_35_7 * NUMBER_80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, NUMBER_1023, NUMBER_255, (short) NUMBER_6, index, (short) NUMBER_6, index);
                        anchor.setAnchorType(NUMBER_2);
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, XSSFWorkbook.PICTURE_TYPE_JPEG));
                    }
                    else if (value instanceof Date)
                    {
                        if (value != null)
                        {
                            textValue = TimeFormat.dateToString((Date) value, pattern);
                        }
                    }
                    else
                    {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null)
                    {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches())
                        {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        }
                        else
                        {
                            XSSFRichTextString richString = new XSSFRichTextString(textValue);

                            font3.setColor(HSSFColor.BLUE.index);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                    // sheet.autoSizeColumn(i);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            workbook.write(out);
            out.flush();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return "success";
    }

    /**
     * get cell value as string
     * @param cell cell
     * @return String value
     */
    public static String getStringValueFromCell(XSSFCell cell)
    {
        switch (cell.getCellTypeEnum())
        {
            case BLANK:
                return null;
            case ERROR:
                return cell.getErrorCellString();
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case _NONE:
                return null;
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell))
                {
                    // 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm"))
                    {
                        sdf = new SimpleDateFormat("HH:mm");
                    }
                    else
                    {
                        // 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                    }
                    Date date = cell.getDateCellValue();
                    return sdf.format(date);
                }
                return String.valueOf(cell.getNumericCellValue());
            default:
                return null;
        }
    }
}
