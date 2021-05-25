package com.beilie.test.open.applicants.core;

import com.beilie.test.open.applicants.pages.AplHomePage;
import com.beilie.test.open.hunters.pages.LoginPage;
import com.beilie.test.seleniums.core.TestCaseBase;

public class ApplicantBase extends TestCaseBase {
    protected AplHomePage login(String userName, String password) throws IllegalAccessException, InstantiationException {
        LoginPage loginPage = (LoginPage) engine.createPage("http://192.168.5.150:30996/#/home", LoginPage.class);
        return (AplHomePage)loginPage
                .clickAccountLogin()
                .userName(userName)
                .password(password)
                .captcha("1234")
                .submit()
                .transfer(AplHomePage.class);
    }
}
