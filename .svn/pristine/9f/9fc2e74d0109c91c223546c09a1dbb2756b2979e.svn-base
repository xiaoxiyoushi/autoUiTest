package com.beilie.test.open.WwwHome.cases.CheckHunter;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.ApplicantLoginPage;
import com.beilie.test.open.WwwHome.pages.HunterDetailPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 猎头_校验链接 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException {
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);

        //www首页，点击猎头头像，跳转到猎头详情页面
        HunterDetailPage hunterDetailPage=(HunterDetailPage)wwwHomePage
                .clickHunter().sleepForSeconds(2)
                .transfer(HunterDetailPage.class);

        /*for(int i=0;i<3;i++){
            //www首页，点击猎头头像，跳转到猎头详情页面
            HunterDetailPage hunterDetailPage=(HunterDetailPage)wwwHomePage
                    .clickHunter(i).sleepForSeconds(1)
                    .transfer(HunterDetailPage.class);

            //猎头详情页面，点击 登录按钮，跳转到登录注册页面
            ApplicantLoginPage applicantLoginPage =(ApplicantLoginPage) hunterDetailPage
                    .clickLoginButton().sleepForSeconds(1)
                    .switchToNextPage(ApplicantLoginPage.class);

            //登录注册页面，校验url


            //从登录注册页面 跳转到 猎头详情页面
            HunterDetailPage hunterDetailPage1=(HunterDetailPage)applicantLoginPage
                    .switchToNextPage(HunterDetailPage.class).sleepForSeconds(1);

            //猎头详情页面  点击导航栏 首页,跳转到 www页面
            WwwHomePage wwwHomePage1=(WwwHomePage)hunterDetailPage1.clickShouYe()
                    .transfer(WwwHomePage.class).sleepForSeconds(1);
        }*/

    }
}





