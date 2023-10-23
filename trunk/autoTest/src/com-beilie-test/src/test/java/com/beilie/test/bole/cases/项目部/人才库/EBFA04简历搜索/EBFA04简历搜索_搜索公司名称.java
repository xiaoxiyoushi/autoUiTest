package com.beilie.test.bole.cases.项目部.人才库.EBFA04简历搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import org.testng.annotations.Test;

public class EBFA04简历搜索_搜索公司名称 extends BoleBase {
    @Test(description = "搜索公司名称")
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage.sleepForSeconds(1)
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_resumeSearch()//点击二级菜单
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        eBFA04Page.sendInputPlaceholder("多个公司名称用空格隔开","会计")
                .clickSpan("搜索").sleepForSeconds(3);

        eBFA04Page.a();

    }
}
