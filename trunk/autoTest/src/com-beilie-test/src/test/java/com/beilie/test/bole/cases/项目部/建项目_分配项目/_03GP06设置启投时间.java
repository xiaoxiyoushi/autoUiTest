package com.beilie.test.bole.cases.项目部.建项目_分配项目;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP06Page;
import com.beilie.test.bole.pages.GP.GPCT01Page;
import org.junit.Assert;
import org.testng.annotations.Test;

public class _03GP06设置启投时间 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException{
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPCT01Page gPCT01Page = (GPCT01Page) bdHomePage
                .clickFirstMenu_liuchen().sleepForSeconds(1)
                .clickSecondMenu_center()
                .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);

          //String taskName=gPCT01Page
                //.firstTask("创建项目集合-${customerName}").sleepForSeconds(1)//点击第一级任务名称的下拉icon
                //.secondTask("设置启投时间").sleepForSeconds(1)//点击第二级任务名称
                //.getTaskName();//获取任务名称

        //taskName=taskName.substring(7);//获取项目名称-客户名称

        GP06Page gP06Page=(GP06Page)gPCT01Page
                .clickCarry()//点击执行
                .switchToNewIframe(0, GP06Page.class).sleepForSeconds(2);

        GPCT01Page gPCT01Page1=(GPCT01Page)gP06Page.selectTime()//选择当天时间 晚上23点
       .clickSubmit()//提交
       .switchToNewIframe1("GPCT01", GPCT01Page.class).sleepForSeconds(1);

        //String taskName1=gPCT01Page1.firstTask("创建团队项目-${customerName}").sleepForSeconds(1)//点击第一级任务名称的下拉icon
                //.secondTask("设置项目操作顾问").sleepForSeconds(1)//点击第二级任务名称
                //.getTaskName();//获取任务名称

        //taskName1=taskName1.substring(9);//获取项目名称-客户名称

        //Assert.assertEquals(taskName,taskName1);
    }
}
