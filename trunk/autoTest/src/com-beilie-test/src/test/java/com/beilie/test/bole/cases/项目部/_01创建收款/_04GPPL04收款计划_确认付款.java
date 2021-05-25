package com.beilie.test.bole.cases.项目部._01创建收款;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP03Page;
import com.beilie.test.bole.pages.GP.GPPL04Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.Map;

public class _04GPPL04收款计划_确认付款 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPPL04Page gPPL04Page = (GPPL04Page) bdHomePage
                .clickMenus(" 项目管理", "收款计划")//点击菜单栏
                .switchToNewIframe1("GPPL04", GPPL04Page.class).sleepForSeconds(1);

        int n=Public.generateNumber0_n_1(2);
        int i= Public.generateNumber1_n(1000);
        String b=i+"";

        Map<String,Object> hash=gPPL04Page.clickPayment();

        GPCP03Page gPCP03Page=(GPCP03Page)gPPL04Page
                .switchToNewIframe(0, GPCP03Page.class).sleepForSeconds(2);

        GPPL04Page gPPL04Page_1 = (GPPL04Page) gPCP03Page.scrollBar()
                .selectTime_Many("请选择时间","实际付款信息")//实际付款信息
                .spanTitle_followingDiv_input("实际收款金额",b)
                .clickSpan("请选择收款账号").sleepForSeconds(1)
                .ul_clickLi(n).sleepForSeconds(2)
                .clickButton("保存").sleepForSeconds(1)
                .clickButton("确认付款").sleepForSeconds(1)
                .switchToNewIframe1("GPPL04", GPPL04Page.class).sleepForSeconds(1);

        gPPL04Page_1.checkInform_havenPaid(hash).sleepForSeconds(2);
    }
}
