//package com.beilie.test.op;
//
//import com.beilie.core.test.EFTestCase;
//import com.beilie.test.EFTester;
//import org.json.JSONObject;
//import org.junit.Test;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class Tester extends EFTestCase {
//    @Test
//    public void testImport() throws Exception {
//        Arrays.asList("68656914",
//                "68656915",
//                "68656916",
//                "68656917",
//                "68656919",
//                "68656920",
//                "68656921",
//                "68656922",
//                "68656923",
//                "68656924").forEach(userName -> {
//            try {
//                JSONObject execute =
//                        EFTester.build("op-v1").path("/www/hunter/" + userName + "/import")
//                                .method(RequestMethod.PUT)
//                                .runAs("yuanyixin@beilie")
//                                .execute();
//                this.puttyPrint(execute);
//            } catch (Exception e) {
//
//            }
//        });
//    }
//
//    @Test
//    public void getOne() throws Exception {
//
//    }
//
//    @Test
//    public void recommends() throws Exception {
//        JSONObject execute = EFTester.build("op-v1").path("/www/hunters").method(RequestMethod.GET).execute();
//        this.puttyPrint(execute);
//    }
//}
