package com.beilie.test.bole.cases.客服;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP50Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.junit.Test;

public class GP50待回访列表_添加备注 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = login("68659127", "888888").sleepForSeconds(3);

        GP50Page gp50Page = (GP50Page) bdHomePage
                .clickMenus("\n" +
                        "          逃漏单管理", "待回访列表")//点击菜单栏
                .switchToNewIframe1("GP50", GP50Page.class).sleepForSeconds(1);

        String remarks = "客服添加备注" + Public.generateString(8);

        gp50Page.table_td_aClick(0, 10)
                .textarea_sendkeys("请输入备注信息", remarks)
                .div_parentDiv_followingDiv_spanClick("添加备注", "确定").sleepForSeconds(1);

        String remarks_1 = gp50Page.table_td_spanValue(0, 10);
        Assert.assertEquals(remarks,remarks_1);

    }
}
