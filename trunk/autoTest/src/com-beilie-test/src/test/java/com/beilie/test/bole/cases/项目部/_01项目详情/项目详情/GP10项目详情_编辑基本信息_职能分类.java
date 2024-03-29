package com.beilie.test.bole.cases.项目部._01项目详情.项目详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import org.junit.Assert;
import org.testng.annotations.Test;

public class GP10项目详情_编辑基本信息_职能分类 extends BoleBase {
    //@Test
    public void 校对职能分类 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject()//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GP10Page gP10Page = (GP10Page) gPPM10Page.table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        //获取第二级职能组件的值
        String functionValue = gP10Page.Li_click("项目详情").sleepForSeconds(1)
                                       .span_followingI("基本信息").sleepForSeconds(1)//点击基本信息的编辑按钮
                                       .label_followingDiv_clickInput("职能分类：").sleepForSeconds(1)//点击行业分类input框
                                       .getfunctionComponentValue();

        //获取提交后的组件值
        String function=gP10Page.clickSpan("确定").sleepForSeconds(1)
                                .span_followingGetSpan("职能分类：");

        Assert.assertEquals(functionValue,function);

    }
}
