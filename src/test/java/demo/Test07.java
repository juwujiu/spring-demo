package demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test07
{
    private static String scriptRootDir = "C:/JADE/script/";

    public static void main(String[] args)
    {
        clearFtpFile("10.188.99.202", "CHINA\\\\xwx611465", "54jiancheng~", "1");
    }

    private static Boolean clearFtpFile(String ip, String user, String password, String account)
    {
        String uDir = "d:\\FolderRedirection\\" + account + "\\";
        List<String> script = new ArrayList<>();
        String str = "psexec \\\\ip -u user -p password cmd /c \"rmdir /s/q " + uDir + "\"";
        str = str.replaceAll("ip", ip).replaceAll("user", user).replaceAll("password", password);
        script.add(str);
        script.add("exit 0");
        String scriptDir = scriptRootDir + account + ".bat";
        writeScript(script, scriptDir);
        Process p = null;
        try
        {
            String cmd = "cmd /c start " + scriptDir;
            p = Runtime.getRuntime().exec(cmd, null, new File("D:\\JADE\\psexec\\"));
            Thread.currentThread().sleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            p.destroy();
        }
        File file = new File(scriptDir);
        if (file.exists())
        {
            if (file.isFile())
            {
                file.delete();
            }
        }
        return true;
    }

    private static Boolean writeScript(List<String> script, String orderFile)
    {
        Boolean result = true;
        File file = new File(orderFile);
        if (file.getParentFile() != null && !file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                result = false;
                e.printStackTrace();
            }
        }
        FileWriter writer = null;
        try
        {
            writer = new FileWriter(orderFile);
            for (String str : script)
            {
                writer.write(str + "\r\n");
            }
        }
        catch (IOException e)
        {
            result = false;
            e.printStackTrace();
        }
        finally
        {
            try
            {
                writer.close();
            }
            catch (IOException e)
            {
                result = false;
                e.printStackTrace();
            }
        }
        return result;
    }
}
