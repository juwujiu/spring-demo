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
 * @编码实现人员 cutter
 * @实现日期 2018年11月28日
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
    public FilterRegistrationBean<?> filterRegistr()
    {
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
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
    public ServletListenerRegistrationBean<MyListener> listenerRegist()
    {
        ServletListenerRegistrationBean<MyListener> bean = new ServletListenerRegistrationBean<>();
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
