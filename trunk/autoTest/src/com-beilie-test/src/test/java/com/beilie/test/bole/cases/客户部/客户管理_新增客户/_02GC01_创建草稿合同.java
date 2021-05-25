package com.beilie.test.bole.cases.客户部.客户管理_新增客户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.GC.*;
import org.junit.Test;

public class _02GC01_创建草稿合同 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        //BdHomePage bdHomePage = login("68658220", "1").sleepForSeconds(3);
        BdHomePage bdHomePage = login("68657224", "1").sleepForSeconds(3);

        //GCCM02Page gCCM02Page=(GCCM02Page)bdHomePage.clickClientManger("我的客户",1)
        GCCM02Page gCCM02Page=(GCCM02Page)bdHomePage.clickMenus(" 客户管理","我的客户")
                .switchToNewIframe1("GCCM02",GCCM02Page.class).sleepForSeconds(2);

        GC01Page gc01Page=(GC01Page)gCCM02Page.clickProtectInput()
                  .selectUnprotected(1).sleepForSeconds(1)
                  .clickOneClientName()
                  .switchToNewIframe(0,GC01Page.class).sleepForSeconds(1);

        GC02Page gc02Page=(GC02Page)gc01Page
                .clickProtect()//点击保护
                .addContact().sleepForSeconds(1)//点击【新增联系人】
                .switchToNewIframe(1, GC02Page.class).sleepForSeconds(1);//跳到GC02添加客户联络人页面；

        GC01Page gc01Page1=(GC01Page)gc02Page.inputName("王明")
                .inputPhone("13370273782")
                .inputEmail("28068013655@qq.cc")
                .clickSave()//保存客户联系人成功
                .switchToNewIframe(0,GC01Page.class).sleepForSeconds(1);//跳到GC01客户详情-基本信息页面；

        GC04Page gc04Page=(GC04Page)gc01Page1
                          .selectNavigationBar("客户联络人").sleepForSeconds(3) //选中客户联系人栏
                          .hoverCommunicationBtn("沟通").sleepForSeconds(1)//点击沟通按钮
                          //.selectOperating("沟通")//选中沟通项
                          .switchToNewIframe(1,GC04Page.class).sleepForSeconds(1);//跳到GC04添加客户沟通记录页面

        GC01Page gc01Page2=(GC01Page)gc04Page.addCommunicationInfor()
                          .clickSaveBtn()
                          .switchToNewIframe(0,GC01Page.class).sleepForSeconds(1);//跳到GC01客户详情-基本信息页面；

        GC11Page gC11Page=(GC11Page)gc01Page2
                .clickEdit()//点击【编辑】
                .switchToNewIframe(1, GC11Page.class).sleepForSeconds(1);//跳到GC11编辑客户信息页面；

        GC01Page gc01Page3=(GC01Page)gC11Page.chooseClientSource()
                .clickIndustry()//选择客户来源
                .industryComponent()//行业公共组件
                .clickAddress()//选择联系地址
                .workPlaceComponent()//地点公共组件
                .inputAddress()
                .clickSave()//点击确定
                .switchToNewIframe(0,GC01Page.class).sleepForSeconds(1);//跳到GC01客户详情-基本信息页面；

        gc01Page3.addNewContact().sleepForSeconds(2);
    }
}
