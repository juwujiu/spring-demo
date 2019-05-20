package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

public class getSandboxs
{
    private static String appId = "com.huawei.ipd.plm.openeco";
    private static String appKey = "MIICYAIBAAKBgQCZzZWKQe5T2kN5IqjxLcuQoKJ3yJqZg1X21GifJN8Z7BABJqDWwBUadv7vahdthuU7X2NGtMZ81OheNBGbBEIW6ABepGOMdOmUO"
            + "5J7UHKc19PxuXqxzZbjlyd0oNpOK6YAvS5TEh3tJWfYGLgDFhuuPe1YQy5ivMgQbjOUzfXCEQIDAQABAoGBAIDqRPHCGZXHWM7sMlcVX482VXe5eXw7DY76s0bRjP8ZUsDkM+RM"
            + "1GN+Ymkir8hqTTHa3kehts1jV/G+Co29uvjfPzXLF/OZYLhymaezZHU7DUskd1xBcCoeJJOl9QqlLklCVMjVQt5IepWiocCxigqmFHEx1pIZQ6M5nL2kWhABAkUAn9foSFUbsWBF"
            + "1v6qqXpJAnKpjuzZrq2TROMw1xoyBOUQBOE8FQ2MPHNeEYrbyLoDv1gQJR0gHloxwy7GIg69+r4nfdECPQD2U3VxVUFqwTB+6lC/NwPDx7HW1I297uRn/QAbAD6VTetKrmIUKx79"
            + "xScv/z0HWlqWaefxgYVbbtil0EECRAY+aNRqfqpvGEtNp1z3aeKul/D9T4ODRD1sonvEii+mwvlt0ur/nHrABuyof+1XVs4ion7QpHCLFWaKbTLnYIRq6SABAj0A0ziLm2w01Rrl"
            + "v96i8OR26Pmi6ImJJZXk67qJzZ1vDM4s9fQEjDDRuV/Gk6S1K0nyJcqYpoGe3eF2CvFBAkNmYLKe2WcKA2HTvQUhOPb7d5s5r+vIDA83vmDek19SVzoRlKx48L3+S8Q815HT6NeUG"
            + "1UbCAr5pD1WC5Bws4wCjdle";
    private static String xAppKey = "SiVZcm5JXylJOUFCWm5uRg==";
    private static String blueprintId = "1";

    private static String token = "5ac52ea6-2355-483b-8a31-be838a388ccf";

    // private static RestTemplate restClient = SimpleRestClient.getClient();
    // private static RestTemplate restClient = new RestTemplate();

    public static void main(String[] args)
    {
        String host = "apigw-beta.huawei.com";
        String service = "/openecosystem/openecoplatform/getSandboxs?blueprintId=" + blueprintId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Content-Type", "application/json");
        headers.add("token", token);
        headers.add("X-HW-APPKEY", xAppKey);
        headers.add("X-HW-ID", appId);
        Map<String, Object> postData = new HashMap<>();
        HttpEntity<Object> httpEntity = new HttpEntity<Object>(postData, headers);
        try
        {
            RestTemplate restClient = new RestTemplate();
            JSONObject jObject = restClient.exchange(host + service, HttpMethod.GET, httpEntity, JSONObject.class).getBody();
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
