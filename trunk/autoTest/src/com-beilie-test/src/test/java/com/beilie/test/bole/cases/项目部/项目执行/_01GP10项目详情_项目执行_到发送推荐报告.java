package com.beilie.test.bole.cases.项目部.项目执行;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EB0701Page;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.*;
import com.beilie.test.bole.pages.GP.*;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class _01GP10项目详情_项目执行_到发送推荐报告 extends BoleBase {
    @Test
    public void run() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage1 = login();
        process(bdHomePage1);
    }

    public BdHomePage login() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);
        return bdHomePage;
    }

    public void process(BdHomePage bdHomePage) throws IllegalAccessException, InstantiationException, InterruptedException {
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickMenus("\n" +
                        "          项目管理", "我的项目").sleepForSeconds(2)//点击菜单栏
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String name = "高超" + randomStr;
        String phone = "13717767381" + randomStr;
        String mailbox = "158324803@qq.com" + randomStr;

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .inputClientName("请输入项目名称", "卖麦芽糖的")//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        gP10Page.span_followingSpan_i_click("人选进程").sleepForSeconds(1);//点击正序

        for (int i = 0; i < 10; i++) {
            gP10Page = (GP10Page) gP10Page.switchToNewIframe(0, GP10Page.class);

            gP10Page.clickSpan("搜索").sleepForSeconds(3);

            String porjectProcess = gP10Page.clickProcess("寻访中", 1).sleepForSeconds(3)
                    .table_td_spanValue(i, 3);//项目进程的值

            if (porjectProcess.equals("正在联络")) {
                name = gP10Page.table_td_list_aValue(0, 0, 0);

                GP14Page gP14Page = (GP14Page) gP10Page.table_td_aClick(0, 0)
                        .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

                carry(gP14Page, name);
                break;
            } else if (porjectProcess.equals("主管审核通过")) {
                GP14Page gP14Page = (GP14Page) gP10Page.table_td_aClick(0, 0)
                        .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

                GP12Page gP12Page = (GP12Page) gP14Page.clickSpan("创建面试")
                        .clickConfirmBtn("ivu-btn ivu-btn-primary ivu-btn-large").sleepForSeconds(1)
                        .switchToNewIframe(2, GP12Page.class).sleepForSeconds(3);

                GP14Page gP14Page_1 = (GP14Page) gP12Page.img_altClick("关闭")
                        .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

                gP14Page_1.img_altClick("关闭");

            } else {
                EBFA01Page eBFA01Page = (EBFA01Page) gP10Page
                        .clickSpan("新增一份简历")
                        .switchToNewIframe(1, EBFA01Page.class).sleepForSeconds(3);

                GP10Page gP10Page_1 = (GP10Page) eBFA01Page.judgeWay()
                        .uploadResume("C:\\Users\\86182\\Desktop\\ui自动化 测试的简历\\13717767381_高超.txt")
                        .sleepForSeconds(5)

                        .clearInput("请输入姓名")//清掉原来姓名的值
                        .sendInputPlaceholder("请输入姓名", name)//输入姓名

                        .clearInput("请输入联系电话")//清掉原来手机
                        .sendInputPlaceholder("请输入联系电话", phone)//输入手机值

                        .clearInput("请输入电子邮箱")//清掉原来邮箱
                        .sendInputPlaceholder("请输入电子邮箱", mailbox)//输入邮箱值

                        .label_followingDiv_clickimg("目前职能：")//点击目前职能的icon
                        .functionSingleComponent()//选择职能组件

                        .clickSpan("确定").sleepForSeconds(1)//点击【确定】按钮  提交简历
                        .checkTip()////校对提示 上传简历成功
                        .clickConfirmBtn().sleepForSeconds(1)////点击提示的【确定】按钮
                        .checkTip_addProject(name)//校对提示 加入项目成功
                        .clickConfirmBtn()//点击提示的【确定】按钮
                        .i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                        .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

                GP14Page gP14Page = (GP14Page) gP10Page_1
                        .sendInputPlaceholder("请输入...", name)
                        .clickSpan("搜索").sleepForSeconds(2)
                        .secondTask(name)
                        .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

                carry(gP14Page, name);
                break;
            }
        }
    }

    public void carry(GP14Page gP14Page, String name) throws IllegalAccessException, InstantiationException, InterruptedException {
        String project_company = "-卖麦芽糖的-上海麦芽糖公司";

        EBFA08Page eBFA08Page = (EBFA08Page) gP14Page
                .secondTask(name)
                .switchToNewIframe(2, EBFA08Page.class).sleepForSeconds(3);

        String message = eBFA08Page.clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告
                .div_Value(" 添加推荐报告成功 ");

        if (message.equals("添加推荐报告成功")) {
            EB0701Page eB0701Page = (EB0701Page) eBFA08Page
                    .switchToNewIframe(3, EB0701Page.class).sleepForSeconds(3);

            eB0701Page.i_classClick("icon-btn ivu-icon ivu-icon-undefined icon-close2");//点击关闭

            eBFA08Page = (EBFA08Page) eBFA08Page
                    .switchToNewIframe(2, EBFA08Page.class).sleepForSeconds(3);
        }

        GP14Page gP14Page_1 = (GP14Page) eBFA08Page.i_classClick("icon-btn ivu-icon bole icon-close2")//点击关闭
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

        GP10Page gP10Page_3 = (GP10Page) gP14Page_4.i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        BdHomePage bdHomePage_1 = (BdHomePage) gP10Page_3.i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
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
