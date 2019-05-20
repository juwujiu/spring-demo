package demo.utils;

import demo.entity.Result;

/**
 * 功能描述：返回结果工具类
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月29日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
public class ResultUtil
{

    /**
     * TODO 增加功能描述
     * @author lWX605537
     * @date 2018年12月11日
     * @param object Object
     * @return Result
     */
    public static Result success(Object object)
    {
        Result result = new Result();
        result.setResult(object);
        return result;
    }

    /**
     * TODO 增加功能描述
     * @author lWX605537
     * @date 2018年12月11日
     * @return Result
     */
    public static Result success()
    {
        return success(null);
    }

    // public static Result error(String msg)
    // {
    // System.err.println(msg);
    // Result result = new Result();
    // result.setMsg(msg);
    // return result;
    // }

    /**
     * TODO 增加功能描述
     * @author lWX605537
     * @date 2018年12月11日
     * @param code Integer
     * @param msg String
     * @return
     * @return Result
     */
    public static Result error(int code, String msg)
    {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setStatus("error");
        return result;
    }
}
