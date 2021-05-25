package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.junit.Test;

public class EBFA03人选搜索_搜索地点 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        eBFA03Page.label_followingDiv_input("地点：", "白")
        .label_followingDiv_input("地点：", "云区")
                .label_followingDiv_Input_down("地点：")
                .label_followingDiv_Input_enrter("地点：")
        ;
    }
}
