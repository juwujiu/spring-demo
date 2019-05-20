package demo;

import demo.inter.Company;
import demo.inter.EmployeeName;
import demo.inter.EmployeeSex;
import lombok.Data;

@Data
public class EmployeeInfo
{
    @EmployeeName("zfq")
    private String employeeName;
    @EmployeeSex(employeeSex = EmployeeSex.Sex.Woman)
    private String employeeSex;
    @Company(id = 1, name = "HYR集团", address = "河南开封")
    private String company;
}