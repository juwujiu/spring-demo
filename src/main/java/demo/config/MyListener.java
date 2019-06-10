package demo.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 功能描述：自定义监听器
 * @编码实现人员 cutter
 * @实现日期 2018年11月28日
 */
public class MyListener implements HttpSessionListener
{

    /**
     * 创建session
     * @author cutter
     * @date 2018年11月28日
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        System.out.println("创建session");
    }

    /**
     * 销毁session
     * @author cutter
     * @date 2018年11月28日
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        System.out.println("销毁session");
    }

}
