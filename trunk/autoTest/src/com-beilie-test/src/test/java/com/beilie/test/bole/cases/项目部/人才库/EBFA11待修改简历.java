package com.beilie.test.bole.cases.项目部.人才库;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA10Page;
import com.beilie.test.bole.pages.EB.EBFA11Page;
import org.junit.Assert;
import org.junit.Test;

public class EBFA11待修改简历 extends BoleBase {
    @Test
    public void 提交待修改简历() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA11Page eBFA11Page = (EBFA11Page) bdHomePage
                .clickMenus(" 中文简历库", "待修改简历")//点击菜单栏
                .switchToNewIframe1("EBFA11", EBFA11Page.class).sleepForSeconds(3);

        EBFA10Page eBFA10Page = (EBFA10Page) eBFA11Page.table_td_aClick(1, 0, 0, 0)//点击编辑
                .switchToNewIframe(0, EBFA10Page.class);

        String value = eBFA10Page.clickSpan("确定").sleepForSeconds(1)
                .spanClass("ef-modal-ef-model-confirm-b-span");

        Assert.assertEquals("更新数据成功。",value);
    }
}
