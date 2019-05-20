package demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * 取上游数据定时任务*
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月22日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
@Component
public class ExecuteSchedule
{

    /**
     * 测试定时任务间隔
     * @author cutter
     * @date 2018年12月26日
     */
    @Scheduled(cron = "0 */2 * * * ?")
    public void tesk()
    {
        System.out.println("已执行");
    }

}
