package com.beilie.test.bole.cases.项目部.收款.BD;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP07Page;
import com.beilie.test.bole.pages.GP.GPXX.GPRV02Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class _02GPRV02客户预付款_确认预付款 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657224", "1").sleepForSeconds(3);

        GPRV02Page gPRV02Page = (GPRV02Page) bdHomePage
                .clickMenus(" 客户管理", "客户预付款")//点击菜单栏
                .switchToNewIframe1("GPRV02", GPRV02Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(2);
        double d = 10000 + Public.generateNumber1_n(10000) + 0.38;
        String b = d + "";
        double i = Public.generateNumber1_n(10000) + 0.49;
        String actualReceiveMony = i + "";

        gPRV02Page.sendInputPlaceholder("请输入公司名称", "北京科兴公司")
                .button_classClick("ml20 mr20 GPPL04_searchBtn GPPL04_searchBtn_click")//点击【搜索】
                .sleepForSeconds(1);

        String prePayment = gPRV02Page.paymentClick();

        GPCP07Page gPCP07Page = (GPCP07Page) gPRV02Page
                .switchToNewIframe(0, GPCP07Page.class).sleepForSeconds(2);

        GPRV02Page gPRV02Page_1 = (GPRV02Page) gPCP07Page.selectTime_Many("请选择实际付款时间", "实际付款信息")//实际付款信息
                .spanTitle_followingDiv_input("实际收款金额", actualReceiveMony)
                .clickSpan("选择实际收款账号").sleepForSeconds(1)
                .zhangHao("tl ml20 ivu-row mt20", "中国好账户")
                .clickButton("提交")
                .switchToNewIframe1("GPRV02", GPRV02Page.class).sleepForSeconds(1);

        gPRV02Page_1.button_classClick("ml20 mr20 GPPL04_searchBtn GPPL04_searchBtn_click")//点击【搜索】
                .sleepForSeconds(1);

        gPRV02Page_1.checkConfirmPrepayment(prePayment, actualReceiveMony).sleepForSeconds(1);
    }
}
