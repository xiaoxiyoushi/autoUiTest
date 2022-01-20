package com.beilie.test.bole.cases.项目部.人才库.EBFA05我的收藏夹;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA05Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.junit.Test;

public class EBFA05我的收藏夹_新增备注 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA05Page eBFA05Page = (EBFA05Page) bdHomePage
                .clickMenus("\n" +
                        "          中文简历库", "我的收藏夹")//点击菜单栏
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(3);

        int n = Public.generateNumber0_n_1(3);
        String randomStr = Public.generateString(8);//8位随机字符串
        String remark = "EBFA05我的收藏夹添加的备注" + randomStr;//备注的内容

        String remark_1 = eBFA05Page.clickSpan("备注")
                .textarea_sendkeys("请输入当前人选备注", remark)
                .clickConfirmBtn_addRemark().sleepForSeconds(1)
                .span_followingGetSpan("备注：");

        Assert.assertEquals(remark, remark_1);

        //点击more  获取我的备注信息
        String remark_2 = eBFA05Page.spanClass_click("fr mr20 color147 cursorP")
                .getSpanValue(remark);

        Assert.assertEquals(remark_1, remark_2);

        EBFA08Page eBFA08Page = (EBFA08Page) eBFA05Page.remark_close()
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        String remark_3 = eBFA08Page.Li_click("备注").sleepForSeconds(1)//切换 备注栏
                .getSpanValue(remark);

    }
}
