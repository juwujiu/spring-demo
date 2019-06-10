package demo.config;

import javax.servlet.ServletException;

/**
 * 功能描述：RuntimeException异常处理
 * @编码实现人员 cutter
 * @实现日期 2018年11月29日
 */

public class MyException extends RuntimeException
{
    private static final long serialVersionUID = 881236006282985783L;

    private static final Integer STACK_INDEX = 2;

    /**
     * 自定义异常处理
     * @author cutter
     * @date 2018年11月28日
     * @param msg String
     * @throws ServletException
     */
    public MyException(String msg)
    {
        super(msg);
        String position = Thread.currentThread().getStackTrace()[STACK_INDEX].getClassName() + "."
                + Thread.currentThread().getStackTrace()[STACK_INDEX].getMethodName() + "("
                + Thread.currentThread().getStackTrace()[STACK_INDEX].getFileName() + ":"
                + Thread.currentThread().getStackTrace()[STACK_INDEX].getLineNumber() + ")";
        System.err.println(msg + "    " + position);
    }

}
