package demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import demo.utils.MagicNum;

@Order(value = MagicNum.TWO)
@Component
public class OrderRun implements CommandLineRunner
{
    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("---------");
        // System.err.println(test2Dao.getStrs());
    }
}
