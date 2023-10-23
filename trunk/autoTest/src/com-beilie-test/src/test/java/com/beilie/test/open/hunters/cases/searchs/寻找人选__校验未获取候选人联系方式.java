package com.beilie.test.open.hunters.cases.searchs;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.*;
import org.junit.Test;

public class 寻找人选__校验未获取候选人联系方式 extends HunterBase {
    @Test
    public void 判断是否获取联系方式 () throws IllegalAccessException, InstantiationException, InterruptedException{
        HomePage homePage=(HomePage)login("13370273782","1");
        FindCandidatePage findCandidatePage=(FindCandidatePage) homePage
                //.waitForTitleLoaded(10,"谈聘网-首页-开启招聘之旅")
                .clickHeader("寻找人选")
                .transfer(FindCandidatePage.class).sleepForSeconds(2);

        CandidateResultPage resultPage=(CandidateResultPage) findCandidatePage.positionName("ui设计师")
                .clickSearch().sleepForSeconds(1).transfer(CandidateResultPage.class).sleepForSeconds(1);

        ResumeDetailPage resumeDetail=(ResumeDetailPage) resultPage.openResume().sleepForSeconds(1).transfer(ResumeDetailPage.class).sleepForSeconds(1);
        resumeDetail.getPhone().sleepForSeconds(1).assertNoConnectAlert();
    }
}
