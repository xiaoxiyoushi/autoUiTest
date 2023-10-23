package com.beilie.test.bole.cases.收款.CCL;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP05Page;
import com.beilie.test.bole.pages.GP.GPRV01Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

import java.util.Map;

public class _03GPRV01收款计划_使用预付款 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login_ceshi("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗

        GPRV01Page gPRV01Page = (GPRV01Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单
                .clickSecondMenu_collection()//点开二级菜单：收款计划
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(2);
        double i = Public.generateNumber1_n(1000) + 0.19;
        String b = i + "";

        /*获取tabel的候选人、公司名称、职位名称、本次收款金额*/
        Map<String, Object> hash = gPRV01Page.getValue();

        GPCP05Page gPCP05Page = (GPCP05Page) gPRV01Page.operation_click(2)//点击使用预付款
                .switchToNewIframe(0, GPCP05Page.class).sleepForSeconds(2);

        GPRV01Page gPRV01Page_1 = (GPRV01Page) gPCP05Page
                .scrollBar()
                .clickInputPlaceholder("请选择预付款").sleepForSeconds(1)
                .spanClass_click("ivu-radio-inner")
                .scrollBar()
                .button_classClick("inBlock selectAdvance_bg_searchBtn selectAdvance_bg_searchBtn_click")//点击【确定】
                .sleepForSeconds(1)
                .sendInputPlaceholder("请输入使用预付款金额", b)
                .selectTime_Many("请选择绩效时间", "\n" +
                        "              绩效时间：")
                .clickButton("提交")
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(1);

        gPRV01Page_1.searchInform(hash)//根据候选人姓名、公司名称、职位名称，搜索
                .checkInform_prePayment(hash, b).sleepForSeconds(1);//核对提交的预付款使用
    }
}
