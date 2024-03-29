package com.beilie.test.bole.cases.项目部.创建收款;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPCP.GPCP03Page;
import com.beilie.test.bole.pages.GP.GPPL04Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.Map;

public class _01GPPL04收款计划_新增普通的收款 extends BoleBase {
@Test
public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPPL04Page gPPL04Page=(GPPL04Page)bdHomePage
        .clickMenu_collection()//点开二级菜单：收款计划
        .switchToNewIframe1("GPPL04", GPPL04Page.class).sleepForSeconds(1);

        int n=Public.generateNumber0_n_1(2);
        int i=Public.generateNumber1_n(10000);

        String b=i+"";

        GPCP03Page gPCP03Page=(GPCP03Page)gPPL04Page.clickButton("\n" +
        "        新增普通收款\n" +
        "      ")
        .switchToNewIframe(0, GPCP03Page.class).sleepForSeconds(2);

        gPCP03Page.clickCandidateNameInput().sleepForSeconds(1)
        .selectCandidate().sleepForSeconds(1);//选择一位候选人

    /*
    获取候选人姓名、推荐职位、推荐企业
     */
        Map<String,Object> hash=gPCP03Page.getValues();

        GPPL04Page gPPL04Page_1=(GPPL04Page)gPCP03Page.selectTimeNoComfir("请选择上班时间")
        .sendInputPlaceholder("请输入服务费总额","100000")
        .selectPayTime("请选择付款时间")
        .sendInputPlaceholder("本次收款额",b)
        .sendInputPlaceholder("请输入金额","200")
        .span_followingDiv_input("其他费用：","300")
        .scrollBar()
        .clickSpan("请选择账号")
        .ul_clickLi(n)
        .clickButton("确定")
        .switchToNewIframe1("GPPL04", GPPL04Page.class).sleepForSeconds(2);

        gPPL04Page_1.checkInform(hash,b).sleepForSeconds(2);
        }
        }
