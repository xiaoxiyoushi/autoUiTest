package com.beilie.test.bole.pages;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.open.hunters.pages.LoginPage;
import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/*
bd首页
 */
public class BdHomePage extends Public<BdHomePage> {
    //点击二级菜单
    //点击左侧菜单栏，客户管理-添加客户、我的客户
    public BdHomePage clickClientManger(String ClientMangerMenu, int n) throws InterruptedException {
        Element element = this.findById("home_menus_menuId")
                .findListByClassName("ivu-menu-submenu").get(n);
        element.click();//点击左侧菜单栏，客户管理
        this.sleepForSeconds(1);

        int m = element.findListByTagName("li").size();

        for (int i = 0; i < m; i++) {
            String name = this.findById("home_menus_menuId")
                    .findListByClassName("ivu-menu-submenu").get(n)
                    .findListByTagName("a").get(i).getText();

            if (name.equals(ClientMangerMenu)) {
                this.findById("home_menus_menuId")
                        .findListByClassName("ivu-menu-submenu").get(n)
                        .findListByTagName("a").get(i).click();
                break;
            }
        }

        return this;
    }

    //所有菜单
    public BdHomePage clickMenu(String menuVariable) throws InterruptedException {
        //List<Element> elements=this.findById("home_menus_menuId").findListByXPath("//child::li");

        List<Element> elements = this.findById("home_menus_menuId").findListByTagName("li");
        int size = elements.size();

        for (int i = 0; i < size; i++) {
            String menu = elements.get(i).getText();
            if (menu.equals(menuVariable)) {
                elements.get(i).click();
                break;
            }
        }
        return this;
    }

    //点击一级菜单、二级菜单
    public BdHomePage clickMenus(String firstMenu, String secondMenu) throws InterruptedException {
        this.findByXPath("//span[text()=\"" + firstMenu + "\"]").click();
        this.sleepForSeconds(1);
        this.findByXPath("//a[text()=\"" + secondMenu + "\"]").click();
        return this;
    }

    //点击菜单
    public BdHomePage clickSingleMenu(String secondMenu) {
        this.findByXPath("//a[text()=\"" + secondMenu + "\"]").click();
        return this;
    }

    //点击菜单 我的合同
    public BdHomePage clickMenuMyContract() throws InterruptedException {
        //this.findByXPath("//*[@id=\"home_menus_menuId\"]/li[8]/a").click();
        this.findByXPath("//span[text()=\" 客户合同\"]").click();
        this.findByXPath("//a[text()=\"我的合同\"]").click();
        return this;
    }

    /**
     * 当一级菜单已经点开，直接点击二级菜单
     */
    public BdHomePage clickSecondMenu(String ClientMangerMenu, int n) throws InterruptedException {
        Element element = this.findById("home_menus_menuId")
                .findListByClassName("ivu-menu-submenu").get(n);
        this.sleepForSeconds(1);

        int m = element.findListByTagName("li").size();

        for (int i = 0; i < m; i++) {
            String name = this.findById("home_menus_menuId")
                    .findListByClassName("ivu-menu-submenu").get(n)
                    .findListByTagName("a").get(i).getText();

            if (name.equals(ClientMangerMenu)) {
                this.findById("home_menus_menuId")
                        .findListByClassName("ivu-menu-submenu").get(n)
                        .findListByTagName("a").get(i).click();
                break;
            }
        }

        return this;
    }

    //只有一级菜单,插件安装
    public BdHomePage singleMenu() {
        this.findByXPath("//a[text()=\"插件安装\"]").click();
        return this;
    }

    public BdHomePage clickSpan(String str) {
        this.findByXPath("//span[text()=\"" + str + "\"]").click();
        return this;
    }

    //关闭隐藏菜单弹窗
    /*public BdHomePage closeHideMenue() throws InterruptedException {
        this.waitFor(10, d -> {
            this.findByXPath("//div[@class=\"ef-modal v-transfer-dom\"]//i").click();
            return Boolean.TRUE;
        });
        return this;
    }*/

    public BdHomePage closeHideMenue() throws InterruptedException {
        //显示等待
        this.waitFor(30,"//div[text()=\"不常用的菜单是否隐藏？\"]");
        this.findByXPath("//div[@class=\"ef-modal v-transfer-dom\"]//i").click();
        return this;
    }

    //点击一级菜单：合伙人
    public BdHomePage clickFirstMenu_copartner() throws InterruptedException {
        this.waitFor(30,"//span[text()=\" 合伙人\"]");
        this.findByXPath("//span[text()=\" 合伙人\"]").click();
        return this;
    }

    //点击二级菜单：合伙人架构
    public BdHomePage clickSecondMenu_copartnerSchema() throws InterruptedException {
        this.findByXPath("//a[text()=\"合伙人架构\"]").click();
        return this;
    }

    //点击一级菜单：员工信息管理
    public BdHomePage clickFirstMenu_memberInforManage() throws InterruptedException {
        this.waitFor(30,"//span[text()=\" 员工信息管理\"]");
        this.findByXPath("//span[text()=\" 员工信息管理\"]").click();
        return this;
    }

    //点击二级菜单：员工信息
    public BdHomePage clickSecondMenu_memberInfor() throws InterruptedException {
        this.findByXPath("//a[text()=\"员工信息\"]").click();
        return this;
    }

    //点击一级菜单：项目管理
    public BdHomePage clickFirstMenu_projectManage() throws InterruptedException {
        this.waitFor(30,"//span[text()=\" 项目管理\"]");
        this.findByXPath("//span[text()=\" 项目管理\"]").click();
        return this;
    }

    //点击二级菜单：我的项目
    public BdHomePage clickSecondMenu_myProject() throws InterruptedException {
        this.findByXPath("//a[text()=\"我的项目\"]").click();
        return this;
    }

    //点击二级菜单：收款计划
    public BdHomePage clickSecondMenu_collection () throws InterruptedException {
        this.findByXPath("//a[text()=\"收款计划\"]").click();
        return this;
    }

    //点击一级菜单：人才库
    public BdHomePage clickFirstMenu_candidateLibrary() throws InterruptedException {
        this.findByXPath("//span[text()=\" 人才库\"]").click();
        return this;
    }

    //点击一级菜单：中文简历库
    /*public BdHomePage clickFirstMenu_resumeLibrary() throws InterruptedException {
        this.waitFor(10, d -> {
            this.findByXPath("//span[text()=\" 中文简历库\"]").click();
            return Boolean.TRUE;
        });
        return this;
    }*/
    public BdHomePage clickFirstMenu_resumeLibrary() throws InterruptedException {
        //显示等待
       this.waitFor(30,"//span[text()=\" 中文简历库\"]");
       this.findByXPath("//span[text()=\" 中文简历库\"]").click();
        return this;
    }

    //点击二级菜单：上传简历
    public BdHomePage clickSecondMenu_upResume() throws InterruptedException {
        this.findByXPath("//a[text()=\"上传简历\"]").click();
        return this;
    }

    //点击二级菜单：简历搜索
    public BdHomePage clickSecondMenu_resumeSearch() throws InterruptedException {
        this.waitFor(30,"//a[text()=\"简历搜索\"]");
        this.findByXPath("//a[text()=\"简历搜索\"]").click();
        return this;
    }

    //点击二级菜单：人选搜索
    public BdHomePage clickSecondMenu_candidateSearch() throws InterruptedException {
        this.waitFor(30,"//a[text()=\"人选搜索\"]");
        this.findByXPath("//a[text()=\"人选搜索\"]").click();
        return this;
    }

    //点击二级菜单：我的收藏夹
    public BdHomePage clickSecondMenu_myFavorities() throws InterruptedException {
        this.waitFor(30,"//a[text()=\"我的收藏夹\"]");
        this.findByXPath("//a[text()=\"我的收藏夹\"]").click();
        return this;
    }

    //点击一级菜单：外呼管理
    public BdHomePage clickFirstMenu_callManage() throws InterruptedException {
        this.findByXPath("//span[text()=\" 外呼管理\"]").click();
        return this;
    }

    //点击二级菜单：外呼部门分配
    public BdHomePage clickSecondMenu_callDepartment() throws InterruptedException {
        this.findByXPath("//a[text()=\"外呼部门分配\"]").click();
        return this;
    }

    //点击一级菜单：实时统计数据项
    public BdHomePage clickFirstMenu_tongji() throws InterruptedException {
        this.findByXPath("//span[text()=\" 实时统计数据项\"]").click();
        return this;
    }

    //点击二级菜单：实时统计
    public BdHomePage clickSecondMenu_tongji() throws InterruptedException {
        this.findByXPath("//a[text()=\"实时统计\"]").click();
        return this;
    }

    //点击一级菜单：流程管理
    public BdHomePage clickFirstMenu_liuchen() throws InterruptedException {
        this.findByXPath("//span[text()=\" 流程管理\"]").click();
        return this;
    }

    //点击二级菜单：任务中心
    public BdHomePage clickSecondMenu_center() throws InterruptedException {
        this.findByXPath("//a[text()=\"任务中心\"]").click();
        return this;
    }

    //点击一级菜单：客户管理
    public BdHomePage clickFirstMenu_clientManage() throws InterruptedException {
        this.waitFor(30,"//span[text()=\" 客户管理\"]");
        this.findByXPath("//span[text()=\" 客户管理\"]").click();
        return this;
    }

    //点击二级菜单：添加客户
    public BdHomePage clickSecondMenu_addClient() throws InterruptedException {
        this.findByXPath("//a[text()=\"添加客户\"]").click();
        return this;
    }

    //点击二级菜单：我的客户
    public BdHomePage clickSecondMenu_myClient() throws InterruptedException {
        this.findByXPath("//a[text()=\"我的客户\"]").click();
        return this;
    }

    //点击二级菜单：项目客户
    public BdHomePage clickSecondMenu_projectClient() throws InterruptedException {
        this.findByXPath("//a[text()=\"项目客户\"]").click();
        return this;
    }

    //点到菜单：客户合同
    public BdHomePage clickFirstMenu_clientContract() throws InterruptedException {
        this.findByXPath("//span[text()=\" 客户合同\"]").click();
        return this;
    }

    //点开菜单
    public BdHomePage clickMenu(String firstMenu,String secondMenu) throws InterruptedException {
        spanClick(firstMenu).sleepForSeconds(1);//点击一级菜单
        aClick(secondMenu);//点击二级菜单
        return this;
    }

    //点开二级菜单：我的合同
    public BdHomePage clickMenu_myContract() throws InterruptedException {
        spanClick("firstMenu_clientContract").sleepForSeconds(1);//点击一级菜单“客户合同”
        aClick("secondMenu_myContract");//点击二级菜单“我的合同”
        return this;
    }

    //点开二级菜单：待审核的合同
    public BdHomePage clickMenu_reviewedContract() throws InterruptedException {
        spanClick("firstMenu_clientContract").sleepForSeconds(1);//点击一级菜单“客户合同”
        aClick("secondMenu_reviewedContract");//点击二级菜单“待审核的合同”
        return this;
    }

    //点开二级菜单：项目组绩效汇总
    public BdHomePage clickMenu_departMerits() throws InterruptedException {
        spanClick("firstMenu_reportManage").sleepForSeconds(1);//点击一级菜单“报表管理”
        aClick("secondMenu_departMerits");//点击二级菜单“项目组绩效汇总”
        return this;
    }

    //点开二级菜单：过程绩效汇总
    public BdHomePage clickMenu_processMerits() throws InterruptedException {
        spanClick("firstMenu_reportManage").sleepForSeconds(1);//点击一级菜单“报表管理”
        aClick("secondMenu_processMerits");//点击二级菜单“过程绩效汇总”
        return this;
    }

    //点开二级菜单：收款计划
    public BdHomePage clickMenu_collection() throws InterruptedException {
        spanClick("firstMenu_projectManage").sleepForSeconds(1);//点击一级菜单“项目管理”
        aClick("secondMenu_collection");//点击二级菜单“收款计划”
        return this;
    }

    //点开二级菜单：假期申请
    public BdHomePage clickMenu_holiday() throws InterruptedException {
        spanClick("firstMenu_holidayManage").sleepForSeconds(1);
        aClick("secondMenu_holidayApply");
        return this;
    }

   //页面名称叫新员工欢迎信
    public BdHomePage newEmployee() throws InterruptedException {
        String str=this.findByXPath("//div[@class=\"ivu-modal ivu-modal-fullscreen\"]//div[@class=\"ivu-modal-header-inner\"]").getText();
        Assert.assertEquals("新员工欢迎信",str);

        return this;
    }
}
