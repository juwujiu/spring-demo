package demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.entity.Result;
import demo.utils.ResultUtil;

/***
 * 功能描述：异常处理
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月29日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
@ControllerAdvice
public class ExceptionHandle
{
    private static final int MSG_NUM = 501;
    private static final int USUAL_NUM = 500;

    /**
     * Exception类异常处理
     * @author lWX605537
     * @date 2018年12月11日
     * @param e Exception
     * @return Result
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e)
    {
        if (e instanceof MyException)
        {
            return ResultUtil.error(MSG_NUM, e.getMessage());
        }
        else
        {
            e.printStackTrace();
            return ResultUtil.error(USUAL_NUM, e.getMessage());
        }
    }

}
