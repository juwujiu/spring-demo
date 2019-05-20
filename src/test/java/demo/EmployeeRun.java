package demo;

import java.util.Map;

import demo.utils.EmployeeInfoUtil;

public class EmployeeRun
{
    public static void main(String[] args)
    {
        Map fruitInfo = EmployeeInfoUtil.getEmployeeInfo(EmployeeInfo.class);
        System.out.println(fruitInfo);
    }
}
