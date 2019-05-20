package demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.huawei.it.eip.apigw.client.ApiGatewayClient;
import com.huawei.it.eip.apigw.client.ApiRequest;
import com.huawei.it.eip.apigw.client.ApiResponse;
import com.huawei.it.eip.apigw.client.Http;

public class addSandbox
{
    private static String appId = "com.huawei.ipd.plm.openeco";
    private static String appKey = "MIICYAIBAAKBgQCZzZWKQe5T2kN5IqjxLcuQoKJ3yJqZg1X21GifJN8Z7BABJqDWwBUadv7vahdthuU7X2NGtMZ81OheNBGbBEIW6ABepGOMdOmUO"
            + "5J7UHKc19PxuXqxzZbjlyd0oNpOK6YAvS5TEh3tJWfYGLgDFhuuPe1YQy5ivMgQbjOUzfXCEQIDAQABAoGBAIDqRPHCGZXHWM7sMlcVX482VXe5eXw7DY76s0bRjP8ZUsDkM+RM"
            + "1GN+Ymkir8hqTTHa3kehts1jV/G+Co29uvjfPzXLF/OZYLhymaezZHU7DUskd1xBcCoeJJOl9QqlLklCVMjVQt5IepWiocCxigqmFHEx1pIZQ6M5nL2kWhABAkUAn9foSFUbsWBF"
            + "1v6qqXpJAnKpjuzZrq2TROMw1xoyBOUQBOE8FQ2MPHNeEYrbyLoDv1gQJR0gHloxwy7GIg69+r4nfdECPQD2U3VxVUFqwTB+6lC/NwPDx7HW1I297uRn/QAbAD6VTetKrmIUKx79"
            + "xScv/z0HWlqWaefxgYVbbtil0EECRAY+aNRqfqpvGEtNp1z3aeKul/D9T4ODRD1sonvEii+mwvlt0ur/nHrABuyof+1XVs4ion7QpHCLFWaKbTLnYIRq6SABAj0A0ziLm2w01Rrl"
            + "v96i8OR26Pmi6ImJJZXk67qJzZ1vDM4s9fQEjDDRuV/Gk6S1K0nyJcqYpoGe3eF2CvFBAkNmYLKe2WcKA2HTvQUhOPb7d5s5r+vIDA83vmDek19SVzoRlKx48L3+S8Q815HT6NeUG"
            + "1UbCAr5pD1WC5Bws4wCjdle";

    private static String token = "5ac52ea6-2355-483b-8a31-be838a388ccf";

    public static void main(String[] args)
    {
        Boolean ssl = false;
        String host = "apigw-beta.huawei.com/";
        String service = "/openecosystem/openecoplatform/addSandbox";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("token", token);
        /* 设置请求Parameter的内容 */
        Map<String, String> params = new HashMap<String, String>();
        /* 设置请求的内容(仅限于POST) */
        JSONObject content = new JSONObject();
        content.put("blueprintId", 1);
        content.put("startTime", "2019-01-11 14:00:00");
        content.put("endTime", "2019-01-11 14:00:00");
        content.put("labName", new Date().getTime());
        ApiRequest request = new ApiRequest(ssl, host);
        request.setAppId(appId);
        request.setAppKey(appKey);
        request.setServiceUri(service);
        request.setMethod(Http.HTTP_POST);
        request.setHeaders(headers);
        request.setParameters(params);
        request.setContentType("text/plain");
        request.setContent(content.toJSONString());
        try
        {
            ApiResponse response = new ApiGatewayClient().execute(request);
            String str = response.getContentString();
            // System.err.println(str);
            JSONObject jObject = JSONObject.parseObject(response.getContentString());
            Set<Map.Entry<String, Object>> set = jObject.entrySet();
            for (Entry<String, Object> entry : set)
            {
                System.err.print(entry.getKey() + " : ");
                System.err.println(entry.getValue());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
