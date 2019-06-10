package demo.entity;

import java.util.List;

import lombok.Data;

/**
 * 功能描述：TODO 增加描述代码功能
 * @编码实现人员 cutter
 * @实现日期 2018年12月11日
 */
@Data
public class ProgressInfo
{
    private String appId;
    private String envName;
    private String sceneName;
    private String curProgress;
    private List<StepInfo> step;
}
