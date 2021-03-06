package com.beilie.test.bole.cases.项目部.创建收款;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP04Page;
import com.beilie.test.bole.pages.GP.GPPL04Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

import java.util.Map;

public class _02GPPL04收款计划_新增律师函收款 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPPL04Page gPPL04Page=(GPPL04Page)bdHomePage
                .clickMenus(" 项目管理","收款计划")//点击菜单栏
                .switchToNewIframe1("GPPL04", GPPL04Page.class).sleepForSeconds(1);

        int n= Public.generateNumber0_n_1(2);
        int i=Public.generateNumber1_n(10000);

        String b=i+"";

        GPCP04Page gPCP04Page=(GPCP04Page)gPPL04Page.clickButton("\n" +
                "        新增律师函收款\n" +
                "      ")
                .switchToNewIframe(0, GPCP04Page.class).sleepForSeconds(2);

        gPCP04Page.clickInputPlaceholder("请输入候选人姓名").sleepForSeconds(1)
        .selectCandidate().sleepForSeconds(1);

        /*
    获取候选人姓名、推荐职位、推荐企业
     */
        Map<String,Object> hash=gPCP04Page.getCandidateValues();

        GPPL04Page gPPL04Page_1=(GPPL04Page)gPCP04Page.selectTimeNoComfir("请选择上班时间")
                  .sendInputPlaceholder("请输入案件名称","aaaab")
                  .sendInputPlaceholder("请输入服务费总额","100000")
                  .selectTime_Many("请选择付款时间","企业付款信息")
                  .scrollBar()
                  .sendInputPlaceholder("本次收款额",b)
                  .sendInputPlaceholder("请输入金额","44")
                  .span_followingDiv_input("\n" +
                        "                                            出函费用：                                             \n" +
                        "                                          ","55")
                  .span_followingDiv_input("其他费用：","66")
                  .clickSpan("请选择账号")
                  .ul_clickLi(n)
                  .clickButton("确定")
                  .switchToNewIframe1("GPPL04", GPPL04Page.class).sleepForSeconds(2);

        gPPL04Page_1.checkInform(hash,b).sleepForSeconds(2);
    }
}
