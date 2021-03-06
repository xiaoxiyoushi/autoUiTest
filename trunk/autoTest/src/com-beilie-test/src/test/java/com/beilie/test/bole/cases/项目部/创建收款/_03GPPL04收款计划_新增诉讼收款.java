package com.beilie.test.bole.cases.项目部.创建收款;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.GP.GPCP.GPCP02Page;
import com.beilie.test.bole.pages.GP.GPPL04Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.Map;

public class _03GPPL04收款计划_新增诉讼收款 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPPL04Page gPPL04Page=(GPPL04Page)bdHomePage
                .clickMenus(" 项目管理","收款计划")//点击菜单栏
                .switchToNewIframe1("GPPL04", GPPL04Page.class).sleepForSeconds(1);

        int n= Public.generateNumber0_n_1(2);
        int i= Public.generateNumber1_n(10000);

        String b=i+"";

        GPCP02Page gPCP02Page=(GPCP02Page)gPPL04Page.clickButton("\n" +
                "        新增诉讼收款\n" +
                "      ")
                .switchToNewIframe(0, GPCP02Page.class).sleepForSeconds(2);

        gPCP02Page.clickInputPlaceholder("请输入候选人姓名").sleepForSeconds(1)
                .selectCandidate().sleepForSeconds(1);

        Map<String,Object> hash=gPCP02Page.getCandidateValues();

        GPPL04Page gPPL04Page_1=(GPPL04Page)gPCP02Page.selectTimeNoComfir("请选择上班时间")
                .sendInputPlaceholder("请输入案件名称","ccccd")
                .sendInputPlaceholder("请输入金额","100")
                .span_followingDiv_input("应付律师费：","22")
                .span_followingDiv_input("诉讼费用支出：","33")
                .span_followingDiv_input("实际律所收费：","44")
                .span_followingDiv_input("诉讼总费：","55")
                .span_followingDiv_input("实际律师收费：","66")
                .scrollBar()
                .sendInputPlaceholder("请输入服务费总额","100000")
                .selectTime_Many("请选择付款时间","企业付款信息")
                .sendInputPlaceholder("本次收款额",b)
                .span_followingDiv_input("猎头绩效：","77")
                .span_followingDiv_input("其他费用：","88")
                .clickSpan("请选择账号")
                .ul_clickLi(n)
                .clickButton("确定")
                .switchToNewIframe1("GPPL04", GPPL04Page.class).sleepForSeconds(2);

        gPPL04Page_1.checkInform_1(hash,b).sleepForSeconds(2);

    }
}
