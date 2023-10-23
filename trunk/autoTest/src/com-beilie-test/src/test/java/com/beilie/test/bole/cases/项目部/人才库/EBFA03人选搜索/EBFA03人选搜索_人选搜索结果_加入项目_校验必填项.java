package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.testng.annotations.Test;

public class EBFA03人选搜索_人选搜索结果_加入项目_校验必填项 extends BoleBase {
    @Test(description = "校验姓名+联系电话必填项")
    public void 校验() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage.sleepForSeconds(1)
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_candidateSearch()//点击二级菜单：人选搜索
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(3);

        eBFA03Page.waitCandidateSearchResults()
                .clickJoinProject();
        eBFA03Page.sleepForSeconds(2);

        eBFA03Page.clickJoinProjectBtn();
        eBFA03Page.sleepForSeconds(2);

        eBFA03Page.clickConfirm();
        eBFA03Page.sleepForSeconds(2);

        eBFA03Page.checkNamePhone();
    }
}