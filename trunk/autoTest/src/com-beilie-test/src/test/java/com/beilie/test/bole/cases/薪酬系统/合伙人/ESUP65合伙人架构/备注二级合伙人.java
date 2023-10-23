package com.beilie.test.bole.cases.薪酬系统.合伙人.ESUP65合伙人架构;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.ESUP.ESUP65Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

public class 备注二级合伙人 extends BoleBase {
    @Test(description = "搜索")
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login_ceshi("dululu_userName", "dululu_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗

        ESUP65Page eSUP65Page = (ESUP65Page) bdHomePage
                .clickFirstMenu_copartner().sleepForSeconds(1)//点击一级菜单
                .clickSecondMenu_copartnerSchema()//点开二级菜单
                .switchToNewIframe1("ESUP65", ESUP65Page.class).sleepForSeconds(2);

        String str = "测试二级合伙人备注" + Public.generateString(8);
        eSUP65Page.copartner_input("copartnerName_placeholder","copartnerName")
                .sleepForSeconds(1)

                .levelTwoCopartnerTab_click()

                .remarkIocn_click()
                .sleepForSeconds(1)

                .remark_send(str).sleepForSeconds(1)

                .assertRemark(str)
        ;
    }
}
