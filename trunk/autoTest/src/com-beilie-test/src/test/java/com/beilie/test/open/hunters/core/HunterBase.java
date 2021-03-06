package com.beilie.test.open.hunters.core;

import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.LoginPage;
import com.beilie.test.seleniums.core.TestCaseBase;

public class HunterBase extends TestCaseBase {
    protected HomePage login(String userName, String password) throws IllegalAccessException, InstantiationException,InterruptedException {
        LoginPage loginPage = (LoginPage) engine.createPage("http://192.168.5.150:31075/#/", LoginPage.class);
        return (HomePage) loginPage
                .clickAccountLogin().sleepForSeconds(1)
                .userName(userName)
                .password(password)
                .captcha("1234")
                .submit()
                .transfer(HomePage.class);
    }
}
