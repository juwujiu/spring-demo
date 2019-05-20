package demo.entity;

import java.util.List;

import lombok.Data;

/**
 * 用户行为集合实体类
 * @逻辑说明：TODO 增加描述代码逻辑
 * @牵涉到的配置项：TODO 如果代码中逻辑中牵涉到配置项在这里列出
 * @编码实现人员 lWX605537
 * @需求提出人员 TODO 填写需求提出人员
 * @实现日期 2018年11月22日
 * @版本 TODO 填写版本
 * @修改历史 TODO 新建的时候留空 修改的时候为格式：什么人 什么时候 因为什么 修改了什么 编码实现人员： 需求提出人员： 实现日期： 版本：
 *       修改内容： ------------------------------------------------
 */
@Data
public class Usecase
{
    private String id;
    private String name;
    private String actionStr;
    private List<Action> actions;
    private String productId;
    private String userId;
    private String order;
    private Double frequency;
}
