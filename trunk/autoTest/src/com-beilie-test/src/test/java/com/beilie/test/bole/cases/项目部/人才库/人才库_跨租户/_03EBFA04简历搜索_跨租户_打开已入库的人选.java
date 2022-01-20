package com.beilie.test.bole.cases.项目部.人才库.人才库_跨租户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA02Page;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import org.junit.Test;
//张德年
//登录的是daoye租户，打开的是gongkai租户 已入库的人选
//EBFA04简历搜索_跨租户_打开已入库的人选,打开的是A02页面 待确认入库
public class _03EBFA04简历搜索_跨租户_打开已入库的人选 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68659106", "888888").sleepForSeconds(3);

        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickMenus("\n" +
                        "          中文简历库", "简历搜索")//点击菜单栏
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String mustKeywords = "18012558122";
        EBFA02Page eBFA02Page = (EBFA02Page) eBFA04Page
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA02Page.class).sleepForSeconds(2);

        eBFA02Page.div_getValue(" EBFA02 | 确认入库 ")
        .checkRightResume();
    }
}
