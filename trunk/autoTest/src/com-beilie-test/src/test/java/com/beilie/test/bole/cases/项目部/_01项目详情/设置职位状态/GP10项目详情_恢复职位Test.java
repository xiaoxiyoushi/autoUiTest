package com.beilie.test.bole.cases.项目部._01项目详情.设置职位状态;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GC18Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

public class GP10项目详情_恢复职位Test extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject()//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        int n = gPPM10Page.table_trNumb();
        int randomNumber = Public.generateNumber1(n);

        GP10Page gP10Page = (GP10Page) gPPM10Page.table_td_aClick(randomNumber, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        String positionName = gP10Page.spanClass("project-name");

        GPPM10Page gPPM10Page_1 = (GPPM10Page) gP10Page
                .divClass("ivu-dropdown-rel").sleepForSeconds(1)//点击【更多操作】
                .ulClass_li("ivu-dropdown-menu",2)//选中恢复
                .i_classClick("icon-btn ivu-icon bole icon-close2")//关闭页面
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GC18Page gC18Page = (GC18Page) gPPM10Page_1
                .sendInputPlaceholder("请输入项目名称", positionName)
                .clicksearch().sleepForSeconds(2)//点击搜索
                .table_td_aClick(0, 1)
                .switchToNewIframe(0, GC18Page.class).sleepForSeconds(2);

        gC18Page.Li_click("职位概览").sleepForSeconds(2)
                .checkPositionStatus(positionName,"运作中").sleepForSeconds(2);

    }
}

