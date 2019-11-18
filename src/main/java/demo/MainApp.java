package demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 功能描述：TODO 增加描述代码功能
 * 
 * @编码实现人员 cutter
 * @实现日期 2018年12月11日
 */
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@EnableCaching
@Component("demo.*")
@MapperScan("demo.dao")
// @MyBatisLoader({ "saas = com.llc.admin.web.dao.saas = classpath:mapper/*xml",
// "saas2 = com.llc.admin.web.dao.saas2 =
// classpath:mapper/*.xml,classpath:mapper/user/*.xml" })
public class MainApp {
    /**
     * mian方法 尽量与配置项解耦
     * 
     * @author cutter
     * @date 2018年12月11日
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainApp.class);
        app.run(args);
        System.err.println("--------启动完成!--------");
    }
}
