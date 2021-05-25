package com.beilie.test.bole.cases.项目部.人才库.EBFA05我的收藏夹;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA05Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA05我的人才库_取消收藏 extends BoleBase {
        @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA05Page eBFA05Page = (EBFA05Page) bdHomePage
                .clickMenus(" 中文简历库", "我的收藏夹")//点击菜单栏
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(3);

        //int n= 0;
        int n= Public.generateNumber0_n_1(3);

        EBFA08Page eBFA08Page=(EBFA08Page)eBFA05Page.clickAvatar(n)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        String mobile=eBFA08Page.getMobile();//获取手机号

        EBFA05Page eBFA05Page_1 = (EBFA05Page) eBFA08Page.closePage()//关闭页面
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(1);

        BdHomePage bdHomePage_1 = (BdHomePage)eBFA05Page_1.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mobile)//用手机号搜索出人选
                    .clickSpan("搜索").sleepForSeconds(3)
                    .clickCollection().sleepForSeconds(1)//点击收藏按钮
                    .clickConfirmBtn().sleepForSeconds(2)//在“确认取消收藏?”弹框里，点击【确定】按钮
                    .clickSpan("搜索").sleepForSeconds(3)
                    .checkCandidateNumb()//人选搜索结果里 人选的个数,是0
                    .switchOutIframe(BdHomePage.class);

        /*EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage_1.clickSingleMenu("人选搜索")
        .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(2)
        ;*/



    }
}
