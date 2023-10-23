package com.beilie.test.bole.cases.收款.CCL;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP03Page;
import com.beilie.test.bole.pages.GP.GPRV01Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;
import java.util.Map;

public class _02GPRV01收款计划_确认付款 extends BoleBase {
    @Test(description = "确认付款")
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login_ceshi("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗

        GPRV01Page gPRV01Page = (GPRV01Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单
                .clickSecondMenu_collection()//点开二级菜单：收款计划
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(3);

        int n = Public.generateNumber0_n_1(2);
        double i = Public.generateNumber1_n(1000)+0.49;
        String b = i + "";

        Map<String, Object> hash = gPRV01Page.confirmPayment_click();

        GPCP03Page gPCP03Page = (GPCP03Page) gPRV01Page
                .switchToNewIframe(0, GPCP03Page.class).sleepForSeconds(2);

        GPRV01Page gPRV01Page_1 = (GPRV01Page) gPCP03Page
                .scrollBar1()
                .selectActualTime("请选择实际付款时间")//实际付款信息
                //.spanTitle_followingDiv_input("实际收款金额", b)
                .sendInputPlaceholder("请输入实际收款金额",b)
                //.inputPlaceholder_send("gpcp03_actualCollection_placeholder",b)
                .clickSpan("请选择收款账号").sleepForSeconds(1)
                .ul_clickLi(0).sleepForSeconds(2)
                .spanClick("gpcp03_confirm").sleepForSeconds(1)
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(1);

        gPRV01Page_1.checkInform_havenPaid(hash,b).sleepForSeconds(2);
    }
}


