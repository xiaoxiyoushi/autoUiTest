package com.beilie.test.bole.cases.收款.CCL;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPAT.GPAT09Page;
import com.beilie.test.bole.pages.GP.GPCP.GPCP05Page;
import com.beilie.test.bole.pages.GP.GPRV01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

import java.util.Map;

public class _04GPRV01收款计划_律师费 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPRV01Page gPRV01Page = (GPRV01Page) bdHomePage
                .clickMenus("\n" +
                        "          项目管理", "收款计划")//点击菜单栏
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(2);
        double i = Public.generateNumber1_n(1000) + 0.19;
        String b = i + "";

        /*获取tabel的候选人、公司名称、职位名称、本次收款金额*/
        Map<String, Object> hash = gPRV01Page.getValue();

        GPAT09Page gPAT09Page = (GPAT09Page) gPRV01Page.operation_lawyerClick()//点击律师费
                .switchToNewIframe(0, GPAT09Page.class).sleepForSeconds(2);

        GPRV01Page gPRV01Page_1 = (GPRV01Page) gPAT09Page.scrollBar()
                .sendInputPlaceholder("请输入支付的律师费", b)
                /*.selectTime_Many("请选择绩效时间", "\n" +
                        "              绩效时间：")*/
                .selectTimeNoComfir("请选择绩效时间")
                .clickButton("确定")
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(1);

        gPRV01Page_1.searchInform(hash)//根据候选人姓名、公司名称、职位名称，搜索
                .checkInform_lawyerFee(hash, b).sleepForSeconds(1);//核对提交的律师费
    }
}
