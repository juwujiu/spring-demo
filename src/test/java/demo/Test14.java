package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        for (Object object : jArray)
        {
            JSONObject jObject = (JSONObject) object;
            System.out.print(jObject.get("projectId"));
            System.out.print("\t");
            System.out.println(jObject.get("projectName"));
        }
    }
}
