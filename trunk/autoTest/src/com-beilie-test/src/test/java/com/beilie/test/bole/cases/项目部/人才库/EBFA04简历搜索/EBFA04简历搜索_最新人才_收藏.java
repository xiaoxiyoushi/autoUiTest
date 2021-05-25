package com.beilie.test.bole.cases.项目部.人才库.EBFA04简历搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import com.beilie.test.bole.pages.EB.EBFA05Page;
import com.beilie.test.bole.pages.EB.EBFA16Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA04简历搜索_最新人才_收藏 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickMenus(" 中文简历库", "简历搜索")//点击菜单栏
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String name = "乔布斯"+randomStr;//姓名
        String phone = "175645124544"+randomStr;//姓名


        EBFA16Page eBFA16Page=(EBFA16Page)eBFA04Page
                .clickButton("最新人才").sleepForSeconds(2)//切换至 最新人才库
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开","1药网(美股上市公司)")
                .clickSpan("搜索").sleepForSeconds(2)
                .clickCollection()//点击收藏按钮
                .switchToNewIframe(0, EBFA16Page.class).sleepForSeconds(3);

        BdHomePage bdHomePage_1 = (BdHomePage)eBFA16Page.sendInputPlaceholder("请输入姓名",name)//输入姓名
                .sendInputPlaceholder("请输入联系电话","175645124544"+randomStr)//输入联系方式
                .sendInputPlaceholder("请输入电子邮箱","xdcfgvbhn@ww.com"+randomStr)//输入邮箱
                .click_untilNow(" 至今")
                .label_followingDiv_clickimg("目前职能：")//点击目前职能的icon
                .functionSingleComponent()//选择职能组件
                .clickSpan("添加到收藏夹").sleepForSeconds(5)
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .switchOutIframe(BdHomePage.class);

        EBFA05Page eBFA05Page = (EBFA05Page)bdHomePage_1.clickSingleMenu("我的收藏夹")
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(1);

        eBFA05Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",phone)//搜索手机号码
                .clickSpan("搜索").sleepForSeconds(2)
                .hoverAvatar(0).sleepForSeconds(1)
                .checkResumeCard(phone)
        ;
    }
}
