package com.beilie.test.open.hunters.cases.searchs;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CandidateResultPage;
import com.beilie.test.open.hunters.pages.FindCandidatePage;
import com.beilie.test.open.hunters.pages.HomePage;
import com.beilie.test.open.hunters.pages.ResumeDetailPage;
import org.junit.Test;

public class 寻找人选_查看简历 extends HunterBase {

    @Test
    public void 搜索职位会计() throws IllegalAccessException, InstantiationException, InterruptedException {
        HomePage homePage = login("13370273782", "1");
        FindCandidatePage findCandidatePage = (FindCandidatePage) homePage
                .waitForTitleLoaded(10, "谈聘网-首页-开启招聘之旅")
                .clickHeader("寻找人选")
                .transfer(FindCandidatePage.class).sleepForSeconds(2);

        CandidateResultPage resultPage = (CandidateResultPage) findCandidatePage.positionName("会计")
                .clickSearch().sleepForSeconds(1).transfer(CandidateResultPage.class).sleepForSeconds(2);

        ResumeDetailPage resumedetail = (ResumeDetailPage) resultPage.openResume().sleepForSeconds(1).transfer(ResumeDetailPage.class).sleepForSeconds(1);
    }
}

