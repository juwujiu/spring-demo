package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONObject;

import demo.utils.Xml2Json;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 cutter
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月29日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
public class Test05
{

    /**
     * TODO 增加功能描述
     * @author cutter
     * @date 2018年12月29日
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException
    {
        Writer writer = new OutputStreamWriter(new FileOutputStream(new File("d:/1.json")));
        try
        {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new FileInputStream(new File("d:/1.xml")));
            Element rootElt = document.getRootElement().elements("root").get(0);
            // List<?> nodeList = rootElt.elements("mxCell");
            // Element element = (Element) nodeList.get(0);
            Xml2Json xml2Json = new Xml2Json();
            JSONObject jObject = xml2Json.getJson(rootElt);
            writer.write(jObject.toJSONString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            writer.flush();
            writer.close();
        }
    }
}
