package com.beilie.test.open.hunters.cases.searchs;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CandidateResultPage;
import com.beilie.test.open.hunters.pages.FindCandidatePage;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.ResumeDetailPage;
import org.junit.Test;

public class 寻找人选__给获取联系方式人选_分组 extends HunterBase {
    @Test
    public void 已经获取联系方式() throws IllegalAccessException, InstantiationException, InterruptedException {
        HomePage homePage = (HomePage) login("13370273781", "1");
        FindCandidatePage findCandidatePage = (FindCandidatePage) homePage
                .waitForTitleLoaded(10, "谈聘网-首页-开启招聘之旅")
                .clickHeader("寻找人选")
                .transfer(FindCandidatePage.class)
                .sleepForSeconds(2);

        CandidateResultPage resultPage = (CandidateResultPage) findCandidatePage.positionName("ui设计师")
                .clickSearch().sleepForSeconds(1)
                .transfer(CandidateResultPage.class)
                .sleepForSeconds(1);

        ResumeDetailPage resumeDetail = (ResumeDetailPage) resultPage
                .openNoConnectResume()
                .sleepForSeconds(1)
                .transfer(ResumeDetailPage.class);

        resumeDetail.getPhone()
                .sleepForSeconds(1)
                .grouping()
                .sleepForSeconds(6);
    }
}
