package demo.entity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述：TODO 增加描述代码功能
 * @编码实现人员 cutter
 * @实现日期 2018年12月11日
 */
public class ProgressMap
{
    private static Map<String, ProgressInfo> progressMap = new ConcurrentHashMap<>();

    /**
     * TODO 增加功能描述
     * @author cutter
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
     * @author cutter
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