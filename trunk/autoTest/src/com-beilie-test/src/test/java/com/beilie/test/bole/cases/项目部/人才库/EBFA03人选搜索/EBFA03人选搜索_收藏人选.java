package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import com.beilie.test.bole.pages.EB.EBFA05Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.junit.Test;

public class EBFA03人选搜索_收藏人选 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(3);

        int n= Public.generateNumber0_n_1(3);
        String str="添加到收藏夹，可使用一键呼叫功能";

        EBFA08Page eBFA08Page=(EBFA08Page)eBFA03Page.clickAvatar(n)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        String btnValue=eBFA08Page.button_spanValue(str);//获取按钮的文案
        String mobile=eBFA08Page.getMobile();//获取手机号

        if (!btnValue.equals("添加到收藏夹")){
            EBFA03Page eBFA03Page_1 = (EBFA03Page) eBFA08Page.closePage()//关闭”EBFA08人选详情“页面
                    .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(2);
            eBFA03Page_1.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mobile)//用手机号搜索出人选
                    .clickSpan("搜索").sleepForSeconds(3)
                    .clickCollection().sleepForSeconds(1)//点击收藏按钮
                    .clickConfirmBtn().sleepForSeconds(2);//在“确认取消收藏?”弹框里，点击【确定】按钮
            EBFA08Page eBFA08Page_1=(EBFA08Page)eBFA03Page.clickAvatar(0)//点击头像
                    .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);
            }

        eBFA08Page.button_spanClick(str).sleepForSeconds(2);//将人选加入到我的人才库
        String btnValue_1=eBFA08Page.button_spanValue(str);//获取按钮的文案
        Assert.assertEquals("已添加到收藏夹",btnValue_1);//校验button的数据

        BdHomePage bdHomePage_1 = (BdHomePage)eBFA08Page.closePage()//关闭”EBFA08人选详情“页面
                .switchOutIframe(BdHomePage.class);
        EBFA05Page eBFA05Page = (EBFA05Page)bdHomePage_1.clickSingleMenu("我的收藏夹")
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(3);//转换到“EBFA05我的人才库”页面

        EBFA08Page eBFA08Page_1=(EBFA08Page)eBFA05Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mobile)//用手机号搜索出人选
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        String btnValue_2=eBFA08Page_1.button_spanValue(str);//获取按钮的文案
        Assert.assertEquals("已添加到收藏夹",btnValue_2);//校验button的数据

    }
}

