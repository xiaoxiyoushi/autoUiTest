package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EBFA03人选搜索_搜索地点 extends BoleBase {
    @Test(description = "搜索出地点")
    public void 校对搜索出人选信息的地点() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage.sleepForSeconds(1)
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_candidateSearch()//点击二级菜单
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        eBFA03Page.waitCandidateSearchResults()
                .label_followingDiv_input("地点：", "白")
                .label_followingDiv_input("地点：", "云区").sleepForSeconds(1)
                .label_followingDiv_Input_down("地点：").sleepForSeconds(1)
                .label_followingDiv_Input_enrter("地点：").sleepForSeconds(1);

        eBFA03Page.clickSearch()
                .waitCandidateSearchResults()
                .checkLocation();

    }
}
