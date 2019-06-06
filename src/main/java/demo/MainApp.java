package demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 cutter
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月11日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
@SpringBootApplication
@EnableScheduling
@Component("demo.*")
@MapperScan("demo.dao")
// @MyBatisLoader({ "saas = com.llc.admin.web.dao.saas = classpath:mapper/*xml",
// "saas2 = com.llc.admin.web.dao.saas2 =
// classpath:mapper/*.xml,classpath:mapper/user/*.xml" })
public class MainApp
{

    /**
     * mian方法 尽量与配置项解耦
     * @author cutter
     * @date 2018年12月11日
     * @param args String[]
     */
    public static void main(String[] args)
    {
        SpringApplication app = new SpringApplication(MainApp.class);
        app.run(args);
        System.err.println("--------启动完成!--------");
    }

}
