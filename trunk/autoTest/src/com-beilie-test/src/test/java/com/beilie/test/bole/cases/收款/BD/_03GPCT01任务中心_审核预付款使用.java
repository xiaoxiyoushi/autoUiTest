package com.beilie.test.bole.cases.收款.BD;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPAT.GPAT01Page;
import com.beilie.test.bole.pages.GP.GPCT01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class _03GPCT01任务中心_审核预付款使用 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657224", "1").sleepForSeconds(3);

        GPCT01Page gPCT01Page = (GPCT01Page) bdHomePage
                .clickMenus("\n" +
                        "          流程管理", "任务中心")//点击菜单栏
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(2);
        double d = 10000 + Public.generateNumber1_n(10000) + 0.38;
        String b = d + "";

        GPAT01Page gPAT01Page = (GPAT01Page) gPCT01Page.firstTask("预付款使用")//预付款使用审核的父菜单  点击箭头 展示子菜单
                .secondTask("审核预付款使用").sleepForSeconds(1)
                .clickCarry()
                .switchToNewIframe(0, GPAT01Page.class).sleepForSeconds(2);

        GPCT01Page gPCT01Page_1 = (GPCT01Page) gPAT01Page.clickButton("通过").sleepForSeconds(1)
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(2);

    }
}
