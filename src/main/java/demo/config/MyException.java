package demo.config;

import javax.servlet.ServletException;

/**
 * 功能描述：RuntimeException异常处理
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 cutter
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月29日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
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
