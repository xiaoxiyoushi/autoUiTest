package com.beilie.test.bole.cases.项目部.人才库.EBFA05我的收藏夹;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA05Page;
import org.testng.annotations.Test;

public class EBFA05我的人才库_人选搜索结果_搜索分组 extends BoleBase {
    @Test(description = "搜索分组")
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗

        EBFA05Page eBFA05Page = (EBFA05Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_myFavorities()//点击二级菜单
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(1);

        String group=eBFA05Page.searchMyGroup();//搜索分组的人选

        eBFA05Page.AssertMyGroup(group);
    }
}
