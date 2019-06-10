package demo.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import demo.entity.TestBean;

/**
 * 功能描述：TODO 增加描述代码功能
 * @编码实现人员 cutter
 * @实现日期 2018年12月11日
 */
public interface TryDao
{
    /**
     * TODO 增加功能描述
     * @author cutter
     * @date 2018年12月11日
     * @return
     * @return String
     */
    Date test();

    /**
     * TODO 增加功能描述
     * @author cutter
     * @date 2019年4月1日
     * @param bean
     * @param id2
     * @return
     * @return TestBean
     */
    List<TestBean> paramTest(@Param("bean") TestBean bean, @Param("id2") String id2);
}
