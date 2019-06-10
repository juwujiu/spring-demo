package demo.utils;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 功能描述：xml转json
 * @编码实现人员 cutter
 * @实现日期 2018年12月29日
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
