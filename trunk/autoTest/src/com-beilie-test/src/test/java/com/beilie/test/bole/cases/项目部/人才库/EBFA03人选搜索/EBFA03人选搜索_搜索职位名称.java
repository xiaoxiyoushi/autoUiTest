package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.junit.Test;

public class EBFA03人选搜索_搜索职位名称 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        String job="软件工程师";//搜索的当前职位名称
        eBFA03Page.sendInputPlaceholder("多个职位名称用空格隔开",job)
        .checkCurrent(1)//勾选 目前职位的勾选框
        .clickSpan("搜索").sleepForSeconds(3)
        .checkJob(job).sleepForSeconds(2);//校对职位名称

    }
}
