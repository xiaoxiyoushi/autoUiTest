package com.beilie.test.open.hunters.cases.searchs;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CandidateResultPage;
import com.beilie.test.open.hunters.pages.FindCandidatePage;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 寻找人选结果打开条件面板 extends HunterBase {
    @Test
    public void 验证寻找人选结果页面是否可以打开条件面板() throws IllegalAccessException, InstantiationException, InterruptedException {
        HomePage homePage = login("shccl@gongkai", "1");
        FindCandidatePage findCandidatePage = (FindCandidatePage) homePage
                //.waitForTitleLoaded(10, "谈聘网-首页-开启招聘之旅")
                .clickHeader("寻找人选")
                .transfer(FindCandidatePage.class).sleepForSeconds(3);
        CandidateResultPage resultPage = (CandidateResultPage) findCandidatePage.keywords("程序员").clickSearch().sleepForSeconds(3)
                .transfer(CandidateResultPage.class);
        resultPage.expendConditionPanel().assertConditionPanelDisplayed();
    }
}
