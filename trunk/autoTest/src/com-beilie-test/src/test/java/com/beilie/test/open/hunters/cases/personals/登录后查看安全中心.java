package com.beilie.test.open.hunters.cases.personals;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 登录后查看安全中心 extends HunterBase{
    @Test
    public void test() throws InstantiationException, IllegalAccessException, InterruptedException {
        HomePage homePage = (HomePage) login("shccl@gongkai", "1").transfer(HomePage.class);
        homePage.clickPersonalMenu("安全中心").sleepForSeconds(3);
    }
}
