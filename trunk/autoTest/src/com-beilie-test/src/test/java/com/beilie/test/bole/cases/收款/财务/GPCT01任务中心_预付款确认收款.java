package com.beilie.test.bole.cases.收款.财务;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCT01Page;
import com.beilie.test.bole.pages.GP.GPXX.GP38Page;
import org.junit.Test;

public class GPCT01任务中心_预付款确认收款 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657214", "1").sleepForSeconds(3);

        GPCT01Page gPCT01Page = (GPCT01Page) bdHomePage
                .clickMenus("\n" +
                        "          流程管理", "任务中心")//点击菜单栏
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);

        GP38Page gP38Page = (GP38Page) gPCT01Page.firstTask("预付款收款")//预付款审核的父菜单  点击箭头 展示子菜单
                .secondTask("确认收款").sleepForSeconds(1)
                .clickCarry()
                .switchToNewIframe(0, GP38Page.class).sleepForSeconds(1);

        GPCT01Page gPCT01Page_1 = (GPCT01Page)gP38Page.selectTime("请选择实际收款时间")//选择实际收款时间
                .button_classClick("fl clearfix receBtn")//点击【收款】按钮
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);
    }
}
