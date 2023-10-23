package com.beilie.test.bole.cases.项目部.项目执行;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EQ.EQQB05Page;
import com.beilie.test.bole.pages.GP.GPPC01Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.*;
import org.testng.annotations.Test;

public class _02GP10项目详情_项目执行_到新建Offer extends BoleBase {
    @Test
    public void run() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage1 = login();
        process(bdHomePage1);
    }

    public BdHomePage login() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);
        return bdHomePage;
    }

    public void process(BdHomePage bdHomePage) throws IllegalAccessException, InstantiationException, InterruptedException {
        bdHomePage.closeHideMenue().sleepForSeconds(1);//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject().sleepForSeconds(1)//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .inputClientName("请输入项目名称", "卖麦芽糖的")//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        GP14Page gP14Page = (GP14Page) gP10Page
                .Li_click("已推荐").sleepForSeconds(2)
                .clickName()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP12Page gP12Page = (GP12Page) gP14Page.clickSpan("创建面试").sleepForSeconds(1)
                //在创建面试小弹窗，点击【确定】按钮
                .tanchuang_quedingButton_click()
                .switchToNewIframe(2, GP12Page.class).sleepForSeconds(3);

        GP14Page gP14Page_1 = (GP14Page) gP12Page.sendInputPlaceholder("请输入", "赵面试官")
                .selectTomorrow("请选择")
                .label_followingDiv_clickInput("面试地址：").sleepForSeconds(2)
                .h2_inputClick("常用地址中选择并添加到面试地址")
                .labelClick("初试")
                .labelClick("面试")
                .label_followingDiv_clickInput("提醒对象：").sleepForSeconds(1)
                //.clickSpan("四部顾问1号")
                .selectReminder()
                //.secondTask("四部顾问1号")
                .h2_divParent_followingdiv_Click("请选择：", "gp12_reminderComfirm")
                .clickSpan("保存").sleepForSeconds(1)
                .spanClick("gp12_submit")
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);


        GP54Page gP54Page = (GP54Page) gP14Page_1
                //点击【确认到场情况-高超xxxx-卖麦芽糖的-上海麦芽糖公司】按钮
                .confirmAttendanceButton_click()
                .switchToNewIframe(2, GP54Page.class).sleepForSeconds(3);

        GP52Page gP52Page = (GP52Page) gP54Page.clickInputPlaceholder("请选择时间")
                //.scrollBar().sleepForSeconds(1)
                .selectTime().sleepForSeconds(1)
                .spanClick("gp54_submit").sleepForSeconds(2)
                //.clickSubmit()
                .switchToNewIframe(2, GP52Page.class).sleepForSeconds(3);

        EQQB05Page eQQB05Page = (EQQB05Page) gP52Page
                //.secondTask("去完成>>>")
                .em_click("gp52_goFinish")
                .switchToNewIframe(3, EQQB05Page.class).sleepForSeconds(3);

        GP52Page gP52Page_1 = (GP52Page) eQQB05Page
                .clickSpan("保存").sleepForSeconds(1)
                .clickSpan("是")
                .switchToNewIframe(2, GP52Page.class).sleepForSeconds(3);

        GP14Page gP14Page_3 = (GP14Page) gP52Page_1
                //.clickSubmit()
                .buttonClass_click("gp52_submit_class")
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP53Page gP53Page = (GP53Page) gP14Page_3
                //点击【提交企业反馈-高超DmftjUOv-卖麦芽糖的-上海麦芽糖公司】按钮
                .carryButton_click()
                .sleepForSeconds(2)
                .switchToNewIframe(2, GP53Page.class).sleepForSeconds(1);

        EQQB05Page eQQB05Page_1 = (EQQB05Page) gP53Page
                .em_click("gp52_goFinish")
                //.secondTask("去完成>>>")
                .switchToNewIframe(3, EQQB05Page.class).sleepForSeconds(3);

        GP53Page gP53Page_1 = (GP53Page) eQQB05Page_1
                .clickSpan("保存").sleepForSeconds(1)
                .clickSpan("是")
                .switchToNewIframe(2, GP53Page.class).sleepForSeconds(3);

        GP14Page gP14Page_5 = (GP14Page) gP53Page_1
                .buttonClass_click("gp52_submit_class")
                // .clickSubmit()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GPPC01Page gPPC01Page = (GPPC01Page) gP14Page_5
                .clickSpan("签订offer").sleepForSeconds(1)//点击【签订offer】按钮
                .labelClick(" 进行背景调查")
                //在“请确定是否进行背景调查”弹窗，点击【确定】按钮
                .button_classClick("ivu-btn ivu-btn-primary ivu-btn-large").sleepForSeconds(1)
                //在签订offer小弹窗，点击【确定】按钮
                .tanchuang_quedingButton_click().sleepForSeconds(1)
                .switchToNewIframe(2, GPPC01Page.class).sleepForSeconds(1);

        GP14Page gP14Page_6 = (GP14Page) gPPC01Page
                .i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(1);

        GP10Page gP10Page_1 = (GP10Page) gP14Page_6
                .i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(1);

        gP10Page_1.i_classClick("icon-btn ivu-icon bole icon-close2")//点击X
                .sleepForSeconds(1);
    }
}
