package demo.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import demo.entity.Result;

/**
 * 功能描述：返回值包装
 * @编码实现人员 cutter
 * @实现日期 2018年11月26日
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
