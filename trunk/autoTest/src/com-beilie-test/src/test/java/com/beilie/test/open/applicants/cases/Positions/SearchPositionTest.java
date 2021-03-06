package com.beilie.test.open.applicants.cases.Positions;

import com.beilie.test.open.applicants.core.ApplicantBase;
import com.beilie.test.open.applicants.pages.AplHomePage;
import com.beilie.test.open.applicants.pages.AppPositionDetailPage;
import com.beilie.test.open.applicants.pages.FindPositionPage;
import org.junit.Test;

public class SearchPositionTest extends ApplicantBase {
    @Test
    public void 申请收藏职位()throws Throwable{
        AplHomePage aplHomePage = login("13370273780", "1");
        FindPositionPage findPositionPage=(FindPositionPage)aplHomePage
               // .clickMenuItem("职位", "职位搜索")
                .transfer(FindPositionPage.class).sleepForSeconds(1);

        //搜索web前端
        AppPositionDetailPage searchPositionPage=(AppPositionDetailPage)findPositionPage.deleteTiaojian().sleepForSeconds(1)
                .writeKeyWords("web前端").clickSearch().sleepForSeconds(1).clickPosition().sleepForSeconds(1)
                .switchToNextPage(AppPositionDetailPage.class).sleepForSeconds(1);

        //进入职位详情页面,校验职位是否包含前端，点击申请职位
       //AppPositionDetailPage positionDetailPage=searchPositionPage.ApplyPosition().sleepForSeconds(3);
    }
}


