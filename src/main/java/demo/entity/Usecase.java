package demo.entity;

import java.util.List;

import lombok.Data;

/**
 * 用户行为集合实体类
 * @编码实现人员 cutter
 * @实现日期 2018年11月22日
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
