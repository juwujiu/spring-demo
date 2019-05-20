package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class APICompare
{

    public static void main(String[] args) throws Exception
    {
        String str = "";
        FileReader reader1 = new FileReader("d:/apiTest-01.txt");
        BufferedReader bReader1 = new BufferedReader(reader1);
        HashSet<String> list1 = new HashSet<>();
        while ((str = bReader1.readLine()) != null)
        {
            list1.add(str);
        }
        FileReader reader2 = new FileReader("d:/apiTest-02.txt");
        BufferedReader bReader2 = new BufferedReader(reader2);
        HashSet<String> list2 = new HashSet<>();
        while ((str = bReader2.readLine()) != null)
        {
            list2.add(str);
        }
        list2.removeAll(list1);
        for (String string : list2)
        {
            System.err.println(string);
        }
    }

}
