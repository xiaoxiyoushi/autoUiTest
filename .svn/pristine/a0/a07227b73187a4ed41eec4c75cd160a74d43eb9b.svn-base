package com.beilie.test.open.WwwHome.cases.Bottom;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.FeedbackPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 反馈帮助_意见反馈 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException {
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);
        FeedbackPage feedbackPage=(FeedbackPage)wwwHomePage.feedBack()
                .transfer(FeedbackPage.class).sleepForSeconds(1);

        for(int i=0;i<3;i++){
            String[] arr={"施柚","13370273781","该网站做得很好"};
            feedbackPage.writeInformation(i,arr[i]);
        }

        feedbackPage.clickQueRen().sleepForSeconds(3);
        feedbackPage.checkTiShi();

    }
}
