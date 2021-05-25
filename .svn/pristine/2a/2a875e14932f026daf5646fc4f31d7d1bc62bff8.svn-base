//package com.beilie.test.es;
//
//import com.beilie.core.test.EFTestCase;
//import com.beilie.test.EFTester;
//import org.json.JSONObject;
//import org.junit.Test;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//public class UserTester extends ESTestCase{
//    private  static String SERVICE_NAME = "es-v2" ;
//    @Test
//    public void createApplicant() throws Exception {
//        JSONObject content = new JSONObject();
//        content.put("mobile","13817920284");
//        content.put("password","888888");
//        JSONObject execute = EFTester.build("es-v2").path("/nosession/register/applicants")
//                .method(RequestMethod.POST)
//                .content(content)
//                .execute();
//        this.puttyPrint(execute);
//
//    }
//    @Test
//    public void createHunter() throws Exception {
//        String account = this.registHunter("13817920284");
//        System.out.println(account);
//    }
//
//    @Test
//    public void createHunterEnterprise() throws Exception {
//        JSONObject content = new JSONObject();
//        content.put("chainName","alis");
//        content.put("displayName","爱丽丝漫游先进");
//        content.put("mobile","13817920276");
//        content.put("password","1");
//        JSONObject execute = EFTester.build(SERVICE_NAME).path("/nosession/register/hunters/enterprises")
//                .method(RequestMethod.POST)
//                .content(content)
//                .execute();
//        puttyPrint(execute);
//    }
//}
