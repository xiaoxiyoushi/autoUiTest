package com.beilie.test.open.WwwHome.cases.CheckNews;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.open.WwwHome.pages.NewsPage;
import com.beilie.test.open.WwwHome.pages.WwwHomePage;
import org.junit.Test;

public class 资讯_问卷报告_今日职场热点 extends WwwBase {
    @Test
    public void autoTest()throws IllegalAccessException, InstantiationException, InterruptedException{
        WwwHomePage wwwHomePage =jump().sleepForSeconds(1);

        for(int i=0;i<2;i++) {
            //职场风向标,点击 问卷报告,跳转到资讯页
            NewsPage newsPage = (NewsPage) wwwHomePage.clickSearch(i)
                    .switchToNextPage(NewsPage.class).sleepForSeconds(1);

            //点击第一个热点新闻
            newsPage.clickHotNews1();
            newsPage.clickHotNews2();
            newsPage.clickHotNews3();
            newsPage.clickHotNews4();
            //跳转到www首页
            WwwHomePage wwwHomePage1=(WwwHomePage)newsPage.clickHotNews5()
                    .switchToNextPage(WwwHomePage.class).sleepForSeconds(3);
        }

    }
}
