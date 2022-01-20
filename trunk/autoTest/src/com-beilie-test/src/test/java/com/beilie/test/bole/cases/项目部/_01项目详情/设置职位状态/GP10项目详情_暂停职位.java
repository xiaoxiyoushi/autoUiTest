package com.beilie.test.bole.cases.项目部._01项目详情.设置职位状态;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GC18Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class GP10项目详情_暂停职位 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickMenus("\n" +
                        "          项目管理", "我的项目")//点击菜单栏
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        int n = gPPM10Page.table_trNumb();
        int randomNumber = Public.generateNumber1(n);

        GP10Page gP10Page = (GP10Page) gPPM10Page.table_td_aClick(randomNumber, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        String positionName = gP10Page.divClass_b("ivu-col ivu-col-span-18");

        GPPM10Page gPPM10Page_1 = (GPPM10Page) gP10Page
                .i_classClick("ivu-icon ivu-icon-ios-more").sleepForSeconds(1)
                .Li_click("暂停\n" +
                        "              ")
                .i_classClick("icon-btn ivu-icon bole icon-close2")//关闭页面
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GC18Page gC18Page = (GC18Page) gPPM10Page_1
                .sendInputPlaceholder("请输入项目名称", positionName)
                .clickButton("搜索").sleepForSeconds(2)
                .table_td_aClick(0, 1)
                .switchToNewIframe(0, GC18Page.class).sleepForSeconds(2);

        gC18Page.Li_click("职位概览").sleepForSeconds(2)
                .checkPositionStatus(positionName,"已暂停").sleepForSeconds(2);

    }
}
