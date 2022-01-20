package com.beilie.test.bole.cases.客服;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP50Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.junit.Test;

public class GP50待回访列表_设置客户联系方式 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = login("68659127", "888888").sleepForSeconds(3);

        GP50Page gp50Page = (GP50Page) bdHomePage
                .clickMenus("\n" +
                        "          逃漏单管理", "待回访列表")//点击菜单栏
                .switchToNewIframe1("GP50", GP50Page.class).sleepForSeconds(1);

        int n = Public.generateNumber1(1000000);
        String phoneNumb = "1338592" + n;

        String getPhoneNumb =gp50Page.table_td_aClick(0, 2)
                .clearTextarea("请输入客户联系方式")
                .textarea_sendkeys("请输入客户联系方式", phoneNumb)
                .div_parentDiv_followingDiv_spanClick("修改客户联系方式", "确定").sleepForSeconds(1)
                .table_td_aValue(0, 2);

        Assert.assertEquals(phoneNumb,getPhoneNumb);
    }
}

