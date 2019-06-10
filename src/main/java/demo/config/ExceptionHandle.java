package demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.entity.Result;
import demo.utils.ResultUtil;

/**
 * 功能描述：异常处理
 * @编码实现人员 cutter
 * @实现日期 2018年11月29日
 */
@ControllerAdvice
public class ExceptionHandle
{
    private static final int MSG_NUM = 501;
    private static final int USUAL_NUM = 500;

    /**
     * Exception类异常处理
     * @author cutter
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
