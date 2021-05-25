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
//钱程
public class EBFA02确认入库_教育经历_校验数据 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException, InvocationTargetException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickMenus(" 中文简历库", "简历搜索")//点击菜单栏
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        int randomNumb = 1+ Public.generateNumber1(1000);//1-1000位随机数
        int sex_numb = 1 + Public.generateNumber1(2);//1-2位随机数
        String sex_str = "";

        int age_numb = 20 + Public.generateNumber1(80);//20-99位随机数
        String age_str = age_numb + "";

        String name="钱程"+randomStr;
        String phone="13491182103"+randomStr;
        String mailbox="15874137302@163.com"+randomStr;
        String companyName="扬州咸鸭蛋公司"+randomStr;
        String colleage="中国大学"+randomStr;
        String major="中国好专业"+randomStr;

        String mustKeywords = "13391182103";

        EBFA02Page eBFA02Page = (EBFA02Page) eBFA04Page
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)

                .sendInputPlaceholder("多个公司名称用空格隔开","湖南格尔智慧科技有限公司")
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

                .clearInput("请输入学校名称")
                .sendInputPlaceholder("请输入学校名称",colleage)
                .clearInput("请输入专业名称")
                .sendInputPlaceholder("请输入专业名称",major)

                .clickSpan("添加到收藏夹").sleepForSeconds(1)//点击【添加到收藏夹】按钮
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(2);

        List<String> list=new ArrayList<String>();
        list.add(colleage);
        list.add(major);

        EBFA08Page eBFA08Page=(EBFA08Page)eBFA04Page_1.secondTask("清空").sleepForSeconds(1)//点击清空按钮
        .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",phone)//输入手机号
        .clickSpan("搜索").sleepForSeconds(3)
        .hoverAvatar(0).sleepForSeconds(1)//悬浮头像
        .checkResumeCard_colleage(list)//校对简历卡片的 学校、专业
        .clickAvatar(0)//点击头像
        .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        EB0301Page eB0301Page=(EB0301Page)eBFA08Page.clickSpan("展开更多").sleepForSeconds(1)
        .checkBigcardInform_education(list)
        .clickSpan("收起")
        .checkResume_education(colleage,major)//校对简历详情里的 学校名称、专业名称
        .clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告
        .Span_Value("生成推荐报告成功")//框架上 提示生成推荐报告成功
        .clickLi("推荐报告")//切换 推荐报告栏
        .sleepForSeconds(2)
        .click_Recommend()//点击  查看报告
        .switchToNewIframe(1, EB0301Page.class).sleepForSeconds(2);

        eB0301Page.checkRecommendation_education(colleage,major);//获取到 学校名称、专业名称的值，就验证成功

    }
}
