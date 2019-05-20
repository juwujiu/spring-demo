package demo.config;

import java.util.Properties;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.github.pagehelper.PageInterceptor;

/**
 * 功能描述：将自定义配置转换成Bean并启用
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月28日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
@Configuration
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MyConfig implements WebMvcConfigurer
{

    /**
     * 添加拦截器
     * @author cutter
     * @date 2018年12月20日
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        System.err.println("拦截器已添加");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/*");
    }

    /**
     * 添加过滤器
     * @author cutter
     * @date 2018年12月11日
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean filterRegistr()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/*");
        System.err.println("过滤器已添加");
        return bean;
    }

    /**
     * 添加监听器
     * @author cutter
     * @date 2018年12月11日
     * @return ServletListenerRegistrationBean
     */
    @Bean
    public ServletListenerRegistrationBean listenerRegist()
    {
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new MyListener());
        System.err.println("监听器已添加");
        return bean;
    }

    /**
     * 添加websocket支持
     * @author cutter
     * @date 2019年3月27日
     * @return ServerEndpointExporter
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter()
    {
        return new ServerEndpointExporter();
    }

    /**
     * 添加pagehelper分页插件
     * @author cutter
     * @date 2018年12月11日
     * @return PageInterceptor
     */
    @Bean(name = "pageHelper")
    public PageInterceptor pageHelper()
    {
        PageInterceptor pageHelper = new PageInterceptor();
        Properties properties = new Properties();
        /** 默认false，设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用 */
        properties.setProperty("offsetAsPageNum", "true");
        /** 默认false，设置为true时，使用RowBounds分页会进行count查询 */
        properties.setProperty("rowBoundsWithCount", "true");
        /** 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据 */
        properties.setProperty("reasonable", "true");
        /** always总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page */
        properties.setProperty("returnPageInfo", "check");
        /** 支持通过Mapper接口参数来传递分页参数 */
        properties.setProperty("supportMethodsArguments", "false");
        /** 配置数据库的方言 */
        properties.setProperty("helperDialect", "oracle");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
