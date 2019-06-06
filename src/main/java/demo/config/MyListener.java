package demo.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 功能描述：自定义监听器
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 cutter
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月28日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
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
