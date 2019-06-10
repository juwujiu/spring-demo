package demo.entity;

import lombok.Data;

/**
 * 用户操作实体类
 * @编码实现人员 cutter
 * @实现日期 2018年11月22日
 */
@Data
public class Action
{
    private String id;
    private String name;
    private String guid;
    private String url;
    private String method;
    private String productId;
    private Double order;
}
