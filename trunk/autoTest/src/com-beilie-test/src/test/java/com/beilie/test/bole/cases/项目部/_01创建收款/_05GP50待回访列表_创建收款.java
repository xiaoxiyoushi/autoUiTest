package com.beilie.test.bole.cases.项目部._01创建收款;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.GP.GPXX.GP50Page;
import com.beilie.test.bole.pages.GP.GPCP.GPCP01Page;
import com.beilie.test.bole.pages.GP.GPPL01Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.Map;

public class _05GP50待回访列表_创建收款 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68659127", "888888").sleepForSeconds(3);

        GP50Page gPPL03Page = (GP50Page) bdHomePage
                .clickMenus(" 逃漏单管理", "待回访列表")//点击菜单栏
                .switchToNewIframe1("GP50", GP50Page.class).sleepForSeconds(1);

        int i = Public.generateNumber1_n(100000);
        int m= Public.generateNumber0_n_1(2);

        String b = i + "";
        int trNumb=gPPL03Page.table_trNumb();
        int n = Public.generateNumber0_n_1(trNumb);

        GPCP01Page gPCP01Page=(GPCP01Page)gPPL03Page.clickA("创建收款",n)
                .switchToNewIframe(0, GPCP01Page.class).sleepForSeconds(2);

        /*
         获取候选人姓名、推荐职位、推荐企业
        */
        Map<String,Object> hash=gPCP01Page.getCandidateValues();

        BdHomePage bdHomePage_1=(BdHomePage)gPCP01Page.selectTimeNoComfir("请选择上班时间")
        .sendInputPlaceholder("请输入服务费总额","100000")
        .selectTime_Many("请选择付款时间","企业付款信息")
                .sendInputPlaceholder("本次收款额",b)
                .clickSpan("请选择账号")
                .ul_clickLi(m)
                .clickButton("确定")
                .switchOutIframe(BdHomePage.class).sleepForSeconds(2);

        GPPL01Page gPPL01Page=(GPPL01Page)bdHomePage_1.clickSingleMenu("收款计划")
                .switchToNewIframe1("GPPL01", GPPL01Page.class).sleepForSeconds(2);

        gPPL01Page.selectTimeNoComfir("请输入时间")
                .clickButton("搜索").sleepForSeconds(1)
                .checkInform_2(hash,b).sleepForSeconds(1);

    }
}
