package demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * 取上游数据定时任务*
 * @编码实现人员 cutter
 * @实现日期 2018年11月22日
 */
@Component
public class ExecuteSchedule
{
    /**
     * 测试定时任务间隔
     * @author cutter
     * @date 2018年12月26日
     */
    @Scheduled(cron = "0 * */20 * * ?")
    public void tesk()
    {
        System.out.println("已执行");
    }
}
