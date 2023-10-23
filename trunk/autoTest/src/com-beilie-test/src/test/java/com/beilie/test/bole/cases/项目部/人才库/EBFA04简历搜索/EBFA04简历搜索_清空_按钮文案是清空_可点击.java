package com.beilie.test.bole.cases.项目部.人才库.EBFA04简历搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import org.testng.annotations.Test;

public class EBFA04简历搜索_清空_按钮文案是清空_可点击 extends BoleBase {
    @Test(description = "按钮是清空文案+可点击")
    public void 按钮属性 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_resumeSearch()//点击二级菜单
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        eBFA04Page.waitCandidateSearchResults()
                .clearButton();

    }
}
