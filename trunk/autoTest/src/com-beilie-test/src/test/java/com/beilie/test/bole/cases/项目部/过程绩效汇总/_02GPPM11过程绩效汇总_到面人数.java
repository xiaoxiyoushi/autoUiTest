package com.beilie.test.bole.cases.项目部.过程绩效汇总;

import com.beilie.test.bole.cases.项目部.项目执行._02GP10项目详情_项目执行_到新建Offer;
import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPPM.GPPM11Page;
import org.junit.Assert;
import org.junit.Test;

public class _02GPPM11过程绩效汇总_到面人数 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPPM11Page gPPM11Page = (GPPM11Page) bdHomePage
                .clickMenus("\n" +
                        "          报表管理", "过程绩效汇总")//点击菜单栏
                .switchToNewIframe1("GPPM11", GPPM11Page.class).sleepForSeconds(1);

        int n = gPPM11Page.clickInputPlaceholder("统计月份")
                .calendar_currentMonth()
                .clickSpan("搜索").sleepForSeconds(1)
                .table_trNumb();

        if (n == 0) {
            gPPM11Page.clickSpan("生成报表").sleepForSeconds(1)
                    .clickInputPlaceholder("选择月份")
                    .calendar_currentMonths_span("时间:")
                    .clickSpan("确定").sleepForSeconds(1);
        }

        //获取 到面人数的值
        String reportNumb = gPPM11Page.table_td_list_aClick(0, 0, 0).sleepForSeconds(1)
                .clickSpan("重新生成报表").sleepForSeconds(1)
                .table_td_divValue(1, 0, 4);

        //关掉“过程绩效报表”弹窗
        gPPM11Page.i_class_click();

        BdHomePage bdHomePage1 = (BdHomePage) gPPM11Page.switchOutIframe(BdHomePage.class);

        _02GP10项目详情_项目执行_到新建Offer g=new _02GP10项目详情_项目执行_到新建Offer();
        g.process(bdHomePage1);

        GPPM11Page gPPM11Page_1 = (GPPM11Page) bdHomePage1.clickMenus("\n" +
                "          报表管理", "过程绩效汇总")
                .switchToNewIframe1("GPPM11", GPPM11Page.class).sleepForSeconds(1);

        //重新获取 到面人数的值
        String reportNumb_1 = gPPM11Page_1.table_td_list_aClick(0, 0, 0).sleepForSeconds(1)
                .clickSpan("重新生成报表").sleepForSeconds(1)
                .table_td_divValue(1, 0, 4);

        int  i=Integer.valueOf(reportNumb)+1;
        int  j=Integer.valueOf(reportNumb_1);

        Assert.assertEquals(i,j);

    }
}
