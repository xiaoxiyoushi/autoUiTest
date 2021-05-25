package com.beilie.test.open.hunters.cases.personals;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.BasicInfoPage;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 登录后查看基本信息 extends HunterBase{
    @Test
    public void test() throws InstantiationException, IllegalAccessException, InterruptedException {
        HomePage homePage = (HomePage) login("shccl@gongkai", "1").transfer(HomePage.class);
        BasicInfoPage infoPage = (BasicInfoPage) homePage.clickPersonalMenu("基本信息").transfer(BasicInfoPage.class);
        infoPage.assertHasData();
        //infoPage.sleepForSeconds(2);
    }
}
