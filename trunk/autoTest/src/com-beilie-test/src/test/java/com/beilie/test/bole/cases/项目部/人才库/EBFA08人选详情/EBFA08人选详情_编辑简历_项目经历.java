package com.beilie.test.bole.cases.项目部.人才库.EBFA08人选详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.EB.EB0301Page;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.bole.pages.EB.EBFA10Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA08人选详情_编辑简历_项目经历 extends BoleBase{
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA01Page eBFA03Page = (EBFA01Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA01Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        int randomNumb = 1 + Public.generateNumber1(1000);//1-1000位随机数

        String mustKeywords = "15021528407";
        EBFA08Page eBFA08Page = (EBFA08Page) eBFA03Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        EBFA10Page eBFA10Page = (EBFA10Page) eBFA08Page
                .span_parent_followingGetSpan("查看原始简历")//打开“EBFA10编辑简历”页面
                .switchToNewIframe(1, EBFA10Page.class).sleepForSeconds(1);

        /*String project="项目业绩：新功能开发及维护\n" +
                                "项目职责：安徽中意之旅信息科技有限公司\n" +
                                "项目描述：中意征信是在我国传统企业征信业务模式上"+randomStr;*/
        String project="项目描述"+randomStr;

        EBFA08Page eBFA08Page_1=(EBFA08Page)eBFA10Page.clearProject()//清除项目内容
                .sleepForSeconds(1)
                .sendProject(project)//输入项目内容
                .clickSpan("确定").sleepForSeconds(1)//点击【确定】按钮
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        EB0301Page eB0301Page=(EB0301Page)eBFA08Page_1.img_altClick("刷新").sleepForSeconds(2)//刷新页面
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
