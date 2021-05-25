package com.beilie.test.open.hunters.cases.positons;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.PositionDetailPage;
import com.beilie.test.open.hunters.pages.PositionManagerPage;
import org.junit.Test;

public class 职位管理_1_已暂停的职位 extends HunterBase {
    @Test
    public void test() throws Throwable {
        HomePage homePage = (HomePage) login("13370273781", "1");
        PositionManagerPage positionManagerPage = (PositionManagerPage) homePage
                .clickMenuItem("职位管理", "已暂停的职位")
                .sleepForSeconds(1)
                .transfer(PositionManagerPage.class);
        //已暂停的职位,点击操作：恢复
        positionManagerPage.clickOperating1().clickAudit1()
                .sleepForSeconds(1).assertRestore().sleepForSeconds(3);
    }
}
