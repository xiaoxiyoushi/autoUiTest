package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.testng.annotations.Test;

public class EBFA03人选搜索_清空 extends BoleBase {
    @Test(description = "按钮是清空文案+可点击")
    public void 按钮属性() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage.sleepForSeconds(1)
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_candidateSearch()//点击二级菜单：人选搜索
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        eBFA03Page.waitCandidateSearchResults()
                .clearButton();

    }
}
//40084002