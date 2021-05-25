package com.beilie.test.open.applicants.cases.logins;

import com.beilie.test.open.applicants.core.ApplicantBase;
import com.beilie.test.open.applicants.pages.AplHomePage;
import org.junit.Test;

public class 成功登录 extends ApplicantBase {
    @Test
    public void 成功登录() throws IllegalAccessException, InstantiationException, InterruptedException {
        AplHomePage homePage = login("68657207", "888888");
        homePage.assertLoginSuccess().sleepForSeconds(3);
    }
}
