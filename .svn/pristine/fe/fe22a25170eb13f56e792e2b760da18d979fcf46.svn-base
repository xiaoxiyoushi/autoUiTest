package com.beilie.test.open.WwwHome.cases.Bottom;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.CommonProblemPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 反馈帮助_常见问题 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException {
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);
        CommonProblemPage commonProblemPage=(CommonProblemPage)wwwHomePage.commonProblem()
                .switchToNextPage(CommonProblemPage.class).sleepForSeconds(1);
        //校核常见问题页的 文字
        commonProblemPage.checkWenZi().sleepForSeconds(3);
    }
}
