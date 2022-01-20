package com.beilie.test.bole.cases.CCL角色.插件安排;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.DH.DHSP06Page;
import com.beilie.test.bole.pages.EB.EBFA13Page;
import org.testng.annotations.Test;

public class EBFA13插件安装_生成口令Test extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = cclLogin().sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA13Page eBFA13Page = (EBFA13Page) bdHomePage
                .singleMenu().sleepForSeconds(1)//只有一级菜单,插件安装
                .switchToNewIframe1("EBFA13", EBFA13Page.class).sleepForSeconds(2);

        eBFA13Page.a_click("生成口令").sleepForSeconds(1)
                .clickSpan("复制")
                .getSpanValue("复制成功");
        eBFA13Page.sleepForSeconds(2);
    }
}
