package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import demo.dao.TryDao;
import demo.entity.TestBean;

@Service
public class TService {
    @Autowired
    private TryDao tryDao;

    public String t1() {
        return "4fs6f4s";
    }

    @Cacheable(value = "t1")
    public List<TestBean> test(List<String> ids) {
        System.out.println("未调用缓存");
        return tryDao.paramTest(ids);
    }
}
