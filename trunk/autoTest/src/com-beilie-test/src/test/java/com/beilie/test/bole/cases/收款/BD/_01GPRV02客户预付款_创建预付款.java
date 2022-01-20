package com.beilie.test.bole.cases.收款.BD;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP06Page;
import com.beilie.test.bole.pages.GP.GPXX.GPRV02Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class _01GPRV02客户预付款_创建预付款 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657224", "1").sleepForSeconds(3);

        GPRV02Page gPRV02Page = (GPRV02Page) bdHomePage
                .clickMenus("\n" +
                        "          客户管理", "客户预付款")//点击菜单栏
                .switchToNewIframe1("GPRV02", GPRV02Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(2);
        double d = 10000 + Public.generateNumber1_n(10000) + 0.38;
        String b = d + "";

        GPCP06Page gPCP06Page = (GPCP06Page) gPRV02Page.button_classClick("ml20 mr20 GPPL04_searchBtn GPPL04_newlyAddedBtn")//点击【创建预付款】
                .switchToNewIframe(0, GPCP06Page.class).sleepForSeconds(2);

        GPRV02Page gPRV02Page_1 = (GPRV02Page) gPCP06Page.sendInputPlaceholder("请输入客户名称", "兴").sleepForSeconds(1)
                .filterCustomerName("filterCustomerName_item singleLine pointer", "北京科兴公司")
                .sendInputPlaceholder("请输入预付款金额", b).sleepForSeconds(1)
                .selectTimeNoComfir("请选择付款时间")
                .clickSpan("请选择拟收款账号")
                .ul_clickLi(n)
                .clickButton("确定")
                .switchToNewIframe1("GPRV02", GPRV02Page.class).sleepForSeconds(1);

        gPRV02Page_1.sendInputPlaceholder("请输入公司名称", "北京科兴公司")
                .button_classClick("ml20 mr20 GPPL04_searchBtn GPPL04_searchBtn_click")//点击【搜索】
                .sleepForSeconds(3);

        gPRV02Page_1.checkPrepayment(b).sleepForSeconds(1);
    }
}
