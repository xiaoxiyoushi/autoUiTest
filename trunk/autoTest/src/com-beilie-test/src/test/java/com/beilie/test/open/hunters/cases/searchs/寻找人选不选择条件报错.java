package com.beilie.test.open.hunters.cases.searchs;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.FindCandidatePage;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 寻找人选不选择条件报错 extends HunterBase {
    @Test
    public void 无搜索条件报错() throws IllegalAccessException, InstantiationException, InterruptedException {
        HomePage homePage = login("shccl@gongkai", "1");
        FindCandidatePage findCandidatePage = (FindCandidatePage) homePage
                .waitForTitleLoaded(10, "谈聘网-首页-开启招聘之旅")
                .clickHeader("寻找人选")
                .transfer(FindCandidatePage.class).sleepForSeconds(1);

        findCandidatePage.clickSearch().assertNoConditionAlert();
    }
}
