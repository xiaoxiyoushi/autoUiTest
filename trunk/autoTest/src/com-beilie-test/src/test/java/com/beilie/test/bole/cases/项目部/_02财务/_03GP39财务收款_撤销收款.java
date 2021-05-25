package com.beilie.test.bole.cases.项目部._02财务;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPFR05Page;
import com.beilie.test.bole.pages.GP.GPXX.GP38Page;
import com.beilie.test.bole.pages.GP.GPXX.GP39Page;
import org.junit.Test;

import java.util.Map;

public class _03GP39财务收款_撤销收款 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657214", "1").sleepForSeconds(3);

        GP39Page gP39Page = (GP39Page) bdHomePage
                .clickMenus(" 财务管理", "财务收款")//点击菜单栏
                .switchToNewIframe1("GP39", GP39Page.class).sleepForSeconds(1);

        GP38Page gP38Page = (GP38Page) gP39Page.clickPaystatusInput()//点击收款状态框
                .selectPayStatus("已收款")//选择已收款
                .clickSearchButton().sleepForSeconds(1)
                .table_td_aClick(0, 5)
                .switchToNewIframe(0, GP38Page.class).sleepForSeconds(3);

        BdHomePage bdHomePage_1 = (BdHomePage) gP38Page.button_classClick("clearfix receBtn")
                .textarea_sendkeys("撤销理由", "该人选的收款申请撤销")
                .button_classClick("cancel_modal_footer_sure ivu-btn")//点击申请撤销按钮
                .switchOutIframe(BdHomePage.class);

        GPFR05Page gPFR05Page = (GPFR05Page) bdHomePage_1
                .clickSingleMenu("撤销收款")
                .switchToNewIframe1("GPFR05", GPFR05Page.class).sleepForSeconds(1);

        gPFR05Page.button_classClick("serach").sleepForSeconds(1)//点击搜索按钮
                .div_class_("ivu-table-fixed-body")
        ;

    }
}
