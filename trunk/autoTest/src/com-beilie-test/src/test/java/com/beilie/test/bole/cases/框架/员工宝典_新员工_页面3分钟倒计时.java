package com.beilie.test.bole.cases.框架;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import org.testng.annotations.Test;

public class 员工宝典_新员工_页面3分钟倒计时 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException,Exception {
        BdHomePage bdHomePage = login_ceshi("newAccount_userName", "password").sleepForSeconds(3);

        bdHomePage.newEmployee();

    }
}
