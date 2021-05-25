package com.beilie.test.es;

import com.beilie.core.test.EFTestCase;
import com.beilie.test.EFTester;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMethod;

public class ESTestCase extends EFTestCase{
    protected final static String SERVICE_NAME = "es-v2";

    /**
     * 注册猎头
     * @param mobile
     * @return
     * @throws Exception
     */
    public String registHunter(String mobile) throws Exception {
        JSONObject content = new JSONObject();
        content.put("mobile",mobile);
        content.put("password","888888");
        JSONObject execute = EFTester.build(SERVICE_NAME).path("/nosession/register/hunters")
                .method(RequestMethod.POST)
                .content(content)
                .execute();
        assertResponseSuccess(execute);
        return execute.getString("data");
    }

    /**
     * 获取猎头认证信息
     * @param userName
     * @return
     * @throws Exception
     */
    public JSONObject getHunterAuthenticationStatusResponse(String userName) throws Exception {
        return EFTester.build(SERVICE_NAME).path("/hunters/my/status")
                .method(GET)
                .runAs(userName)
                .execute();
    }

    /**
     * 获取猎头基本信息，包括用户信息、认证信息等；
     * @param userName
     * @return
     * @throws Exception
     */
    protected JSONObject getHunterProfileResponse(String userName) throws Exception {
        return EFTester.build(SERVICE_NAME).path("/hunter/" + userName + "/profile")
                    .method(GET)
                    .runAs(userName)
                    .execute();
    }

    /**
     * 申请成为猎企认证顾问，必须提供猎企租户名；
     * @param userName
     * @param chainName
     * @return
     * @throws Exception
     */
    protected JSONObject applyToHunterEnterpriseCARequest(String userName, String chainName) throws Exception {
        JSONObject content =new JSONObject();
        content.put("chainName",chainName);
        content.put("applyReason","申请理由。");
        return EFTester.build(SERVICE_NAME).path("/hunters/my/HEA")
                .method(RequestMethod.PUT)
                .runAs(userName)
                .content(content)
                .execute();
    }
}
