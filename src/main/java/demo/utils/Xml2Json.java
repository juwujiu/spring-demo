package demo.utils;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 功能描述：xml转json
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月29日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
public class Xml2Json
{
    public JSONObject getJson(Element elementF)
    {
        JSONObject jObject = new JSONObject();
        if (elementF != null)
        {
            List<Attribute> Attributes = elementF.attributes();
            for (Attribute attribute : Attributes)
            {
                String name = attribute.getName();
                String value = attribute.getValue();
                jObject.put(name, value);
            }
            List<Element> elements = elementF.elements();
            if (elements != null && elements.size() > 0)
            {
                for (Element elementC : elements)
                {
                    String name = elementC.getName();
                    JSONArray jArray = jObject.getJSONArray(name);
                    if (jArray == null)
                    {
                        jArray = new JSONArray();
                    }
                    jArray.add(getJson(elementC));
                    jObject.put(name, jArray);
                }
            }
        }
        return jObject;
    }
}
