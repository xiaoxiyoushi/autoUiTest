package com.beilie.test.open.hunters.cases.positons;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.PositionDetailPage;
import com.beilie.test.open.hunters.pages.PositionManagerPage;
import org.junit.Test;

    public class 职位管理_0_发布中的职位_2_审核失败_职位按钮状态 extends HunterBase {
    @Test
    public void test() throws Throwable {
        HomePage homePage = (HomePage) login("13370273781", "1");
        PositionManagerPage positionManagerPage = (PositionManagerPage) homePage
                .clickMenuItem("职位管理", "发布中的职位")
                .sleepForSeconds(1)
                .transfer(PositionManagerPage.class);

        PositionDetailPage detailPage = positionManagerPage.openAuditingPosition2().sleepForSeconds(1);
        PositionDetailPage positionDetailPage = detailPage.assertHasButton("编辑").assertHasButton("预览").assertHasButton("暂停").assertHasButton("结束")
                //校验有：审核失败原因
                .assertFaileReason()
                //校验 渠道状态：审核失败
                .assertChannelStatus().sleepForSeconds(2);
    }
}
