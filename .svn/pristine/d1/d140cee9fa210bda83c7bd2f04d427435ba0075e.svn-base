package com.beilie.test.open.hunters.cases.searchs;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.FindCandidatePage;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 寻找人选_5_期望地点 extends HunterBase {
    @Test
    public void 期望地点() throws IllegalAccessException, InstantiationException, InterruptedException{
        HomePage homePage = login("13370273782", "1");
        FindCandidatePage findCandidatePage = (FindCandidatePage) homePage
                .waitForTitleLoaded(10, "谈聘网-首页-开启招聘之旅")
                .clickHeader("寻找人选")
                .transfer(FindCandidatePage.class).sleepForSeconds(2);

        findCandidatePage.expectedLocation().expectationLocation1()
                .expectationLocation2().submitExpectationLocation().sleepForSeconds(2);
    }
}
