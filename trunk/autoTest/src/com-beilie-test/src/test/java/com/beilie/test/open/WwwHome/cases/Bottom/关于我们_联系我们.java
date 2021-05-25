package com.beilie.test.open.WwwHome.cases.Bottom;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.ContactUsPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class 关于我们_联系我们 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException {
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);
        ContactUsPage contactUsPage=(ContactUsPage)wwwHomePage.connectUs()
                .switchToNextPage(ContactUsPage.class).sleepForSeconds(1);

        for(int i=0;i<5;i++){
            String[] arr={"施柚","13370273781","aa@bb.cc","上海某某公司","hr"};
            contactUsPage.writeName(i,arr[i]);
        }
        contactUsPage.clickQueRen().sleepForSeconds(3);

    }
}
