package demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 功能描述：自定义拦截器
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月28日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
public class MyInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        System.out.println("preHandle被调用");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception
    {
        System.out.println("postHandle被调用");
    }

}
