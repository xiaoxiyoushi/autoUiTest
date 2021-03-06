package com.beilie.test.bole.cases.项目部.人才库.EBFA02确认入库;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EB0301Page;
import com.beilie.test.bole.pages.EB.EBFA02Page;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
//刘敏
public class EBFA02确认入库_个人信息_校验数据 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException, InvocationTargetException{
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_resumeSearch()//点击二级菜单：简历搜索
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String randomStr= Public.generateString(8);//8位随机字符串
        int randomNum=Public.generateNumber1(20);//0-19位随机数
        int sex_numb = 1+Public.generateNumber1(2);//1-2位随机数
        String sex_str="";

        int age_numb = 20+ Public.generateNumber1(80);//20-99位随机数
        String age_str=age_numb+"";

        String name="刘敏"+randomStr;
        String phone="13390833"+randomStr;
        String mailbox="liumin-light@foxmail.com"+randomStr;
        String mustKeywords="18390833293";

        EBFA02Page eBFA02Page=(EBFA02Page)eBFA04Page
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mustKeywords)
                .sendInputPlaceholder("多个公司名称用空格隔开","高邮车逻公司")
                .checkCurrentCompany()//勾选 目前公司框
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA02Page.class).sleepForSeconds(2);

        String location=eBFA02Page.clearInput("请输入姓名")//清掉原来姓名的值
                .sendInputPlaceholder("请输入姓名",name)//输入姓名

                .click_sex(sex_numb)//点击性别，随机选择 男、女
                .clearInput("请输入年龄")//清掉原来年龄的值

                .sendInputPlaceholder("请输入年龄",age_str)//输入年龄值

                .clearInput("请输入联系电话")//清掉原来手机
                .sendInputPlaceholder("请输入联系电话",phone)//输入手机值

                .clearInput("请输入电子邮箱")//清掉原来邮箱
                .sendInputPlaceholder("请输入电子邮箱",mailbox)//输入邮箱值

                .clearInput("请输入公司名称")//清掉原来公司名称
                .sendInputPlaceholder("请输入公司名称","长沙睿展数据科技有限公司")//输入公司名称

                .i_classClick("ivu-icon bole select-editor-input__icon icon-function cursor-pointer").sleepForSeconds(1)//点击目前职能的icon
                //.label_followingDiv_clickI("目前职能：").sleepForSeconds(1)//点击目前职能的icon
                .functionSingleComponent()//选择职能组件

                /*.label_followingDiv_clickI("所在行业：")//点击所在行业的icon
                .industryComponent()//选择行业组件*/

                /*.label_followingDiv_clickI("现居住地：")//点击现居住地的icon
                .placeComponent_getValue();//获取工作地点值*/

                .input_bcakSpace("请选择现居住地",1).sleepForSeconds(1)//清掉现居住地
                .inputPlaceholder_parentDiv_parentDiv_iClick("请选择现居住地").sleepForSeconds(1)//点击现居住地的icon
                .workPlaceComponent()//选择地点组件
                .label_followingDiv_spanValue("现居住地：");//获取工作地点值

        switch (sex_numb){
            case 1:
                sex_str="男";
                break;
            case 2:
                sex_str="女";
                break;
        }

        List<String> list=new ArrayList<String>();
        list.add(name);
        list.add(phone);
        list.add(mailbox);
        list.add(sex_str);
        list.add(age_str+"岁");
        list.add(location);

        EBFA04Page eBFA04Page_1 = (EBFA04Page)eBFA02Page.clickSpan("添加到收藏夹").sleepForSeconds(3)//点击【添加到收藏夹】按钮
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(2);

        EBFA08Page eBFA08Page=(EBFA08Page)eBFA04Page_1.secondTask("清空").sleepForSeconds(1)
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",phone)//输入手机号
                .clickSpan("搜索").sleepForSeconds(3)
                .hoverAvatar(0).sleepForSeconds(1)//悬浮头像
                .checkResumeCard(list)//校对简历卡片的 姓名、电话、邮箱、性别、年龄、居住地
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

                list.remove(name);
                list.remove(phone);
                list.remove(mailbox);

                eBFA08Page.checkCardInform_contract(name,phone,mailbox)//在“EBFA08人选详情”页面，校对 人选详情卡片的姓名、手机号、邮箱
                .checkCardInform(list);//在“EBFA08人选详情”页面，校对 人选详情卡片的性别、年龄、现居住地

                list.add(mailbox);
                List<String> list_1=new ArrayList<String>();
                list_1.add("性别：");
                list_1.add("年龄：");
                list_1.add("现居住地：");
                list_1.add("电子邮箱：");

        EB0301Page eB0301Page=(EB0301Page)eBFA08Page
        .checkResume_allPersonalInform(list_1,list,phone)//校对简历详情里的 电话、性别、年龄、现居住地、邮箱
        .clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告

                //框架上 提示生成推荐报告成功
        .Li_click("推荐报告")//切换 推荐报告栏
        .sleepForSeconds(2)
        .clickSpan(name)
        .switchToNewIframe(1, EB0301Page.class).sleepForSeconds(2);

        List<String> list_2=new ArrayList<String>();
        list_2.add("姓名：");
        list_2.add("性别：");
        list_2.add("联系电话：");
        list_2.add("电子邮件：");

        List<String> list_3=new ArrayList<String>();
        list_3.add(name);
        list_3.add(sex_str);
        list_3.add(phone);
        list_3.add(mailbox);

        eB0301Page.checkRecommendation_AllpersonalInfor(list_2, list_3,location);//在“EB0301”页面，校对 人选信息的姓名、性别、现居住地、电话、邮箱

    }
}
