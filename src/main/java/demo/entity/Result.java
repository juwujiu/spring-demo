package demo.entity;

import lombok.Data;

/**
 * 功能描述：返回结果封装类
 * @编码实现人员 cutter
 * @实现日期 2018年11月29日
 */
@Data
public class Result
{
    private String status = "success";
    private String msg = "";
    private int code = 0;
    private Object result;
}
