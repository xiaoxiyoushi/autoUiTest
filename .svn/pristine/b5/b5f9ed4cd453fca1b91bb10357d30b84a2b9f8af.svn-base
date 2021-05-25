//package com.beilie.test.es;
//
//import com.beilie.core.def.CompanyScale;
//import com.beilie.core.def.CompanyType;
//import com.beilie.test.EFTester;
//import org.json.JSONObject;
//import org.junit.Test;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.Date;
//
///**
// * 猎头注册并认证接口；
// */
//public class HunterRegisteAndAuthenticationTest extends ESTestCase{
//
//    public static final String ADMIN_ALIS = "admin@alis";
//
//    @Test
//    public void  registHunter() throws Exception {
////        String userName = this.registHunter("13817920269");
//        String userName="68652285";
//        String chainName="alis";
//        JSONObject execute = applyToHunterEnterpriseCARequest(userName, chainName);
//        puttyPrint(execute);
//    }
//
//    private static  final String IMAGE_FILE_ = "https://www.baidu.com/img/bd_logo1.png?where=super";
//
//    /**
//     * 提交公司信息
//     * @throws Exception
//     */
//    @Test
//    public void submitCompanyInfo() throws Exception {
//        JSONObject content = new JSONObject();
//        content.put("company","公司名称");
//        content.put("regionCode","1312312");
//        content.put("companyType", CompanyType.level0.name());
//        content.put("companyScale", CompanyScale.level2.name());
//        content.put("corporation","张三");
//        content.put("idPathA",IMAGE_FILE_);
//        content.put("idPathB",IMAGE_FILE_);
//        content.put("isThreeInOne",Boolean.TRUE);
//        content.put("uscc","234423423423");
//        content.put("businessLicenseFilePath",IMAGE_FILE_);
//        content.put("affilicated",this.newDate());
//        content.put("taxpayerNumber","1231231");
//        content.put("taxRegisterCertificateAvailableDate", this.newDate());
//        content.put("organizeCodeCertificateFilePath",IMAGE_FILE_);
//        content.put("organizeCodeCertificateNumber","1321");
//        content.put("organizeCodeCertificateAvailableDate",this.newDate());
//        content.put("otherCertificateFilePath",IMAGE_FILE_);
//
//        JSONObject execute = EFTester.build(SERVICE_NAME).path("/hunters/myCompany/pending/companyInfo")
//                .method(RequestMethod.PUT)
//                .content(content)
//                .runAs("admin@alis")
//                .execute();
//
//        puttyPrint(execute);
//    }
//
//    /**
//     * 获取已经提交的公司信息
//     * @throws Exception
//     */
//    @Test
//    public void findCompanyInfo() throws Exception {
//        JSONObject execute = EFTester.build(SERVICE_NAME).path("/hunters/myCompany/pending/companyInfo")
//                .method(RequestMethod.GET)
//                .runAs(ADMIN_ALIS)
//                .execute();
//        puttyPrint(execute);
//    }
//
//    @Test
//    public void getMyHunterEnterpriseProfile() throws Exception {
//        JSONObject execute = EFTester.build(SERVICE_NAME).path("/hunters/myCompany/profile")
//                .method(RequestMethod.GET)
//                .runAs(ADMIN_ALIS)
//                .execute();
//        this.puttyPrint(execute);
//    }
//
//    @Test
//    public void getHunterCompanyAuthed() throws Exception {
//        JSONObject execute = EFTester.build(SERVICE_NAME).path("/hunters/myCompany/authed")
//                .method(RequestMethod.GET)
//                .runAs(ADMIN_ALIS)
//                .execute();
//        this.puttyPrint(execute);
//    }
//
//}
