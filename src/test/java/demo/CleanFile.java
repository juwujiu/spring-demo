package demo;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CleanFile
{
    private final static Set<String> dirs = new HashSet<String>()
    {
        {
            add("D:/temp");
            add("D:/1");
        }
    };

    private final static Set<String> removeDirs = new HashSet<String>()
    {
        {
            add("All Users");
            add("Default");
            add("Default User");
            add("DefaultAppPool");
            add("Public");
        }
    };

    private final static Set<String> preDirs = new HashSet<String>()
    {
        {
            add("All Users");
            add("Default");
            add("Default User");
            add("DefaultAppPool");
            add("Public");
        }
    };

    public static void main(String[] args)
    {
        for (String fileStr : dirs)
        {
            cleanUnderF(fileStr);
        }
    }

    private static List<File> getDirs()
    {

        return null;
    }

    private static boolean cleanUnderF(String fileStr)
    {
        try
        {
            File fileF = new File(fileStr);
            File[] fileS = fileF.listFiles();
            for (File file : fileS)
            {
                delFile(file);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    private static void delFile(File fileF)
    {
        if (fileF.isFile())
        {
            fileF.delete();
        }
        else
        {
            File[] files = fileF.listFiles();
            for (File file : files)
            {
                delFile(file);
            }
            fileF.delete();
        }
    }
}
