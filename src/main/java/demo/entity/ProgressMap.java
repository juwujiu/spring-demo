package demo.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
public class ProgressMap
{
    private static Map<String, ProgressInfo> progressMap = new ConcurrentHashMap<>();

    /**
     * TODO 增加功能描述
     * @author lWX605537
     * @date 2018年12月11日
     * @param info ProgressInfo
     * @return
     * @return Boolean
     */
    public Boolean put(ProgressInfo info)
    {
        String envName = info.getEnvName();
        if (info.getAppId() == null && progressMap.get(envName) != null)
        {
            String appId = progressMap.get(envName).getAppId();
            info.setAppId(appId);
        }
        progressMap.put(info.getEnvName(), info);
        return true;
    }

    /**
     * TODO 增加功能描述
     * @author lWX605537
     * @date 2018年12月11日
     * @param envName String
     * @return
     * @return ProgressInfo
     */
    public ProgressInfo get(String envName)
    {
        return progressMap.get(envName);
    }
}