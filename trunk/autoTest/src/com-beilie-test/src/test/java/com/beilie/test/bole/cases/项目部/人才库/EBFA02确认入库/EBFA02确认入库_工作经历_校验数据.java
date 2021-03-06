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
//吴震之
public class EBFA02确认入库_工作经历_校验数据 extends BoleBase {
            @Test
            public void test ()throws IllegalAccessException, InstantiationException, InterruptedException, InvocationTargetException {
                BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

                bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
                EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                        .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                        .clickSecondMenu_resumeSearch()//点击二级菜单：简历搜索
                        .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

                String randomStr = Public.generateString(8);//8位随机字符串
                int randomNumb = 1+ Public.generateNumber1(1000);//1-1000位随机数
                int sex_numb = 1 + Public.generateNumber1(2);//1-2位随机数
                String sex_str = "";

                int age_numb = 20 + Public.generateNumber1(80);//20-99位随机数
                String age_str = age_numb + "";

                String name="吴震之"+randomStr;
                String phone="13307507688"+randomStr;
                String mailbox="kevin118@163.com"+randomStr;
                String companyName="扬州咸鸭蛋公司"+randomStr;
                String jobName = "中国好职位"+randomStr;
                String jobContent = "好工作 中国找"+randomStr;
                String currentSalary =Integer.toString(40000+randomNumb) ;

                String mustKeywords = "13807507688";

                EBFA02Page eBFA02Page = (EBFA02Page) eBFA04Page
                        .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)

                        .sendInputPlaceholder("多个公司名称用空格隔开","科力集团/海南微软创新中心有限公司")
                        .checkCurrentCompany()//勾选 目前公司框

                        .clickSpan("搜索").sleepForSeconds(3)
                        .clickAvatar(0)//点击头像
                        .switchToNewIframe(0, EBFA02Page.class).sleepForSeconds(2);

                eBFA02Page.clearInput("请输入姓名")//清掉原来姓名的值
                        .sendInputPlaceholder("请输入姓名",name)//输入姓名

                        .clearInput("请输入联系电话")//清掉原来手机
                        .sendInputPlaceholder("请输入联系电话",phone)//输入手机值

                        .clearInput("请输入电子邮箱")//清掉原来邮箱
                        .sendInputPlaceholder("请输入电子邮箱",mailbox)//输入邮箱值

                        .clearInput("请输入公司名称")//清掉原来公司名称
                        .sendInputPlaceholder("请输入公司名称",companyName)//输入公司名称

                        .clearInput("请输入职位名称")
                        .sendInputPlaceholder("请输入职位名称",jobName)

                        .clearInput("请输入年薪")
                        .sendInputPlaceholder("请输入年薪",currentSalary)

                        .clearTextarea("请输入工作内容")
                        .textarea_sendkeys("请输入工作内容",jobContent);

        /*
        选择职能、行业、地点，并且获取选择的值
         */
                String function_value = eBFA02Page
                        .inputPlaceholder_parentDiv_parentDiv_iClick("请选择目前职能").sleepForSeconds(1)//点击目前职能的icon
                        .functionSingleComponent()//选择职能组件
                        .label_followingDiv_spanValue("目前职能：");

                String industry_value = eBFA02Page
                        .inputPlaceholder_parentDiv_parentDiv_iClick("请选择公司行业").sleepForSeconds(1)//点击目前职能的icon
                        .industryComponent()//选择职能组件
                        .label_followingDiv_spanValue("所在行业：");

                String location_value = eBFA02Page
                        .input_bcakSpace("请选择工作地址",1).sleepForSeconds(1)//清掉现居住地
                        .inputPlaceholder_parentDiv_parentDiv_iClick("请选择工作地址").sleepForSeconds(1)//点击现居住地的icon
                        .workPlaceComponent()//选择地点组件
                        .label_followingDiv_spanValue("工作地点：");

                List<String> list=new ArrayList<String>();
                list.add(companyName);
                list.add(jobName);
                list.add(function_value);
                list.add(industry_value);

                list.add(location_value);
                EBFA04Page eBFA04Page_1 = (EBFA04Page)eBFA02Page
                        .clickSpan("添加到收藏夹").sleepForSeconds(1)//点击【添加到收藏夹】按钮
                        .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                        .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(2);

                EBFA08Page eBFA08Page=(EBFA08Page)eBFA04Page_1.secondTask("清空").sleepForSeconds(1)//点击清空按钮
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",phone)//输入手机号
                .clickSpan("搜索").sleepForSeconds(3)
                .hoverAvatar(0).sleepForSeconds(1)//悬浮头像
                .checkResumeCard_currentJob(list)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

                list.remove(location_value);
                eBFA08Page.clickSpan("展开更多").sleepForSeconds(1)
                .checkBigcardInform(list,currentSalary)//核对卡片里的目前工作，目前公司、职位职能、目前行业、目前薪资
                .clickSpan("收起");

                list.remove(industry_value);
                list.add(location_value);

                EB0301Page eB0301Page=(EB0301Page)eBFA08Page
                        .checkResume_workExperience(list,industry_value,currentSalary)//校对简历详情里的 工作经历，公司名称、职位名称、职能、地点、行业、薪资
                        .clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告
                        .Span_Value("生成推荐报告成功")//框架上 提示生成推荐报告成功
                        .Li_click("推荐报告")//切换 推荐报告栏
                        .sleepForSeconds(2)
                        .click_Recommend()//点击  查看报告
                        .switchToNewIframe(1, EB0301Page.class).sleepForSeconds(2);

                eB0301Page.checkRecommendation_workExperience(companyName,jobName,jobContent,currentSalary);//校对推荐报告里的 工作经验，公司名称、职位名称、工作内容、目前薪资


    }
}
