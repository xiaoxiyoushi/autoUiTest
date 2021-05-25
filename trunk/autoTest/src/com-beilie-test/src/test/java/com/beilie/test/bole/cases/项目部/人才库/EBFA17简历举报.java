package com.beilie.test.bole.cases.项目部.人才库;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA10Page;
import com.beilie.test.bole.pages.EB.EBFA17Page;
import org.junit.Assert;
import org.junit.Test;

public class EBFA17简历举报 extends BoleBase {
    @Test
    public void 审核通过() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658214", "1").sleepForSeconds(3);

        EBFA17Page eBFA17Page = (EBFA17Page) bdHomePage
                .clickMenus(" 人才库管理", "简历举报")//点击菜单栏
                .switchToNewIframe1("EBFA17", EBFA17Page.class).sleepForSeconds(3);

        String value = eBFA17Page.table_td_aClick(1,0,0,0).sleepForSeconds(1)
        .spanClass("singleLine messageContent");

        Assert.assertEquals("更新数据成功。",value);
    }
}
