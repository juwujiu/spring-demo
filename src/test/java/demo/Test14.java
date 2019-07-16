package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test14
{

    public static void main(String[] args)
    {
        String all = "";
        try
        {
            File file = new File("D:\\1.json");
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            String s = "";
            while ((s = bReader.readLine()) != null)
            {
                all += s;
            }
            System.err.println("-------------");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        JSONArray jArray = JSONArray.parseArray(all);
        Map<String, String> map = new HashMap<>();
        for (Object object : jArray)
        {
            JSONObject jObject = (JSONObject) object;
            String key = (String) jObject.keySet().toArray()[0];
            String value = (String) jObject.values().toArray()[0];
            map.put(key, value);
        }
        for (String str : map.keySet())
        {
            if (!StringUtils.isEmpty(map.get(str)))
            {
                System.out.println("update temp_project set owner = '" + map.get(str) + "' where id = '" + str + "';");
            }
        }
    }
}
