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

//王敏
public class EBFA02确认入库_项目经历_校验数据 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException, InvocationTargetException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickMenus("\n" +
                        "          中文简历库", "简历搜索")//点击菜单栏
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        int randomNumb = 1+ Public.generateNumber1(1000);//1-1000位随机数
        int sex_numb = 1 + Public.generateNumber1(2);//1-2位随机数
        String sex_str = "";

        int age_numb = 20 + Public.generateNumber1(80);//20-99位随机数
        String age_str = age_numb + "";

        String name="王敏"+randomStr;
        String phone="13485527609"+randomStr;
        String mailbox="65229727@qq.com"+randomStr;
        String companyName="扬州咸鸭蛋公司"+randomStr;
        String project="项目描述"+randomStr;

        String mustKeywords = "13585527609";

        EBFA02Page eBFA02Page = (EBFA02Page) eBFA04Page
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)

                .sendInputPlaceholder("多个公司名称用空格隔开","上海泛太平洋房地产公司")
                .checkCurrentCompany()//勾选 目前公司框

                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA02Page.class).sleepForSeconds(2);

        EBFA04Page eBFA04Page_1 = (EBFA04Page)eBFA02Page.clearInput("请输入姓名")//清掉原来姓名的值
                .sendInputPlaceholder("请输入姓名",name)//输入姓名

                .clearInput("请输入联系电话")//清掉原来手机
                .sendInputPlaceholder("请输入联系电话",phone)//输入手机值

                .clearInput("请输入电子邮箱")//清掉原来邮箱
                .sendInputPlaceholder("请输入电子邮箱",mailbox)//输入邮箱值

                .clearInput("请输入公司名称")//清掉原来公司名称
                .sendInputPlaceholder("请输入公司名称",companyName)//输入公司名称

                .label_followingDiv_clickimg("目前职能：")//点击目前职能的icon
                .functionSingleComponent()//选择职能组件

                .label_followingDiv_clickimg("所在行业：")//点击所在行业的icon
                .industryComponent()//选择行业组件

                .deleteBtn()//点击第三份工作经历的 删除按钮
                .label_followingDiv_clickInput("就读时间：").sleepForSeconds(1)//点击教育经历的 开始时间框
                .calendar_months_label("就读时间：")//选择教育时间
                .label_followingDiv_clickLabel("就读时间：")//勾选至今

                .clearProject()//清除项目内容
                .sleepForSeconds(1)
                .sendProject(project)//输入项目内容

                .clickSpan("添加到收藏夹").sleepForSeconds(1)//点击【添加到收藏夹】按钮
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(2);

                EBFA08Page eBFA08Page=(EBFA08Page)eBFA04Page_1.secondTask("清空").sleepForSeconds(1)//点击清空按钮
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",phone)//输入手机号
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        EB0301Page eB0301Page=(EB0301Page)eBFA08Page
                .checkResume_project(project)//校对简历详情里的 项目内容
                .clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告
                .Span_Value("生成推荐报告成功")//框架上 提示生成推荐报告成功
                .Li_click("推荐报告")//切换 推荐报告栏
                .sleepForSeconds(2)
                .click_Recommend()//点击  查看报告
                .switchToNewIframe(1, EB0301Page.class).sleepForSeconds(2);

        eB0301Page.checkRecommendation_project(project);//获取到 项目经历的值，就验证成功

    }
}
