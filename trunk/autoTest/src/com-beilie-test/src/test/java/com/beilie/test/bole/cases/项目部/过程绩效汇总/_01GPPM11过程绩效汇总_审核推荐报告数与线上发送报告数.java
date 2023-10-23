package com.beilie.test.bole.cases.项目部.过程绩效汇总;

import com.beilie.test.bole.cases.项目部.项目执行._01GP10项目详情_项目执行_到发送推荐报告;
import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPPM.GPPM11Page;
import org.junit.Assert;
import org.junit.Test;

public class _01GPPM11过程绩效汇总_审核推荐报告数与线上发送报告数 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);
        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPPM11Page gPPM11Page = (GPPM11Page) bdHomePage
                .clickMenu_processMerits()//点开二级菜单“过程绩效汇总”
                .switchToNewIframe1("GPPM11", GPPM11Page.class).sleepForSeconds(1);

        int n = gPPM11Page.clickInputPlaceholder("统计月份")
                .calendar_currentMonth()
                .buttonClass_click("gppm11_search").sleepForSeconds(1)
                .table_trNumb();

        if (n == 0) {
            gPPM11Page.buttonClass_click("gppm11_generateReport").sleepForSeconds(1)
                    .clickInputPlaceholder("选择月份")
                    .calendar_currentMonths_span("gppm11_calendar")
                    .clickSpan("确定").sleepForSeconds(1);
        }

        //获取 线上发送报告数的值
        String sendReportNumb = gPPM11Page.table_td_list_aClick(0, 0, 0).sleepForSeconds(1)
                .clickSpan("重新生成报表").sleepForSeconds(1)
                .table_td_divValue(1, 0, 2);
        //获取 审核推荐报告数的值
        String auditReportNumb = gPPM11Page.table_td_spanValue(1, 0, 1);

        //关掉“过程绩效报表”弹窗
        gPPM11Page.i_class_click();

        BdHomePage bdHomePage1 = (BdHomePage) gPPM11Page.switchOutIframe(BdHomePage.class);

        _01GP10项目详情_项目执行_到发送推荐报告 g = new _01GP10项目详情_项目执行_到发送推荐报告();
        g.process(bdHomePage1);

        GPPM11Page gPPM11Page_1 = (GPPM11Page) bdHomePage1
                .clickMenu_processMerits()//点开二级菜单“过程绩效汇总”
                .switchToNewIframe1("GPPM11", GPPM11Page.class).sleepForSeconds(1);

        //重新获取 线上发送报告数的值
        String sendReportNumb_1 = gPPM11Page_1
                .table_td_list_aClick(0, 0, 0).sleepForSeconds(1)
                .clickSpan("重新生成报表").sleepForSeconds(1)
                .table_td_divValue(1, 0, 2);
        //重新获取 审核通过推荐报告数的值
        String auditReportNumb_1 = gPPM11Page_1.table_td_spanValue(1, 0, 1);

        int  i=Integer.valueOf(sendReportNumb)+1;
        int  j=Integer.valueOf(sendReportNumb_1);
        Assert.assertEquals(i,j);

        /*int  x=Integer.valueOf(auditReportNumb)+1;
        int  y=Integer.valueOf(auditReportNumb_1);
        Assert.assertEquals(x,y);*/

    }
}
