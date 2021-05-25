package com.beilie.test.open.hunters.cases.homes;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CreatePositionPage;
import org.junit.Test;

public class 点击创建职位跳转到页面 extends HunterBase {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, InterruptedException {
        CreatePositionPage positionPage = (CreatePositionPage) login("shccl@gongkai", "1")
                .clickHeader("创建职位")
                .transfer(CreatePositionPage.class);
        positionPage.assertLoaded();

    }
}
