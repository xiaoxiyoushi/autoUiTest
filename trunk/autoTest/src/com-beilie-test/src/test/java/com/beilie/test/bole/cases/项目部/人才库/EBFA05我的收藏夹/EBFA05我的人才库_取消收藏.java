package com.beilie.test.bole.cases.项目部.人才库.EBFA05我的收藏夹;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA05Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

public class EBFA05我的人才库_取消收藏 extends BoleBase {
        @Test(description = "取消收藏")
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA05Page eBFA05Page = (EBFA05Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_myFavorities()//点击二级菜单
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(3);

        //int n= 0;
        //int n= Public.generateNumber0_n_1(3);

        eBFA05Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开","吕先生")
                .clickSpan("搜索").sleepForSeconds(3);

        EBFA08Page eBFA08Page=(EBFA08Page)eBFA05Page.clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

            String mobile=eBFA08Page.getMobile();//获取手机号

        EBFA05Page eBFA05Page_1 = (EBFA05Page) eBFA08Page.closeEBFA08Page()//关闭页面
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(1);

        BdHomePage bdHomePage_1 = (BdHomePage)eBFA05Page_1
                    .clickCollection().sleepForSeconds(1)//点击收藏按钮
                    .clickConfirmBtn().sleepForSeconds(2)//在“确认取消收藏?”弹框里，点击【确定】按钮
                    .clearButton_click()
                    .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mobile)
                    .clickSpan("搜索").sleepForSeconds(3)
                    .checkCandidateNumb()//人选搜索结果里 人选的个数,是0
                    .switchOutIframe(BdHomePage.class);

        /*EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage_1.clickSingleMenu("人选搜索")
        .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(2)
        ;*/



    }
}
