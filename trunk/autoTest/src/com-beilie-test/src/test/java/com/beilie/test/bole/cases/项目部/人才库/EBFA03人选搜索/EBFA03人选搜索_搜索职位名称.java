package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.testng.annotations.Test;

public class EBFA03人选搜索_搜索职位名称 extends BoleBase {
    @Test(description = "搜索出职位名称")
    public void 校验搜索的职位名称 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_candidateSearch()//点击二级菜单
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        String job="软件工程师";//搜索的当前职位名称
        eBFA03Page.waitCandidateSearchResults()
        .sendInputPlaceholder("多个职位名称用空格隔开",job)
        .checkCurrent(1)//勾选 目前职位的勾选框
        .clickSearch()//点击搜索
        .waitCandidateSearchResults()
        .checkJob(job).sleepForSeconds(2);//校对职位名称

    }
}
