package com.beilie.test.open.WwwHome.cases.CheckNews;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.MediaCooperationPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 资讯_媒体合作 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException{
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);

        MediaCooperationPage mediaCooperationPage=(MediaCooperationPage)wwwHomePage.clickSearch(2)
                .transfer(MediaCooperationPage.class).sleepForSeconds(1);
        mediaCooperationPage.writeName("施柚")
                .writeMobile("13370273781")
                .writeEmile("aa@bb.cc")
                .writeCompanyName("上海某某公司")
                .writePosition("hr")
                .clickQueRen().sleepForSeconds(1)
                .checkTiShi().sleepForSeconds(3);

    }
}





