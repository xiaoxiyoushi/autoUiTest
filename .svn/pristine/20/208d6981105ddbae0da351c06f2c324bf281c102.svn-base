package com.beilie.test.open.hunters.cases.Candidate;

import com.beilie.test.open.hunters.core.HunterBase;
import com.beilie.test.open.hunters.pages.CandidatePage;
import com.beilie.test.open.hunters.pages.HomePage;
import org.junit.Test;

public class 人选管理页面 extends HunterBase {
    @Test
    public void 人选管理 ()throws IllegalAccessException, InstantiationException, InterruptedException{
        HomePage homePage = login("13370273782", "1");
        CandidatePage candidate=(CandidatePage) homePage
                .clickHeader("人选管理")
                .transfer(CandidatePage.class).sleepForSeconds(1);
    }
}
