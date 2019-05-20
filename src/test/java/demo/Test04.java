package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月20日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式： 什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
public class Test04
{
    /**
     * TODO 增加功能描述
     * @author lWX605537
     * @date 2018年12月20日
     * @param args String[]
     */
    public static void main(String[] args)
    {
        String str1 = "d:/usecases.json";
        String str2 = "d:/12/usecases.json";
        File source = new File(str1);
        File dest = new File(str2);
        File dir = new File("d:/12");
        dir.mkdirs();
        copyFileUsingFileChannels(source, dest);
    }

    @SuppressWarnings("resource")
    private static void copyFileUsingFileChannels(File source, File dest)
    {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try
        {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                inputChannel.close();
                outputChannel.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
