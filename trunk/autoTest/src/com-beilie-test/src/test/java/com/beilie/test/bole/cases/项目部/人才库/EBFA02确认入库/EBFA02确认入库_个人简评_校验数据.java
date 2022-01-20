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

//汤张蔚
public class EBFA02确认入库_个人简评_校验数据 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, InvocationTargetException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_resumeSearch()//点击二级菜单：简历搜索
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        int randomNum = Public.generateNumber1(20);//0-19位随机数
        int sex_numb = 1 + Public.generateNumber1(2);//1-2位随机数
        String sex_str = "";

        int age_numb = 20 + Public.generateNumber1(80);//20-99位随机数
        String age_str = age_numb + "";

        String phone = "13390833" + randomStr;
        String email = "200587315@qq.coma1ShAiMj";
        String mustKeywords = "13823238767";

        EBFA02Page eBFA02Page = (EBFA02Page) eBFA04Page
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)
                .sendInputPlaceholder("多个公司名称用空格隔开", "高邮咸鸭蛋公司")
                .checkCurrentCompany()//勾选 目前公司框
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA02Page.class).sleepForSeconds(2);

        String personalIntroduce = "1.拥有三级心理咨询师证书;计算机二级VF证书;英语CET-4证书" + randomStr;
        EBFA04Page eBFA04Page_1 = (EBFA04Page) eBFA02Page
                .clearInput("请输入联系电话")//清掉原来手机
                .sendInputPlaceholder("请输入联系电话", phone)//输入手机值

                .clearInput("请输入电子邮箱")//清掉原来邮箱
                .sendInputPlaceholder("请输入电子邮箱", email)//输入邮箱值

                .clearTextarea("请输入个人简评")
                .textarea_sendkeys("请输入个人简评", personalIntroduce)

                .clearInput("请输入公司名称")//清掉原来公司名称
                .sendInputPlaceholder("请输入公司名称", "扬州咸鸭蛋公司")//输入公司名称

                .i_classClick("ivu-icon bole select-editor-input__icon icon-function cursor-pointer").sleepForSeconds(1)//点击目前职能的icon
                .functionSingleComponent()//选择职能组件

                .inputPlaceholder_parentDiv_parentDiv_iClick("请选择公司行业").sleepForSeconds(1)//点击所在行业的icon
                .industryComponent()//行业公共组件

                .clickSpan("添加到收藏夹").sleepForSeconds(1)//点击【添加到收藏夹】按钮
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(2);

        EBFA08Page eBFA08Page = (EBFA08Page) eBFA04Page_1.secondTask("清空").sleepForSeconds(1)//点击清空按钮
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", phone)//输入手机号
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        EB0301Page eB0301Page = (EB0301Page) eBFA08Page
                .checkResume_personalIntroduce(personalIntroduce)
                .clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告
                .div_getValue(" 生成推荐报告成功 ")//框架上 提示生成推荐报告成功
                .Li_click("推荐报告").sleepForSeconds(2)//切换 推荐报告栏
                .click_Recommend()//点击  查看报告
                .switchToNewIframe(1, EB0301Page.class).sleepForSeconds(2);

        eB0301Page.checkRecommendation_personalIntroduce("个人简评");

    }
}
