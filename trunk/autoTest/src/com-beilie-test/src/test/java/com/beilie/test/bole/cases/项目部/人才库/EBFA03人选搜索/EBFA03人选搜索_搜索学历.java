package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.junit.Test;

public class EBFA03人选搜索_搜索学历 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        String xueLi="大专";
        eBFA03Page
                .clickSpan("学历下限").sleepForSeconds(1)//点击学历下限框
                .Li_click(xueLi)//点击大专
                .clickSpan("学历上限").sleepForSeconds(1)//点击学历上限框
                .span_parentDiv_parentDiv_followingGetDiv("学历上限",xueLi)//点击大专
                .clickSpan("搜索").sleepForSeconds(3)//点击搜索

                .hoverAvatar(0).sleepForSeconds(2)
                .checkCandidateCard().sleepForSeconds(2);
    }
}
