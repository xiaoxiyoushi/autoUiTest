//package com.beilie.test.es;
//
//import com.beilie.core.test.EFTestCase;
//import com.beilie.test.EFTester;
//import org.junit.Test;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//public class RepairTester extends EFTestCase{
//    private static String chainName = "daoye";
//
//    @Test
//    public void grant() throws Exception {
//        EFTester.build("es-v1").path("/admin/"+chainName+"/grant/OH")
//                .method(RequestMethod.PUT)
//                .runAs("admin@beilie")
//                .execute();
//    }
//    @Test
//    public void HEA() throws Exception {
//        EFTester.build("es-v1").path("/admin/"+chainName+"/grant/HEA")
//                .method(RequestMethod.PUT)
//                .runAs("admin@beilie")
//                .execute();
//    }
//    @Test
//    public void contact() throws Exception {
//        EFTester.build("es-v1").path("/admin/"+chainName+"/move/contact")
//                .method(RequestMethod.PUT)
//                .runAs("admin@beilie")
//                .execute();
//    }
//}
