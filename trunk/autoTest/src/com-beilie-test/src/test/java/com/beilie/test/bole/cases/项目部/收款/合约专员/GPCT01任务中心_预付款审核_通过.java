package com.beilie.test.bole.cases.项目部.收款.合约专员;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPAT06Page;
import com.beilie.test.bole.pages.GP.GPCT01Page;
import org.junit.Test;

public class GPCT01任务中心_预付款审核_通过 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68659136", "888888").sleepForSeconds(3);

        GPCT01Page gPCT01Page = (GPCT01Page) bdHomePage
                .clickMenus(" 流程管理", "任务中心")//点击菜单栏
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);

        GPAT06Page gPAT06Page = (GPAT06Page) gPCT01Page.task("//div[@class=\"tashList_list\"]/div[10]//i").sleepForSeconds(1)//预付款审核的父菜单  点击箭头 展示子菜单
                .secondTask("预付款审核").sleepForSeconds(1)
                .clickCarry()
                .switchToNewIframe(0, GPAT06Page.class).sleepForSeconds(2);

        GPCT01Page gPCT01Page_1 = (GPCT01Page)gPAT06Page.scrollBar()
                .clickSpan("有退款一半")
                .clickButton("通过")
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);
    }
}
