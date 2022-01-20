package com.beilie.test.bole.cases.CCL角色.GLAC01实时统计;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import com.beilie.test.bole.pages.EB.EBFA13Page;
import com.beilie.test.bole.pages.GLAC.GLAC01Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class 个人给人选加标签数量Test extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = cclLogin().sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GLAC01Page gLAC01Page = (GLAC01Page) bdHomePage
                .clickFirstMenu_tongji().sleepForSeconds(1)//点击一级菜单：实时统计数据项
                .clickSecondMenu_tongji()//点击二级菜单：实时统计
                .switchToNewIframe1("GLAC01", GLAC01Page.class).sleepForSeconds(2);

        //实时统计,个人给人选加标签数量
        String tagNumber=gLAC01Page.divTitle("个人给人选加标签数量")
                .sleepForSeconds(2)
                .tagNumber();

        BdHomePage bdHomePage1 =(BdHomePage) gLAC01Page
                .switchOutIframe(BdHomePage.class);

        EBFA03Page eBFA03Page = (EBFA03Page)bdHomePage1
                .clickFirstMenu_candidateLibrary().sleepForSeconds(1)//点击一级菜单：人才库
                .clickSecondMenu_candidateSearch()//点击二级菜单：人选搜索
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        //设置标签
        BdHomePage bdHomePage2 =(BdHomePage) eBFA03Page
                .clickSpan("添加标签\n" +
                "      ")
                .sleepForSeconds(1)
                .clickSpan("\n" +
                "              985\n" +
                "            ")
                .tagConfirm()
                .switchOutIframe(BdHomePage.class);

        GLAC01Page gLAC01Page1 = (GLAC01Page) bdHomePage2
                .clickFirstMenu_tongji().sleepForSeconds(1)//点击一级菜单：实时统计数据项
                .clickSecondMenu_tongji()//点击二级菜单：实时统计
                .switchToNewIframe1("GLAC01", GLAC01Page.class).sleepForSeconds(2);

        String tagNumber1=gLAC01Page1.i_classClick("icon-btn ivu-icon bole icon-refresh")
                .sleepForSeconds(1)
                .divTitle("个人给人选加标签数量")
                .sleepForSeconds(2)
                .tagNumber();

        int i=Integer.parseInt(tagNumber)+1;
        int j=Integer.parseInt(tagNumber1);
        Assert.assertEquals(i,j);
    }
}