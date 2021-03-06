package com.beilie.test.bole.cases.项目部.建项目_分配项目;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.GP.GPXX.GP05Page;
import com.beilie.test.bole.pages.GP.GPCT01Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import org.junit.Assert;
import org.junit.Test;

public class _04GP05设置项目操作顾问 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);
        //BdHomePage bdHomePage = login("68657207", "1").sleepForSeconds(3);

        GPCT01Page gPCT01Page = (GPCT01Page) bdHomePage
                .clickClientManger("任务中心", 6)
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);

        /*GP05Page gP05Page=(GP05Page) gPCT01Page.firstTask("创建团队项目-${customerName}").sleepForSeconds(1)//点击第一级任务名称的下拉icon
                .secondTask("设置项目操作顾问").sleepForSeconds(1)//点击第二级任务名称
                .clickCarry()//点击执行
                .switchToNewIframe(0, GP05Page.class).sleepForSeconds(2);

        GPCT01Page gPCT01Page1=(GPCT01Page)gP05Page.tickAllMember()//勾选全部成员
        .tickSubmit()//点击提交
        .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1)
        ;*/

        String taskName = gPCT01Page.firstTask("创建团队项目-${customerName}").sleepForSeconds(1)//点击第一级任务名称的下拉icon
                .secondTask("设置项目操作顾问").sleepForSeconds(1)//点击第二级任务名称
                .getTaskName();//获取任务名称

        String projectName = taskName.split("-")[1];

        GP05Page gP05Page = (GP05Page) gPCT01Page.clickCarry()//点击执行
                .switchToNewIframe(0, GP05Page.class).sleepForSeconds(1);

        /*GPCT01Page gPCT01Page1=(GPCT01Page)gP05Page.tickAllMember()//勾选全部成员
                .tickSubmit()//点击提交
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);

        BdHomePage bdHomePage1=(BdHomePage)gPCT01Page1.switchOutIframe(BdHomePage.class);
        ;
        bdHomePage1.clickMenus(" 项目管理","我的项目");*/

        BdHomePage bdHomePage1 = (BdHomePage) gP05Page.tickAllMember()//勾选全部成员
                .tickSubmit()//点击提交
                .switchOutIframe(BdHomePage.class).sleepForSeconds(1);

        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage1
                .clickMenus("\n" +
                        "          项目管理", "我的项目")//点击菜单栏
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(2);

        String getProjectName = gPPM10Page.selectName(0)//选择项目名称
                .inputClientName("请输入项目名称", projectName)//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .getProjectName();

        Assert.assertEquals(projectName, getProjectName);

    }
}
