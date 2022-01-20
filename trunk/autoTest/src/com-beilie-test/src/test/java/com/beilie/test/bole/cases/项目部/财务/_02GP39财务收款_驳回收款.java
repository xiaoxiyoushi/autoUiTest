package com.beilie.test.bole.cases.项目部.财务;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP38Page;
import com.beilie.test.bole.pages.GP.GPXX.GP39Page;
import org.junit.Test;

import java.util.Map;

public class _02GP39财务收款_驳回收款 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657214", "1").sleepForSeconds(3);

        GP39Page gP39Page = (GP39Page) bdHomePage
                .clickMenus("\n" +
                        "          财务管理", "财务收款")//点击菜单栏
                .switchToNewIframe1("GP39", GP39Page.class).sleepForSeconds(1);

        //获取公司名称
        String companyName = gP39Page.getCompanyName();

        /*
        未收款时，创建时间、候选人姓名、本次收款
         */
        Map<String, Object> hash = gP39Page.getValue();

        GP38Page gP38Page = (GP38Page) gP39Page.clickConfirmPay()
                .switchToNewIframe(0, GP38Page.class).sleepForSeconds(3);

        GP39Page gP39Page1 = (GP39Page) gP38Page
                .button_classClick("fr clearfix rejectBtn")//点击【驳回】按钮
                .textarea_sendkeys("驳回理由", "收款的金额不对")
                .clickSpan("确定")
                .switchToNewIframe1("GP39", GP39Page.class).sleepForSeconds(1);

        gP39Page1.inputCompanyName(companyName)//输入公司名称
                .clickPaystatusInput()//点击收款状态框
                .selectPayStatus("驳回")//选择驳回
                .clickSearchButton().sleepForSeconds(1)
                .checkValue(hash).sleepForSeconds(1)
        ;

    }
}
