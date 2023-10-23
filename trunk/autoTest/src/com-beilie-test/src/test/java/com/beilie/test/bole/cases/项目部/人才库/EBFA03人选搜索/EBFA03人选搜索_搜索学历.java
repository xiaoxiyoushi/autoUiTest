package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.testng.annotations.Test;

public class EBFA03人选搜索_搜索学历 extends BoleBase {
    @Test(description = "搜索出学历")
    public void 校对搜索出人选信息的学历 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_candidateSearch()//点击二级菜单
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        String xueLi="大专";
        eBFA03Page.waitCandidateSearchResults()
                .clickSpan("学历下限").sleepForSeconds(1)//点击学历下限框
                .Li_click(xueLi)//点击大专
                .clickSpan("学历上限").sleepForSeconds(1)//点击学历上限框
                .span_parentDiv_parentDiv_followingGetDiv("学历上限",xueLi)//点击大专
                .clickSearch()//点击搜索
                .waitCandidateSearchResults()
                .hoverAvatar(0).sleepForSeconds(2)
                .checkCandidateCard().sleepForSeconds(2);
    }
}
