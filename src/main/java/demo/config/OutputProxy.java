package demo.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import demo.entity.Result;

/**
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
public class OutputProxy implements HandlerMethodReturnValueHandler
{
    private HandlerMethodReturnValueHandler proxyObject;
    // private static final String STATUS_CODE_SUCCEEDED = "200";

    /**
     * TODO 增加功能描述
     * @author cutter
     * @date 2018年11月28日
     * @param proxyObject HandlerMethodReturnValueHandler
     */
    public OutputProxy(HandlerMethodReturnValueHandler proxyObject)
    {
        this.proxyObject = proxyObject;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType)
    {
        return proxyObject.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest) throws Exception
    {
        Result result = new Result();
        result.setResult(returnValue);
        proxyObject.handleReturnValue(result, returnType, mavContainer, webRequest);
    }
}
