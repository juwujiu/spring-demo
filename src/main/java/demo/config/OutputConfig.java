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
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月26日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
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