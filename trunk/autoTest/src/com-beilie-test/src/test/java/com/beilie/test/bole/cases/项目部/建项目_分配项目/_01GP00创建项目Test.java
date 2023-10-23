package com.beilie.test.bole.cases.项目部.建项目_分配项目;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.GC.GC18Page;
import com.beilie.test.bole.pages.GP.GPXX.GP00Page;
import com.beilie.test.bole.pages.GP.GPXX.GP58Page;
import com.beilie.test.bole.pages.GP.GPRP01Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class _01GP00创建项目Test extends BoleBase {
    //invocationCount 即表示该用例循环执行多少次
    @Test
    //@Parameters({"company"})
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
    //public void test (String company)throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GP58Page gp58Page=(GP58Page)bdHomePage
                .clickFirstMenu_clientManage().sleepForSeconds(1)
                .clickSecondMenu_projectClient()//点击菜单栏
                .switchToNewIframe1("GP58",GP58Page.class).sleepForSeconds(2);

        GC18Page gc18Page=(GC18Page)gp58Page
                //.sendInputPlaceholder("请输客户名称", company)
                //.clickSpan("搜索").sleepForSeconds(1)
                //.clickSpan("历史合作").sleepForSeconds(1)
                .clickClientName()
                .switchToNewIframe(0, GC18Page.class).sleepForSeconds(2);

        GP00Page gp00Page=(GP00Page)gc18Page.clickSpan("创建项目")//点击创建项目
                //try catch该客户当前无有效合同，是否继续创建
                //.div_parentDiv_parentDiv_followingDiv_spanClick("该客户当前无有效合同，是否继续创建","确定").sleepForSeconds(2)
                .switchToNewIframe(1,GP00Page.class).sleepForSeconds(2);

        String randomStr=Public.generateString(8);//8位随机字符串
        int randomNum=Public.generateNumber1(20)+1;//0-19位随机数

        GPRP01Page gPRP01Page=(GPRP01Page)gp00Page.inputProjName("市场营销企划主管"+randomStr)//输入项目名称
                .inputRecruitment(randomNum)//输入招聘人数
                .clickIndustryIcon().sleepForSeconds(1)//点击行业分类框
                 .industryComponent()//行业公共组件
                .clickFunctIcon().sleepForSeconds(1)//点击职能分类框
                .functionComponent()//选择职能组件
                /*.clickAddDepartment().sleepForSeconds(1)//添加部门
                .inputDepartment()//输入部门
                .clickAddBtn()//点击添加按钮
                .clickX("添加部门")//点击叉号*/
                .clickSpan("新增联系地址").sleepForSeconds(1)//点击新增联系地址
                .clickCheckbox()//勾选地址复选框
                .submitAddress()//提交地址
                .sleepForSeconds(1)
                .salary()//薪资
                .gender()//性别
                .workYear()//工作年限
                .age()//年龄要求
                .education()//学历要求
                .reportTo()//汇报对象
                .jobDescription()//职位描述
//                .clickSpan("\n" +
//                        "        保存\n" +
//                        "      ")

               /* .clickSpan("\n" +
                        "        提交\n" +
                        "      ").sleepForSeconds(2)*/
                .saveAndSubmit()//保存并且提交项目
                .unconfirmedEmail("邮箱尚未确认，提交后请及时联系保护BD[jackZhang1]进行确认，以免影响推荐报告的发送")//try catch
                .switchToNewIframe(1,GPRP01Page.class).sleepForSeconds(2);

                //gPRP01Page.checkInfor().sleepForSeconds(1);//核对页面文字：发布到贝猎网、企业基本信息、职位基本信息；
  }
}
