package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 cutter
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月18日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
public class Test03
{

    /**
     * TODO 增加功能描述
     * @author cutter
     * @date 2018年12月18日
     * @param args String[]
     * @throws Exception 异常处理
     */
    public static void main(String[] args) throws Exception
    {
        Set<String> awSet = new HashSet<>();
        Set<String> yamlSet = new HashSet<>();
        Set<String> awSet1 = new HashSet<>();
        Set<String> yamlSet1 = new HashSet<>();
        File file = new File("D:\\aw.txt");
        FileReader reader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(reader);
        String s = "";
        while ((s = bReader.readLine()) != null)
        {
            if (awSet.contains(s))
            {
                System.out.println(s + "\n");
            }
            awSet.add(s);
            awSet1.add(s);
        }
        System.err.println("-------------");
        file = new File("D:\\yaml.txt");
        reader = new FileReader(file);
        bReader = new BufferedReader(reader);
        while ((s = bReader.readLine()) != null)
        {
            if (yamlSet.contains(s))
            {
                System.out.println(s + "\n");
            }
            yamlSet.add(s);
            yamlSet1.add(s);
        }
        bReader.close();
        System.out.println(awSet.size());
        System.out.println(yamlSet.size());
        System.err.println("-------------");
        yamlSet1.removeAll(awSet);
        System.out.println(yamlSet1.size());
        System.out.println(yamlSet1);
        System.err.println("-------------");
        awSet1.removeAll(yamlSet);
        System.out.println(awSet1.size());
        System.out.println(awSet1);

    }

}
