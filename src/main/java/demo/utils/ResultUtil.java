package demo.utils;

import demo.entity.Result;

/**
 * 功能描述：返回结果工具类
 * @编码实现人员 cutter
 * @实现日期 2018年11月29日
 */
public class ResultUtil
{

    /**
     * TODO 增加功能描述
     * @author cutter
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
     * @author cutter
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
     * @author cutter
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
