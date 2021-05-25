package com.beilie.test.open.WwwHome.cases.Bottom;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.IntroductionPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 关于我们_谈聘网简介 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException {
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);

        IntroductionPage introductionPage=(IntroductionPage)wwwHomePage
                .clickIntroduction()
                .switchToNextPage(IntroductionPage.class).sleepForSeconds(3);

        introductionPage.checkCurrentUrl();
    }
}
