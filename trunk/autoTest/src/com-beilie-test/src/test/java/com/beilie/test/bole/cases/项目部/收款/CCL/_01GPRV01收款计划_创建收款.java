package com.beilie.test.bole.cases.项目部.收款.CCL;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP03Page;
import com.beilie.test.bole.pages.GP.GPRV01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.Map;

public class _01GPRV01收款计划_创建收款 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPRV01Page gPRV01Page = (GPRV01Page) bdHomePage
                .clickMenus(" 项目管理", "收款计划")//点击菜单栏
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(1);

        int n=Public.generateNumber0_n_1(2);
        double d=Public.generateNumber1_n(10000)+0.38;

        String b=d+"";

        GPCP03Page gPCP03Page = (GPCP03Page) gPRV01Page.paymentPlan_click()//点击【创建收款】按钮
                .switchToNewIframe(0, GPCP03Page.class).sleepForSeconds(2);

        gPCP03Page.clickCandidateNameInput().sleepForSeconds(1)
                .selectCandidate().sleepForSeconds(1);//选择一位候选人

        /*
    获取候选人姓名、推荐职位、推荐企业
     */
        Map<String,Object> hash=gPCP03Page.getValues();

        GPRV01Page gPRV01Page_1=(GPRV01Page)gPCP03Page.selectTimeNoComfir("请选择上班时间")
                .sendInputPlaceholder("请输入服务费总额","100000")
                .selectPayTime("请选择付款时间")
                .sendInputPlaceholder("本次收款额",b)
                .scrollBar()
                .clickSpan("请选择账号")
                .ul_clickLi(n)
                .clickButton("确定")
                .switchToNewIframe1("GPRV01", GPRV01Page.class).sleepForSeconds(2);

        gPRV01Page_1.checkInform(hash,b).sleepForSeconds(2);//核对本次收款金额
    }
}

