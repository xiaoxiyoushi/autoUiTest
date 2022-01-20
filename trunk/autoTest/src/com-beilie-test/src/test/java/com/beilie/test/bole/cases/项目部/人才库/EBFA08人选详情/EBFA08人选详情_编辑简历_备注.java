package com.beilie.test.bole.cases.项目部.人才库.EBFA08人选详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EB0301Page;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.bole.pages.EB.EBFA10Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA08人选详情_编辑简历_备注 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA01Page eBFA03Page = (EBFA01Page) bdHomePage
                .clickMenus("\n" +
                        "          中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA01Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String remark ="在EBFA08人选详情页面添加的备注"+randomStr;
        int randomNumb = 1 + Public.generateNumber1(1000);//1-1000位随机数

        String mustKeywords = "15021528407";
        EBFA08Page eBFA08Page = (EBFA08Page) eBFA03Page
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        eBFA03Page.clickSpan("编辑备注")
.clearTextarea("请输入备注信息")
        .textarea_sendkeys("请输入备注信息",remark)
                ;
    }
}
