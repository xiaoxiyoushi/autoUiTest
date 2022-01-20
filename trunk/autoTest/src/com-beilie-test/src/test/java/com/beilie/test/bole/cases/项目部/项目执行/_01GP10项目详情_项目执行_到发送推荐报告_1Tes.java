package com.beilie.test.bole.cases.项目部.项目执行;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EB0701Page;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPRR01Page;
import com.beilie.test.bole.pages.GP.GPRR02Page;
import com.beilie.test.bole.pages.GP.GPXX.*;
import com.beilie.test.open.PublicClass.Public;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class _01GP10项目详情_项目执行_到发送推荐报告_1Tes extends BoleBase {

    String randomStr = Public.generateString(8);//8位随机字符串
    String name = "高超" + randomStr;
    BdHomePage bdHomePage;
    GP14Page gP14Page;
    @Before
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        bdHomePage = login("68658226", "1").sleepForSeconds(3);
    }
    @Test
    public void process() throws IllegalAccessException, InstantiationException, InterruptedException {
        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject()//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);


        String phone = "13717767381" + randomStr;
        String mailbox = "158324803@qq.com" + randomStr;

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .inputClientName("请输入项目名称", "卖麦芽糖的")//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        gP10Page.span_followingSpan_i_click("人选进程").sleepForSeconds(1);//点击正序

            gP10Page = (GP10Page) gP10Page.switchToNewIframe(0, GP10Page.class);

            gP10Page.clickSpan("搜索").sleepForSeconds(3);

            String porjectProcess = gP10Page.clickProcess("寻访中", 1).sleepForSeconds(3)
                    .table_td_spanValue(0, 3);//项目进程的值

        name = gP10Page.table_td_list_aValue(0, 0, 0);

        gP14Page = (GP14Page) gP10Page.table_td_aClick(0, 0)
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);
    }

    @After
    public void carry() throws IllegalAccessException, InstantiationException, InterruptedException {
        String project_company = "-卖麦芽糖的-上海麦芽糖公司";

        EBFA08Page eBFA08Page = (EBFA08Page) gP14Page
                .secondTask(name)
                .switchToNewIframe(2, EBFA08Page.class).sleepForSeconds(3);

        String message = eBFA08Page.recommndReport_click().sleepForSeconds(1)//点击 生成推荐报告
                .div_Value(" 添加推荐报告成功 ");

        if (message.equals("添加推荐报告成功")) {
            EB0701Page eB0701Page = (EB0701Page) eBFA08Page
                    .switchToNewIframe(3, EB0701Page.class).sleepForSeconds(3);

            eB0701Page.i_class_click();//关闭页面，点击叉号icon

            eBFA08Page = (EBFA08Page) eBFA08Page
                    .switchToNewIframe(2, EBFA08Page.class).sleepForSeconds(3);
        }

        GP14Page gP14Page_1 = (GP14Page) eBFA08Page
                .i_class_click()//关闭页面，点击叉号icon
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP18Page gP18Page = (GP18Page) gP14Page_1
                .clickSpan("发送JD-" + name + project_company)
                .switchToNewIframe(2, GP18Page.class).sleepForSeconds(3);

        GP19Page gP19Page = (GP19Page) gP18Page
                //勾选 线下已发JD
                .labelClass_Click("offline-checkbox ivu-checkbox-wrapper ivu-checkbox-default")
                .clickSpan("保存").sleepForSeconds(2)
                .switchToNewIframe(2, GP19Page.class).sleepForSeconds(3);

        GP14Page gP14Page_2 = (GP14Page) gP19Page.clickSpan("个人信息已确认")
                .clickSpan("确定")
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP26Page gP26Page = (GP26Page) gP14Page_2
                .clickSpan("提交推荐报告-" + name + project_company)
                .switchToNewIframe(2, GP26Page.class).sleepForSeconds(3);

        GP14Page gP14Page_3 = (GP14Page) gP26Page.clickSpan("确定")
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP28Page gP28Page = (GP28Page) gP14Page_3
                .clickSpan("审核推荐报告-" + name + project_company)
                .switchToNewIframe(2, GP28Page.class).sleepForSeconds(3);

        GP14Page gP14Page_4 = (GP14Page) gP28Page.clickSpan("通过")
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP10Page gP10Page_3 = (GP10Page) gP14Page_4
                .i_class_click()//关闭页面，点击叉号icon
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        BdHomePage bdHomePage_1 = (BdHomePage) gP10Page_3
                .i_class_click()//关闭页面，点击叉号icon
                .switchOutIframe(BdHomePage.class).sleepForSeconds(1);

        GPRR01Page gPRR01Page = (GPRR01Page) bdHomePage_1
                .clickSingleMenu("已审核推荐报告")//点击菜单栏
                .switchToNewIframe1("GPRR01", GPRR01Page.class).sleepForSeconds(1);

        GPRR02Page gPRR02Page = (GPRR02Page) gPRR01Page.clickSpan("搜索").sleepForSeconds(2)
                .selectCandidate()
                //点击按钮【添加到推荐列表】
                .button_classClick("mr-2 ivu-btn ivu-btn-primary")
                .clickSpan("确定").sleepForSeconds(1)
                .clickSpan("查看待推荐列表")
                .switchToNewIframe(0, GPRR02Page.class).sleepForSeconds(3);

        gPRR02Page.clickSpan("发送报告").sleepForSeconds(2);
    }
}
