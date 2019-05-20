package demo.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月11日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
@RestController
public class TryController
{
    private String rootDir = "C:/script/";

    private final Integer magic1000 = 1000;

    /**
     * 使Monitor服务获取vpn所在机器的访问权限
     * @author lWX605537
     * @date 2018年11月13日
     * @param user String
     * @param password String
     * @param apsIp String
     * @param testIp String
     * @return Boolean
     */
    @GetMapping("/Monitor/v1/monitor/apsLogin")
    public Boolean apsLogin(String user, String password, String apsIp, String testIp)
    {
        // 为本机添加访问aps的权限
        // example: net use \\10.188.99.202\ipc$ 54jiancheng~ /user:xwx611465
        String msg = "net use \\\\" + apsIp + "\\ipc$ " + password + " /user:" + user;
        List<String> script1 = new ArrayList<>();
        script1.add(msg);
        Boolean result1 = runBat(script1);
        // 添加本机到aps的软链接
        // example:mklink /d c:\try+apsIp \\10.130.110.163\c$\temp
        List<String> script2 = new ArrayList<>();
        msg = "mklink /d c:\\script\\" + apsIp + " \\\\" + apsIp + "\\c$\\script";
        script2.add(msg);
        Boolean result2 = runBat(script2);
        String apsDir = rootDir + apsIp;
        File apsFile = new File(apsDir);
        if (!apsFile.exists())
        {
            apsFile.mkdirs();
        }
        String restartFile = apsDir + "/restart.bat";
        String signalFile = apsDir + "/signal.txt";
        List<String> script = new ArrayList<>();
        Boolean result3 = writeScript(script, restartFile);
        Boolean result4 = writeSignal(signalFile);
        // 启用aps上的ping脚本
        if (testIp != null && testIp != "")
        {
            rePing(apsIp, testIp);
        }
        return result1 && result2 && result3 && result4;
    }

    /**
     * 重启ping脚本
     * @author lWX605537
     * @date 2018年11月13日
     * @param apsIp String
     * @param testIp String
     * @return Boolean
     */
    public Boolean rePing(String apsIp, String testIp)
    {
        String apsDir = rootDir + apsIp;
        File apsFile = new File(apsDir);
        if (!apsFile.exists())
        {
            apsFile.mkdirs();
        }
        String restartFile = apsDir + "/ping/restart.bat";
        String signalFile = apsDir + "/ping/signal.txt";
        ArrayList<String> script = new ArrayList<String>();
        script.add("@echo off ");
        script.add("if \"%1\" == \"h\" goto begin ");
        script.add("mshta vbscript:createobject(\"wscript.shell\").run(\"%~nx0 h\",0)(window.close)&&exit ");
        script.add(":begin ");
        script.add("set /p b=<pid.txt");
        script.add("taskkill -pid %b%");
        script.add("title=pingBat");
        script.add("tasklist /v /fo csv| findstr /i \"pingBat\" > pid.txt");
        script.add("set /p a=<pid.txt");
        script.add("for /f \"tokens=2\" %%1 in (%a%)do set pid=%%1");
        script.add("echo %pid:\"=%");
        script.add("echo %pid:\"=%>pid.txt");
        script.add(":S");
        script.add("set t1=%date% %time%");
        script.add("ping " + testIp + " -n 3 ");
        script.add("if %ERRORLEVEL% EQU 0 (echo %t1%;%date% %time%;success>result.txt) else (echo %t1%;%date% %time%;error>result.txt)");
        script.add("goto S");
        Boolean result1 = writeScript(script, restartFile);
        Boolean result2 = writeSignal(signalFile);
        return result1 && result2;
    }

    /**
     * 本机运行bat文件
     * @author lWX605537
     * @date 2018年11月13日
     * @param msg String msg
     * @return Boolean
     */
    private Boolean runBat(List<String> script)
    {
        Boolean resullt = true;
        String orderFile = rootDir + "temp/temp.bat";
        script.add("exit");
        writeScript(script, orderFile);
        Process p = null;
        try
        {
            p = Runtime.getRuntime().exec("cmd /c start " + orderFile);
            Thread.currentThread();
            Thread.sleep(magic1000);
            // p.waitFor();
        }
        catch (Exception e)
        {
            resullt = false;
            e.printStackTrace();
        }
        finally
        {
            p.destroy();
        }
        return resullt;
    }

    /**
     * 写入标志位
     * @author lWX605537
     * @date 2018年11月13日
     * @param orderFile String
     * @return Boolean
     */
    private Boolean writeSignal(String orderFile)
    {
        List<String> script = new ArrayList<String>();
        script.add("1");
        Boolean result = writeScript(script, orderFile);
        return result;
    }

    /**
     * 写入脚本
     * @author lWX605537
     * @date 2018年11月13日
     * @param script Array<String>
     * @param orderFile String
     * @return Boolean
     */
    private Boolean writeScript(List<String> script, String orderFile)
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