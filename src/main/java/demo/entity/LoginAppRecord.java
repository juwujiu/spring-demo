package demo.entity;

/**
 * 用户环境登陆记录VO 编码实现人员：lwx450772 需求提出人员： 实现日期：2018-11-29
 */
public class LoginAppRecord
{
    private String projectId;
    private String projectName;
    private String envId;
    private String envName;
    private String faId;
    private String faName;
    private String login;
    private String account;
    private String isInner;
    private String clientIp;
    private String appId;
    private String appName;
    private String ipMask;
    private String ipMaskCount;
    private String ipMaskCountry;
    private String nginxName;
    private String nginxOuterIp;
    private String clientArea;
    private String createTime;
    private String vpnName;
    private int nginxDelayTime;
    private int vpnDelayTime;
    private int totalDelayTime;

    public String getClientArea()
    {
        return clientArea;
    }

    public void setClientArea(String clientArea)
    {
        this.clientArea = clientArea;
    }

    public String getVpnName()
    {
        return vpnName;
    }

    public void setVpnName(String vpnName)
    {
        this.vpnName = vpnName;
    }

    public int getNginxDelayTime()
    {
        return nginxDelayTime;
    }

    public void setNginxDelayTime(int nginxDelayTime)
    {
        this.nginxDelayTime = nginxDelayTime;
    }

    public int getVpnDelayTime()
    {
        return vpnDelayTime;
    }

    public void setVpnDelayTime(int vpnDelayTime)
    {
        this.vpnDelayTime = vpnDelayTime;
    }

    public int getTotalDelayTime()
    {
        return totalDelayTime;
    }

    public void setTotalDelayTime(int totalDelayTime)
    {
        this.totalDelayTime = totalDelayTime;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getEnvName()
    {
        return envName;
    }

    public void setEnvName(String envName)
    {
        this.envName = envName;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getFaName()
    {
        return faName;
    }

    public void setFaName(String faName)
    {
        this.faName = faName;
    }

    public String getProjectId()
    {
        return projectId;
    }

    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public String getEnvId()
    {
        return envId;
    }

    public void setEnvId(String envId)
    {
        this.envId = envId;
    }

    public String getFaId()
    {
        return faId;
    }

    public void setFaId(String faId)
    {
        this.faId = faId;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getIsInner()
    {
        return isInner;
    }

    public void setIsInner(String isInner)
    {
        this.isInner = isInner;
    }

    public String getClientIp()
    {
        return clientIp;
    }

    public void setClientIp(String clientIp)
    {
        this.clientIp = clientIp;
    }

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getIpMask()
    {
        return ipMask;
    }

    public void setIpMask(String ipMask)
    {
        this.ipMask = ipMask;
    }

    public String getIpMaskCount()
    {
        return ipMaskCount;
    }

    public void setIpMaskCount(String ipMaskCount)
    {
        this.ipMaskCount = ipMaskCount;
    }

    public String getIpMaskCountry()
    {
        return ipMaskCountry;
    }

    public void setIpMaskCountry(String ipMaskCountry)
    {
        this.ipMaskCountry = ipMaskCountry;
    }

    public String getNginxName()
    {
        return nginxName;
    }

    public void setNginxName(String nginxName)
    {
        this.nginxName = nginxName;
    }

    public String getNginxOuterIp()
    {
        return nginxOuterIp;
    }

    public void setNginxOuterIp(String nginxOuterIp)
    {
        this.nginxOuterIp = nginxOuterIp;
    }

}
