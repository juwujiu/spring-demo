package demo.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * 功能描述：自定义过滤器
 * @编码实现人员 cutter
 * @实现日期 2018年11月28日
 */
@Component
public class MyFilter implements Filter
{
    /**
     * 初始化过滤器
     * @author cutter
     * @date 2018年11月28日
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("过滤器初始化");

    }

    /**
     * 添加过滤器操作
     * @author cutter
     * @date 2018年11月28日
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain) throws IOException, ServletException
    {
        // HttpServletRequest request = (HttpServletRequest) sRequest;
        // response.setHeader("Access-Control-Allow-Origin", "*");
        // response.setHeader("Access-Control-Allow-Methods", "*");
        // response.setHeader("Access-Control-Max-Age", "3600");
        // response.setHeader("Access-Control-Allow-Headers",
        // "x-requested-with,Authorization");
        // response.setHeader("Access-Control-Allow-Credentials", "true");
        // chain.doFilter(request, response);
        // System.out.println("已进入过滤器");
        // HttpServletRequest request = (HttpServletRequest) sRequest;
        // HttpServletResponse response = (HttpServletResponse) sResponse;
        //
        // System.out.println(request.getServletPath());
        // HttpServletResponse responses = (HttpServletResponse) sResponse;
        // HttpSession session = request.getSession();
        // String currPath = request.getRequestURI();
        // response.sendRedirect("/error");
        // 获取配置文件数据
        // System.out.println(PropertiesUtil.prop("spring.application.name"));
        chain.doFilter(sRequest, sResponse);
    }

    /**
     * TODO 增加功能描述
     * @author cutter
     * @date 2018年11月28日
     */
    @Override
    public void destroy()
    {
        System.out.println("过滤器已销毁");

    }

}
