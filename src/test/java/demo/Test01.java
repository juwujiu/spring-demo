package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import net.sf.json.JSONObject;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月4日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
public class Test01
{

    /**
     * TODO 增加功能描述
     * @author lWX605537
     * @date 2018年12月4日
     * @param args String[]
     * @throws IOException if has error
     */
    public static void main(String[] args)
    {
        BufferedReader bReader = null;
        try
        {
            File file = new File("C:/script/10.21.149.135/SmartRecovery_v2.0_jad/config/output/resultlog.json");
            FileReader reader = new FileReader(file);
            bReader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String s = "";
            while ((s = bReader.readLine()) != null)
            {
                sb.append(s);
            }
            String str = sb.toString();
            // 将读取的数据转换为JSONObject
            JSONObject jObject = JSONObject.fromObject(str);
            System.out.println(jObject);
            // file.deleteOnExit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bReader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
