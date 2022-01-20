package com.beilie.test.bole.cases.项目部._01项目详情.设置项目进程;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class GP10项目详情_上班保证期 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickMenus("\n" +
                        "          项目管理", "我的项目")//点击菜单栏
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        String projectProcess = "上班保证期";
        String process_search = "寻访中";
        int n = gPPM10Page.table_trNumb();
        int randomNumber = Public.generateNumber1(n);

        GP10Page gP10Page = (GP10Page) gPPM10Page.table_td_aClick(randomNumber, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(2);

        String positionName = gP10Page.divClass_b("ivu-col ivu-col-span-18");

        GPPM10Page gPPM10Page_1 = (GPPM10Page) gP10Page
                .clickSpan(process_search).sleepForSeconds(1)
                .Li_click(projectProcess)
                .i_classClick("icon-btn ivu-icon bole icon-close2")//关闭页面
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GP10Page gP10Page_1 = (GP10Page) gPPM10Page_1.a_click("上班保证期中").sleepForSeconds(1)
                .sendInputPlaceholder("请输入项目名称", positionName)
                .clickButton("搜索").sleepForSeconds(2)
                .checkProjectProcess(positionName, projectProcess)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(2);

        gP10Page_1.clickSpan(projectProcess).sleepForSeconds(1)
                .Li_click(process_search).sleepForSeconds(1);
    }
}

