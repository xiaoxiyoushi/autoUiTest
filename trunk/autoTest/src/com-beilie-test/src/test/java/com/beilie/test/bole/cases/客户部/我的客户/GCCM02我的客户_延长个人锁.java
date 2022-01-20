package com.beilie.test.bole.cases.客户部.我的客户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.*;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

/*
添加沟通记录 延长锁时间15天
 */
public class GCCM02我的客户_延长个人锁 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657224", "1").sleepForSeconds(3);

        GCCM02Page gCCM02Page = (GCCM02Page) bdHomePage.clickMenus("\n" +
                "          客户管理", "我的客户")
                .switchToNewIframe1("GCCM02", GCCM02Page.class).sleepForSeconds(2);

        String clientName = "北京维达公司" + Public.generateString(8);

        GCCM01Page gCCM01Page = (GCCM01Page) gCCM02Page
                .button_classClick("pointer primary_color_btn add_btn")
                .switchToNewIframe(0, GCCM01Page.class).sleepForSeconds(1);

        GCCM02Page gCCM02Page_1 = (GCCM02Page) gCCM01Page
                .inputClientName(clientName) //输入公司名称
                .selectClient()  //选择客户来源
                .selectIndustry() //选择所属行业
                .industryComponent()//行业公共组件
                .selectCity()  //选择城市
                .workPlaceComponent()//地点公共组件
                .checkedLock()
                .clickAddClient().sleepForSeconds(1)
                .checkTips_lock().sleepForSeconds(1)
                .i_classClick("icon-btn ivu-icon bole icon-close2")
                .switchToNewIframe1("GCCM02", GCCM02Page.class).sleepForSeconds(2);

        GC01Page gC01Page = (GC01Page) gCCM02Page_1
                .divClass("ivu-input-group-append ivu-input-search").sleepForSeconds(2)//点击【搜索】按钮
                .table_td_spanClick_many(1, 0, 0)//.clickSpan(clientName)
                .switchToNewIframe(0, GC01Page.class).sleepForSeconds(1);//跳到GC01客户详情-基本信息页面；

        GC02Page gc02Page = (GC02Page) gC01Page
                .addContact().sleepForSeconds(1)//点击【新增联系人】
                .switchToNewIframe(1, GC02Page.class).sleepForSeconds(1);//跳到GC02添加客户联络人页面；

        GC01Page gc01Page1 = (GC01Page) gc02Page.inputName("王明")
                .inputPhone("13370273782")
                .inputEmail("28068013655@qq.cc")
                .clickSave()//保存客户联系人成功
                .switchToNewIframe(0, GC01Page.class).sleepForSeconds(1);//跳到GC01客户详情-基本信息页面；

        GC04Page gc04Page = (GC04Page) gc01Page1
                .selectNavigationBar("客户联络人").sleepForSeconds(3) //选中客户联系人栏
                .hoverCommunicationBtn("沟通").sleepForSeconds(1)//点击沟通按钮
                //.selectOperating("沟通")//选中沟通项
                .switchToNewIframe(1, GC04Page.class).sleepForSeconds(1);//跳到GC04添加客户沟通记录页面

        GC01Page gc01Page_1 = (GC01Page) gc04Page.addCommunicationInfor()
                .clickSaveBtn()
                .switchToNewIframe(0, GC01Page.class).sleepForSeconds(1);//跳到GC01客户详情-基本信息页面；

        GCCM02Page gCCM02Page_2 = (GCCM02Page) gc01Page_1
                .closePage()//关闭“GC01客户详情-基本信息”页面
                .switchToNewIframe1("GCCM02", GCCM02Page.class).sleepForSeconds(2);

        GC01Page gC01Page_1 = (GC01Page) gCCM02Page_2
                .table_td_spanClick_many(1, 0, 0)//点击客户名称
                .switchToNewIframe(0, GC01Page.class).sleepForSeconds(1);

        gC01Page_1.checkNoLockCutdown().sleepForSeconds(1);

    }
}

