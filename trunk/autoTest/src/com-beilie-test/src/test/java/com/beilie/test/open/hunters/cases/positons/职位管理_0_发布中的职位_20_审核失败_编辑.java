package com.beilie.test.open.hunters.cases.positons;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CreatePositionPage;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.PositionDetailPage;
import com.beilie.test.open.hunters.pages.PositionManagerPage;
import org.junit.Test;

public class 职位管理_0_发布中的职位_20_审核失败_编辑 extends HunterBase {
    @Test
    //发布中的职位，有审核失败的职位
    public void test() throws Throwable {
        HomePage homePage = (HomePage) login("13370273781", "1");
        PositionManagerPage positionManagerPage = (PositionManagerPage) homePage
                .clickMenuItem("职位管理", "发布中的职位")
                .sleepForSeconds(1)
                .transfer(PositionManagerPage.class);
        //渠道状态:审核失败，编辑职位
        CreatePositionPage createPositionPage =(CreatePositionPage)positionManagerPage.clickOperating().sleepForSeconds(1)
                .clickEdit()
                .transfer(CreatePositionPage.class).sleepForSeconds(1);
        //创建职位页面，点击【提交】
        PositionManagerPage tiJiaoZhiWei=(PositionManagerPage)createPositionPage
                .submitPosition1().sleepForSeconds(1).clickQueDing().sleepForSeconds(3)
                .transfer(PositionManagerPage.class);
    }
}


