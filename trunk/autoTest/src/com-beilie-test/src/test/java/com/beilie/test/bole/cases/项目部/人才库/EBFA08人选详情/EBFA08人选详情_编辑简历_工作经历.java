package com.beilie.test.bole.cases.项目部.人才库.EBFA08人选详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.EB.EB0301Page;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.bole.pages.EB.EBFA10Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class EBFA08人选详情_编辑简历_工作经历  extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA01Page eBFA03Page = (EBFA01Page) bdHomePage
                .clickMenus("\n" +
                        "          中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA01Page.class).sleepForSeconds(1);

        String randomStr= Public.generateString(8);//8位随机字符串
        int randomNumb = 1+ Public.generateNumber1(1000);//1-1000位随机数

        String mustKeywords = "15021528407";
        EBFA08Page eBFA08Page = (EBFA08Page) eBFA03Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        EBFA10Page eBFA10Page = (EBFA10Page) eBFA08Page
                .span_parent_followingGetSpan("查看原始简历")//打开“EBFA10编辑简历”页面
                .switchToNewIframe(1, EBFA10Page.class).sleepForSeconds(1);

        /*
        给公司名称、职位、目前年薪、工作内容  赋值
         */
        String companyName = "中国好公司"+randomStr;
        String jobName = "中国好职位"+randomStr;
        String jobContent = "好工作 中国找"+randomStr;
        String currentSalary =Integer.toString(40000+randomNumb) ;

        eBFA10Page.clearInput("请输入公司名称")
        .sendInputPlaceholder("请输入公司名称",companyName)

        .clearInput("请输入职位名称")
        .sendInputPlaceholder("请输入职位名称",jobName)

        .clearInput("请输入年薪")
        .sendInputPlaceholder("请输入年薪",currentSalary)

        .clearTextarea("请输入工作内容")
        .textarea_sendkeys("请输入工作内容",jobContent);

        /*
        选择职能、行业、地点，并且获取选择的值
         */
        String function_value = eBFA10Page.component_delete(1)
                .workExperience_function_click()
                .getfunction_SingleComponentValue();

        String industry_value = eBFA10Page.component_delete(2)
                .workExperience_Industry_click()
                .getIndustryComponentValue();

        String location_value = eBFA10Page.component_delete(3)
                .workExperience_Location_click()
                .placeComponent_getValue();

        EBFA08Page eBFA08Page_1=(EBFA08Page)eBFA10Page.clickSpan("确定").sleepForSeconds(1)//点击【确定】按钮
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        List<String> list=new ArrayList<String>();
        list.add(companyName);
        list.add(jobName);
        list.add(function_value);
        list.add(industry_value);

        eBFA08Page_1.i_classClick("icon-btn ivu-icon bole icon-refresh2").sleepForSeconds(2)//刷新页面
                .clickSpan("展开更多").sleepForSeconds(1)
                .checkBigcardInform(list,currentSalary)//核对卡片里的目前工作，目前公司、职位职能、目前行业、目前薪资
                .clickSpan("收起");

        list.remove(industry_value);
        list.add(location_value);

        EB0301Page eB0301Page=(EB0301Page)eBFA08Page_1
                .checkResume_workExperience(list,industry_value,currentSalary)//校对简历详情里的 工作经历，公司名称、职位名称、职能、地点、行业、薪资
                .clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告
                .div_getValue(" 生成推荐报告成功 ")//框架上 提示生成推荐报告成功
                .Li_click("推荐报告")//切换 推荐报告栏
                .sleepForSeconds(2)
                .click_Recommend()//点击  查看报告
                .switchToNewIframe(1, EB0301Page.class).sleepForSeconds(2);

        eB0301Page.checkRecommendation_workExperience(companyName,jobName,jobContent,currentSalary);//校对推荐报告里的 工作经验，公司名称、职位名称、工作内容、目前薪资

    }
}
