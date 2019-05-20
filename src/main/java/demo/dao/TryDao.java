package demo.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import demo.entity.TestBean;

/**
 * 功能描述：TODO 增加描述代码功能
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年12月11日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
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
