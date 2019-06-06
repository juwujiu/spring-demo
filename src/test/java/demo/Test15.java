package demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import demo.entity.Action;

public class Test15
{
    private static final Set<String> PATHS = setPath();

    public static void main(String[] args)
    {
        List<Action> actions = new ArrayList<>();
        Action action = new Action();
        action.setId("1");
        actions.add(action);
        actions.forEach(a -> action.setId("0"));
        System.out.println(actions.get(0).getId());
    }

    private static Set<String> setPath()
    {
        Set<String> paths = new HashSet<>();
        paths.add("/v1/envManage/queryEnvInfosFromLCM");
        paths.add("/v1/envManage/exportEnvInfos");
        paths.add("/v1/envManage/updateAppAndAccount");
        paths.add("/v1/envManage/offEnvShelf");
        paths.add("/v1/envManage/deleteEnvShelf");
        paths.add("/v1/envManage/queryFusionAccessInfoLst");
        paths.add("/v1/envManage/queryApsByParams");
        paths.add("/v1/envManage/saveEnvShelfAppConfig");
        paths.add("/v1/envManage/queryUnusedAccountByParams");
        paths.add("/v1/envManage/createAccountByNum");
        paths.add("/v1/envManage/saveEnvShelfAccountConfig");
        paths.add("/v1/envManage/saveEnvShelfAccountAuthorize");
        paths.add("/v1/envManage/saveEnvShelfVpnReady");
        paths.add("/v1/envManage/queryMonitorList");
        paths.add("/v1/envManage/queryMonitorHistory");
        paths.add("/v1/envManage/queryAccountLstByParams");
        paths.add("/v1/envManage/queryGroupByParams");
        paths.add("/v1/envManage/queryVpnInfoList");
        paths.add("/v1/envManage/queryHost");
        paths.add("/v1/envManage/saveFusionAccess");
        paths.add("/v1/envManage/updateFusionAccess");
        paths.add("/v1/envManage/deleteFusionAccess");
        paths.add("/v1/envManage/saveAPS");
        paths.add("/v1/envManage/updateAPS");
        paths.add("/v1/envManage/deleteAps");
        paths.add("/v1/envManage/saveApplications");
        paths.add("/v1/envManage/saveApplicationsNew");
        paths.add("/v1/envManage/updateAppCommandLineById");
        paths.add("/v1/envManage/deleteApplication");
        paths.add("/v1/envManage/paths.addAccounts");
        paths.add("/v1/envManage/updateAccount");
        paths.add("/v1/envManage/deleteAccount");
        paths.add("/v1/envManage/saveGroup");
        paths.add("/v1/envManage/updateGroup");
        paths.add("/v1/envManage/deleteGroup");
        paths.add("/v1/envManage/paths.addVPN");
        paths.add("/v1/envManage/editVPN");
        paths.add("/v1/envManage/deleteVPN");
        paths.add("/v1/envManage/paths.addHost");
        paths.add("/v1/envManage/editHost");
        paths.add("/v1/envManage/removeHost");
        paths.add("/v1/envManage/queryAllEnvList");
        paths.add("/v1/envManage/queryLoginAppRecord");
        paths.add("/v1/envManage/queryProjectDelayTimes");
        paths.add("/v1/envManage/queryADUserSet");
        paths.add("/v1/envManage/queryUserLoginInfos");
        paths.add("/v1/envManage/queryRecord4Project");
        paths.add("/v1/envManage/queryRecord4Env");
        paths.add("/v1/envManage/queryRecord4Aps");
        paths.add("/v1/envManage/queryRecord4User");
        paths.add("/v1/envManage/queryRecord4UserOnline");
        paths.add("/v1/envManage/queryHasAccountEnvs");
        paths.add("/v1/envManage/queryEnvDetails");
        paths.add("/v1/envManage/queryEnvGroupByFa");
        paths.add("/v1/envManage/queryAccountEnvInfo");
        paths.add("/v1/envManage/queryEnvInfoByApsId");
        paths.add("/v1/envManage/saveStrategy");
        paths.add("/v1/envManage/queryStrategy");
        paths.add("/v1/envManage/updateStrategy");
        paths.add("/v1/envManage/queryProjectStrategysBySearch");
        paths.add("/v1/envManage/relatedStrategyToProject");
        paths.add("/v1/envManage/deleteStrategy");
        paths.add("/v1/envManage/paths.addAdminUser");
        paths.add("/v1/envManage/deleteAdminUser");
        paths.add("/v1/envManage/restartVPN");
        paths.add("/v1/envManage/pingTestForVpn");
        paths.add("/v1/envManage/syncApplication");
        paths.add("/v1/envManage/exportUserLoginInfos");
        paths.add("/v1/envManage/exportProjectDelayTimes");
        paths.add("/v1/envManage/exportLoginAppRecord");
        paths.add("/v1/envManage/updateEnvShelfAppConfig");
        paths.add("/v1/envManage/updateEnvShelfAccountConfig");
        return paths;
    }

}
