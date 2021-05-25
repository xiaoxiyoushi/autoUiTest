package com.beilie.test.open.hunters.cases.searchs;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CandidateResultPage;
import com.beilie.test.open.hunters.pages.FindCandidatePage;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 寻找人选_7_组合搜索_职位名称_学历_期望职能_期望地点 extends HunterBase {
    @Test
    public void zuHe01() throws IllegalAccessException, InstantiationException, InterruptedException{
        寻找人选_4_期望职能 zn=new 寻找人选_4_期望职能();
        HomePage homePage = login("13370273782", "1");
        FindCandidatePage findCandidatePage = (FindCandidatePage) homePage
                .waitForTitleLoaded(10, "谈聘网-首页-开启招聘之旅")
                .clickHeader("寻找人选")
                .transfer(FindCandidatePage.class).sleepForSeconds(3);
        CandidateResultPage resultPage = (CandidateResultPage) findCandidatePage.positionName("java工程师")
                .degree().sleepForSeconds(1).degreeBachelor().sleepForSeconds(1)

                .expectationFunction()
                .expectationFunctionProfessional()
                .expectationFunctionIt().expectationFunctionEngineer()
                .submitExpectationFunction().sleepForSeconds(1)

                .expectedLocation().expectationLocation1()
                .expectationLocation2().submitExpectationLocation()

                .clickSearch().sleepForSeconds(1).transfer(CandidateResultPage.class).sleepForSeconds(1);
    }
}
