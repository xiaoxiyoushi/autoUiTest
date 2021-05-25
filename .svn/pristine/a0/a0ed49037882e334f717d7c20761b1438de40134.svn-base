package com.beilie.test.bole.cases.项目部.人才库.EBFA04简历搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import org.junit.Test;

public class EBFA04简历搜索_搜索公司名称 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickMenus(" 中文简历库", "简历搜索")//点击菜单栏
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        /*eBFA04Page.sendInputPlaceholder("多个公司名称用空格隔开","")
                .clickSpan("搜索").sleepForSeconds(3)*/
        eBFA04Page.a()

                ;

    }
}
