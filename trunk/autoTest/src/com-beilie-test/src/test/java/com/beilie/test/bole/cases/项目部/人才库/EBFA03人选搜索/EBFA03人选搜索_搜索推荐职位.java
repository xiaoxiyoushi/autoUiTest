package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EB0301Page;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import org.junit.Test;

public class EBFA03人选搜索_搜索推荐职位 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        String recommendJob="卖麦芽糖的";//搜索的当前职位名称
        EBFA08Page eBFA08Page=(EBFA08Page)eBFA03Page.sendInputPlaceholder("多个推荐职位用空格隔开",recommendJob)
        .clickSpan("搜索").sleepForSeconds(3)
        .clickAvatar(0)//点击头像名称
        .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        EB0301Page eB0301Page=(EB0301Page)eBFA08Page
        .clickLi("推荐报告")//切换 推荐报告栏
        .sleepForSeconds(2)
        .click_Recommend()//点击  查看报告
        .switchToNewIframe(1, EB0301Page.class).sleepForSeconds(2);

        eB0301Page.Span_Value(recommendJob);//获取到值 就验证成功；
    }
}

