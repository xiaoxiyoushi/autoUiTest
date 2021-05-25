package com.beilie.test.open.hunters.cases.logins;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 登出 extends HunterBase{
    @Test
    public void test() throws InstantiationException, IllegalAccessException, InterruptedException {
        HomePage homePage = (HomePage) login("shccl@gongkai", "1").transfer(HomePage.class);
        homePage.clickQuit().sleepForSeconds(3);
    }
}
