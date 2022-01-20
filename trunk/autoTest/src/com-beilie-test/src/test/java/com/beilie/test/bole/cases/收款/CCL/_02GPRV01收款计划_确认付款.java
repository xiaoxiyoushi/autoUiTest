package com.beilie.test.bole.cases.收款.CCL;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP03Page;
import com.beilie.test.bole.pages.GP.GPRV01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.Map;

public class _02GPRV01收款计划_确认付款 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPRV01Page gPRV01Page = (GPRV01Page) bdHomePage
                .clickMenus("\n" +
                        "          项目管理", "收款计划")//点击菜单栏
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(2);
        double i = Public.generateNumber1_n(1000)+0.49;
        String b = i + "";

        Map<String, Object> hash = gPRV01Page.confirmPayment_click();

        GPCP03Page gPCP03Page = (GPCP03Page) gPRV01Page
                .switchToNewIframe(0, GPCP03Page.class).sleepForSeconds(2);

        GPRV01Page gPRV01Page_1 = (GPRV01Page) gPCP03Page.scrollBar()
                .selectTime_Many("请选择实际付款时间", "实际付款信息")//实际付款信息
                .spanTitle_followingDiv_input("实际收款金额", b)
                .clickSpan("请选择收款账号").sleepForSeconds(1)
                .ul_clickLi(n).sleepForSeconds(2)
                .clickButton("确认付款").sleepForSeconds(1)
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(1);

        gPRV01Page_1.checkInform_havenPaid(hash,b).sleepForSeconds(2);
    }
}


