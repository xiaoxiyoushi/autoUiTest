package com.beilie.test.bole.cases.工资月报;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.ESUP.ESUP01Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import org.testng.annotations.Test;

import java.util.Map;

public class 业务月报_员工级别 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException,Exception {
        BdHomePage bdHomePage = login("xinchou_userName","xinchou_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        ESUP01Page eSUP01Page = (ESUP01Page) bdHomePage
                .clickMenu("firstMenu_employeeInform","secondMenu_employeeInform")
                .switchToNewIframe1("ESUP01", ESUP01Page.class).sleepForSeconds(2);

        eSUP01Page.editInform()
        ;
    }
}

