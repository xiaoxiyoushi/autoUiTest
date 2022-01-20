package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.junit.Test;

public class EBFA03人选搜索_举报简历 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus("\n" +
                        "          中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(3);

        String str = "该人选简历造假" + Public.generateString(8);

        EBFA08Page eBFA08Page = (EBFA08Page) eBFA03Page.clickAvatar(2)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        String value = eBFA08Page.clickSpan("举报简历")
                .textarea_sendkeys("请输入理由", str)
                .clickSpan("确定")
                .value_efpage();

        Assert.assertEquals("创建数据成功。", value);
    }
}
