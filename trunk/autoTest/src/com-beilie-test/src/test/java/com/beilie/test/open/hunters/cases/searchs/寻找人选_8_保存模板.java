package com.beilie.test.open.hunters.cases.searchs;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CandidateResultPage;
import com.beilie.test.open.hunters.pages.FindCandidatePage;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 寻找人选_8_保存模板 extends HunterBase {
    @Test
    public void 搜索模板() throws IllegalAccessException, InstantiationException, InterruptedException{
        HomePage homePage = login("13370273782", "1");
        FindCandidatePage findCandidatePage = (FindCandidatePage) homePage
                //.waitForTitleLoaded(10, "谈聘网-首页-开启招聘之旅")
                .clickHeader("寻找人选")
                .transfer(FindCandidatePage.class).sleepForSeconds(2);

        findCandidatePage.positionName("java设计师").saveSearch().templateName()
                .submitTemplate().sleepForSeconds(1);
    }
}
