package com.beilie.test.bole.cases.客服;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP50Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.junit.Test;

public class GP50待回访列表_设置查单状态 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = login("68659127", "888888").sleepForSeconds(3);

        GP50Page gp50Page = (GP50Page) bdHomePage
                .clickMenus("\n" +
                        "          逃漏单管理", "待回访列表")//点击菜单栏
                .switchToNewIframe1("GP50", GP50Page.class).sleepForSeconds(1);

        int n = Public.generateNumber1(1000000);
        String phoneNumb = "1338592" + n;

        String status = gp50Page.table_td_aClick(0, 4)
                .div_followingDiv_span_click("查单状态：").sleepForSeconds(1)
                .selectCheckList();

        gp50Page.textarea_sendkeys("更改状态原因", "客服更改了查单状态")
                .div_parentDiv_followingDiv_spanClick("修改状态", "确定").sleepForSeconds(1);

        String status_1 = gp50Page.table_td_aValue(0, 4);

        Assert.assertEquals(status,status_1);
    }
}


