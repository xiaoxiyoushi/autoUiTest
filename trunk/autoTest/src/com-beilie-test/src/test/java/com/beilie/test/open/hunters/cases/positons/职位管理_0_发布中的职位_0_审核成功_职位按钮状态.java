package com.beilie.test.open.hunters.cases.positons;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.PositionDetailPage;
import com.beilie.test.open.hunters.pages.PositionManagerPage;
import org.junit.Test;

public class 职位管理_0_发布中的职位_0_审核成功_职位按钮状态 extends HunterBase {
    @Test
    public void test() throws Throwable {
        HomePage homePage = (HomePage) login("13370273781", "1");
        PositionManagerPage positionManagerPage = (PositionManagerPage) homePage
                .clickMenuItem("职位管理", "发布中的职位")
                .sleepForSeconds(1)
                .transfer(PositionManagerPage.class);

        PositionDetailPage detailPage = positionManagerPage.openAuditingPosition1().sleepForSeconds(1);
        PositionDetailPage positionDetailPage = detailPage.assertHasButton("编辑").assertHasButton("预览").assertHasButton("刷新").assertHasButton("暂停").assertHasButton("结束").sleepForSeconds(2);
    }
}
