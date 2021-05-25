package com.beilie.test.open.WwwHome.cases.CheckAllPosition;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.ApplicantLoginPage;
import com.beilie.test.open.WwwHome.pages.PositionDetailPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import com.beilie.test.seleniums.core.Engine;
import org.junit.Test;

public class 职位_01校验所有职位里链接的跳转 extends WwwBase {
    @Test
    public void autoTest() throws Exception {
        WwwHomePage wwwHomePage=jump().sleepForSeconds(1);

        for(int i=0;i<6;i++) {
            for (int j = 1; j < 7; j++) {
                PositionDetailPage positionDetailPage=(PositionDetailPage)wwwHomePage
                        .clickPosition().sleepForSeconds(1)
                        .chooseIndustry(i).sleepForSeconds(1)
                        .clickInternetPosition(j).sleepForSeconds(1)
                        .switchToNextPage(PositionDetailPage.class);

                   wwwHomePage.activeSelf();
                   Engine.close();

                   positionDetailPage.activeSelf();

                //职位详情页面，点击 收藏职位，跳转到 登录注册页面
                ApplicantLoginPage  applicantLoginPage = (ApplicantLoginPage) positionDetailPage
                        .clickCollection().sleepForSeconds(1)
                        .switchToNextPage1(ApplicantLoginPage.class).sleepForSeconds(1);

                //Engine.close();

                //applicantLoginPage.activeSelf().transfer(ApplicantLoginPage.class);

                //登录注册页面，校验url
                //applicantLoginPage.checkCurrentUrl();

                //关闭 登录注册页面
                //Engine.close();

                //回到职位详情页面，点击 申请职位，跳转到 登录注册页面
                ApplicantLoginPage  applicantLoginPage1 = (ApplicantLoginPage)
                        positionDetailPage.activeSelf().applyPosition()
                                .switchToNextPage(ApplicantLoginPage.class);

                //登录注册页面，校验url
                //applicantLoginPage1.checkCurrentUrl();

                //关闭 登录注册页面
                Engine.close();

                //回到职位详情页面，点击 登录，跳转到 登录注册页面
                ApplicantLoginPage  applicantLoginPage2 = (ApplicantLoginPage)
                    positionDetailPage.activeSelf().clickLogin()
                        .switchToNextPage(ApplicantLoginPage.class);

                //登录注册页面，校验url
                applicantLoginPage2.checkCurrentUrl();

                //关闭 登录注册页面
                Engine.close();

                //回到职位详情页面，点击 注册，跳转到 登录注册页面
                ApplicantLoginPage  applicantLoginPage3 = (ApplicantLoginPage)
                        positionDetailPage.activeSelf().clickRegistere()
                                .switchToNextPage(ApplicantLoginPage.class);

                //登录注册页面，校验url
                applicantLoginPage3.checkCurrentUrl();

                //关闭 登录注册页面
                Engine.close();

                positionDetailPage.activeSelf().sleepForSeconds(1);
           }
        }

    }
 }
