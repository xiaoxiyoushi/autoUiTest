package com.beilie.test.bole.cases.项目部.创建收款;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.GP.GPCP.GPCP01Page;
import com.beilie.test.bole.pages.GP.GPPL01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.Map;

public class _06GPPL01收款计划_确认付款 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68659127", "888888").sleepForSeconds(3);

        GPPL01Page gPPL01Page = (GPPL01Page) bdHomePage
                .clickMenus(" 逃漏单管理", "收款计划")//点击菜单栏
                .switchToNewIframe1("GPPL01", GPPL01Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(2);
        int i = Public.generateNumber1_n(1000);
        String b = i + "";


        Map<String,Object> hash=gPPL01Page.clickPayment_1();

        GPCP01Page gPCP01Page=(GPCP01Page)gPPL01Page
                .switchToNewIframe(0, GPCP01Page.class).sleepForSeconds(2);

        GPPL01Page gPPL01Page_1 = (GPPL01Page) gPCP01Page.scrollBar()
                .selectTime_Many("请选择时间","实际付款信息")//实际付款信息
                .span_followingDiv_input("实际收款金额：",b)
                .clickSpan("请选择收款账号").sleepForSeconds(1)
                .ul_clickLi(n).sleepForSeconds(1)
                .clickButton("保存")
                .clickButton("确认付款").sleepForSeconds(1)
                .switchToNewIframe1("GPPL01", GPPL01Page.class).sleepForSeconds(1);

        gPPL01Page_1.checkInform_havenPaid_1(hash).sleepForSeconds(2);

    }

}
