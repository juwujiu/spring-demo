package demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

/***
 * 功能描述：返回值包装
 * @编码实现人员 cutter
 * @实现日期 2018年11月26日
 */
@Configuration
public class OutputConfig implements InitializingBean
{
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        List<HandlerMethodReturnValueHandler> list = handlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newList = new ArrayList<>();
        if (null != list)
        {
            for (HandlerMethodReturnValueHandler valueHandler : list)
            {
                if (valueHandler instanceof RequestResponseBodyMethodProcessor)
                {
                    OutputProxy proxy = new OutputProxy(valueHandler);
                    newList.add(proxy);
                }
                else
                {
                    newList.add(valueHandler);
                }
            }
        }
        handlerAdapter.setReturnValueHandlers(newList);
    }
}