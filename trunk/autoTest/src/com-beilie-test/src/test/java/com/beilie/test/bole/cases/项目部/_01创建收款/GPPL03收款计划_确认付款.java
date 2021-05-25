/*
package com.beilie.test.bole.cases.项目部._01创建收款;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.GP.GPCP02Page;
import com.beilie.test.bole.pages.GP.GPPL03Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

import java.util.Map;

//人事角色
public class GPPL03收款计划_确认付款 extends BoleBase {
    @Test
    public void 成功创建项目并且跳到下一个页面 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658214", "1").sleepForSeconds(3);

        GPPL03Page gPPL03Page = (GPPL03Page) bdHomePage
                .clickMenus(" 逃漏单管理", "收款计划列表")//点击菜单栏
                .switchToNewIframe1("GPPL03", GPPL03Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(2);
        int i = Public.generateNumber1_n(10000);

        String b = i + "";

        Map<String,Object> hash=gPPL03Page.clickPayment();

        GPCP02Page gPCP02Page=(GPCP02Page)gPPL03Page
                .switchToNewIframe(0, GPCP02Page.class).sleepForSeconds(2);

        GPPL03Page gPPL03Page_1 = (GPPL03Page) gPCP02Page.scrollBar()
                .selectTime_Many("请选择时间","实际付款信息")//实际付款信息
                .span_followingDiv_input("实际收款金额：",b)
                .clickSpan("请选择收款账号")
                .ul_clickLi(n)
                .clickButton("保存")
                .clickButton("确认付款").sleepForSeconds(1)
                .switchToNewIframe1("GPPL03", GPPL03Page.class).sleepForSeconds(1);

        gPPL03Page_1.checkInform_havenPaid(hash).sleepForSeconds(2);


    }
}
*/
