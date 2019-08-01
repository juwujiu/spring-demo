package demo.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 功能描述：数据库连接配置
 * @编码实现人员 cutter
 * @实现日期 2019年6月10日
 */
@Configuration
@PropertySource("classpath:application.yaml")
public class DataSource
{
    @Bean
    public BasicDataSource dataSource1()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        // dataSource.setMaxActive(1000000000);
        dataSource.setMaxWait(3000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }
}
