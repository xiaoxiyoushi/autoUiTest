package com.beilie.test.bole.cases.项目部._01项目详情.项目详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import org.junit.Assert;
import org.junit.Test;

public class GP10项目详情_编辑基本信息_行业分类 extends BoleBase {
    @Test
    public void 校对行业分类 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickMenus("\n" +
                        "          项目管理", "我的项目")//点击菜单栏
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GP10Page gP10Page = (GP10Page) gPPM10Page.table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        //获取第二级行业组件的值
        String secondLevelIndustry=gP10Page.Li_click("项目详情").sleepForSeconds(1)
                .span_followingI("基本信息").sleepForSeconds(1)//点击基本信息的编辑按钮
                .label_followingDiv_clickInput("行业分类：").sleepForSeconds(1)//点击行业分类input框
                .getIndustryComponentValue();

        //获取提交后的组件值
        String industry=gP10Page.clickSpan("确定").sleepForSeconds(1)
                .span_followingGetSpan("行业分类：");

        Assert.assertEquals(industry,secondLevelIndustry);


    }
}
