package com.beilie.test.bole.cases.项目部.项目执行;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPPC01Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.*;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

public class _03GP10项目详情_项目执行_提交offer到提交入职 extends BoleBase {
    @Test
    public void run() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage1 = login("ccl_userName", "ccl_password").sleepForSeconds(3);
        process(bdHomePage1);
    }

    public BdHomePage login() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);
        return bdHomePage;
    }

    public void process(BdHomePage bdHomePage) throws IllegalAccessException, InstantiationException, InterruptedException{
        bdHomePage.closeHideMenue().sleepForSeconds(1);//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject().sleepForSeconds(1)//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String name = "高超" + randomStr;
        String phone = "13717767381" + randomStr;
        String mailbox = "458324803@qq.com" + randomStr;

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .inputClientName("请输入项目名称", "卖麦芽糖的")//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        GP14Page gP14Page = (GP14Page) gP10Page
                .Li_click("企业录用").sleepForSeconds(2)
                .clickName()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GPPC01Page gPPC01Page = (GPPC01Page) gP14Page
                //点击【跟踪入职情况-高超OjqzHV1M-卖麦芽糖的-上海麦芽糖公司】按钮
                .carryButton_click()
                    .switchToNewIframe(2, GPPC01Page.class).sleepForSeconds(3);

        GP14Page gP14Page_1 = (GP14Page) gPPC01Page
                 .uploadBackground("C:\\Users\\86182\\Desktop\\resume\\周贤伍简历-招聘经理.pdf").sleepForSeconds(5)
                .spanClick("gppc01_submit")
                //.clickSure()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(1);

        GP22Page gP22Page = (GP22Page) gP14Page_1
                //点击【审核背调信息-高超OjqzHV1M-卖麦芽糖的-上海麦芽糖公司】按钮
                .carryButton_click()
                .switchToNewIframe(2, GP22Page.class).sleepForSeconds(3);

        GP14Page gP14Page_3 = (GP14Page) gP22Page
                .clickButton("通过")
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP25Page gP25Page = (GP25Page) gP14Page_3
                //点击【提交背调反馈结果-高超OjqzHV1M-卖麦芽糖的-上海麦芽糖公司】按钮
                .carryButton_click()
                .switchToNewIframe(2, GP25Page.class).sleepForSeconds(3);

        GP11Page gP11Page = (GP11Page) gP25Page
                .labelClick("通过")
                .clickButton("录用")
                .switchToNewIframe(2, GP11Page.class).sleepForSeconds(3);

        GP14Page gP14Page_5 = (GP14Page) gP11Page
                .label_followingDiv_input("年薪：", "65000")
               // .scrollBar()
                .selectTime_Many("提醒：")
                .confirmTime("确认日期：",1)
                .confirmTime("预计上班日期：",2)
                .clickStatusInput("状态：")
                .Li_click("录用")
                .label_followingDiv_clickInput("提醒对象：").sleepForSeconds(1)
                .labelClick(" 兰帝(兰帝)")
                .clickSpan("确定").sleepForSeconds(1)
                //.clickConfirm().sleepForSeconds(1)
                .clickSpan("保存").sleepForSeconds(1)
                .clickSubmit()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP27Page gP27Page = (GP27Page) gP14Page_5
                //点击【跟踪入职情况-高超OjqzHV1M-卖麦芽糖的-上海麦芽糖公司】按钮
                .confirmAttendanceButton_click()
                .switchToNewIframe(2, GP27Page.class).sleepForSeconds(3);

        GP14Page gP14Page_6 = (GP14Page) gP27Page
                .labelClick("已入职").sleepForSeconds(1)
                //.clickSpan("submit")
                .button_classClick("ivu-btn ivu-btn-primary")
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP13Page gP13Page = (GP13Page) gP14Page_6
                .clickSpan("创建入职")
                //在 创建入职 弹窗，点击【确定】按钮
                .tanchuang_quedingButton_click()
                .switchToNewIframe(2, GP13Page.class).sleepForSeconds(3);

        GP14Page gP14Page_7 = (GP14Page) gP13Page
                .clickInputPlaceholder("入职时间").sleepForSeconds(1)
                //.label_calendar_today("入职时间")
                .entryTime_click(0).sleepForSeconds(1)//入职时间
                .labelClick("保证期结束时间")
                .clickInputPlaceholder("试用期结束").sleepForSeconds(1)
                //.scrollBar().sleepForSeconds(1)
                //.label_calendar_today("保证期结束时间")
                .entryTime_click(1).sleepForSeconds(1)
                .labelClick("保证期结束时间")

                .clickInputPlaceholder("提醒时间").sleepForSeconds(2)
                //.label_calendar_today("提醒时间")
                .entryTime_click(2)
                .labelClick("保证期结束时间")

                .label_followingDiv_clickInput("提醒对象")
                .div_followingDiv_input_click("人员：")
                .sure_click("提醒对象")
                //.scrollBar()
                .div_class_buttons("ef-modal-page-footer ef-page-footer").sleepForSeconds(1)
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(1);

        GP10Page gP10Page_1 = (GP10Page) gP14Page_7
                .i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(1);


        gP10Page_1.i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .sleepForSeconds(1);
    }


}
