package com.beilie.test.open.WwwHome.cases.Bottom;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.UserServicesAgreementPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 反馈帮助_用户服务协议 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException {
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);
        UserServicesAgreementPage userServicesAgreementPage=(UserServicesAgreementPage)wwwHomePage
                .userServicesAgreement()
                .switchToNextPage(UserServicesAgreementPage.class)
                .sleepForSeconds(3);
        //校核 用户服务协议页的文字
        userServicesAgreementPage.checkWenZi().sleepForSeconds(3);

    }
}
