package com.beilie.test.open.WwwHome.cases.CheckNews;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.NewsPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import com.beilie.test.seleniums.core.Engine;
import org.junit.Test;

public class 资讯_求职攻略等四个 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException {
        WwwHomePage wwwHomePage = jump().sleepForSeconds(1);
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                NewsPage newsPage=(NewsPage)wwwHomePage.clickRaiders(i,j)
                        .switchToNextPage(NewsPage.class);

                //校验是否loading出资讯页，查找 是否有“热点新闻”四字
                  newsPage.checkZiXun().sleepForSeconds(1);

                //关闭新打开的资讯页
                Engine.close();

                 //回到www首页
                wwwHomePage.activeSelf().sleepForSeconds(1);
            }
        }

    }
}
