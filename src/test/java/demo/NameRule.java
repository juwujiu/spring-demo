package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NameRule
{

    public static void main(String[] args) throws Exception
    {
        List<String> strs = new ArrayList<>();
        String str1 = "";
        FileReader reader1 = new FileReader("d:/name.txt");
        BufferedReader bReader1 = new BufferedReader(reader1);
        while ((str1 = bReader1.readLine()) != null)
        {
            strs.add(str1);
        }
        String str2 = "";
        String str3 = "";
        for (String str : strs)
        {
            String[] subs = str.split("_");
            str2 = subs[0];
            for (int i = 0; i < subs.length; i++)
            {
                if (i != 0)
                {
                    str3 = new StringBuilder().append(Character.toUpperCase(subs[i].charAt(0))).append(subs[i].substring(1)).toString();
                    str2 += str3;
                }
            }
            System.out.println(str2);
        }
    }

}
