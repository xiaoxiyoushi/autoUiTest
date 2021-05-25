package com.beilie.test.open.hunters.cases.logins;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 成功登录 extends HunterBase {
    @Test
    public void 成功登录() throws IllegalAccessException, InstantiationException, InterruptedException {
        HomePage homePage = login("shccl@gongkai", "1");
        homePage.assertLoginSuccess();
    }
}
