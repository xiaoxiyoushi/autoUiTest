package com.beilie.test.open.hunters.cases.positons;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.PositionDetailPage;
import com.beilie.test.open.hunters.pages.PositionManagerPage;
import org.junit.Test;

public class 职位管理_0_发布中的职位_1_审核中_职位按钮状态 extends HunterBase {
    @Test
    public void test() throws Throwable {
        HomePage homePage = (HomePage) login("13370273781", "1");
        PositionManagerPage positionManagerPage = (PositionManagerPage) homePage
                .clickMenuItem("职位管理", "发布中的职位")
                .sleepForSeconds(1)
                .transfer(PositionManagerPage.class);

        PositionDetailPage detailPage = positionManagerPage.openAuditingPosition().sleepForSeconds(2);
        PositionDetailPage positionDetailPage = detailPage.assertHasButton("预览").assertHasButton("暂停").assertHasButton("结束").sleepForSeconds(2);


        //PositionDetailPage detailPage = positionManagerPage.openAuditingPosition().sleepForSeconds(2).assertHasButton("预览");
        //PositionDetailPage positionDetailPage = detailPage.assertHasButton("预览");
    }
}




