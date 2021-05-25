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

public class EBFA08人选详情_编辑简历_个人信息 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA01Page eBFA03Page = (EBFA01Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA01Page.class).sleepForSeconds(1);

        int age_numb = 20+ Public.generateNumber1(80);//20-99位随机数
        String age_str=age_numb+"";
        int sex_numb = 1+Public.generateNumber1(2);//1-2位随机数
        String sex_str="";

        String mustKeywords="15021528407";
        EBFA08Page eBFA08Page=(EBFA08Page)eBFA03Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mustKeywords)
                .clickSpan("搜索").sleepForSeconds(3)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        EBFA10Page eBFA10Page = (EBFA10Page)eBFA08Page
                .span_parent_followingGetSpan("查看原始简历")//打开“EBFA10编辑简历”页面
                .switchToNewIframe(1, EBFA10Page.class).sleepForSeconds(1);

        String location=eBFA10Page.click_sex(sex_numb)//点击性别，随机选择 男、女
                .clearInput("请输入年龄")//清掉原来年龄的值
                .sendInputPlaceholder("请输入年龄",age_str)//输入年龄值
                .vaillocation_delete()//×掉地点
                .sleepForSeconds(1)
                .peopleInfo_location_click()//点击现居住地的icon
                .placeComponent_getValue();//获取工作地点值

        switch (sex_numb){
            case 1:
                sex_str="男";
                break;
            case 2:
                sex_str="女";
                break;
        }

        List<String> list=new ArrayList<String>();
        list.add(sex_str);
        list.add(age_str+"岁");
        list.add(location);

        EBFA08Page eBFA08Page_1=(EBFA08Page)eBFA10Page.clickSpan("确定").sleepForSeconds(1)//点击【确定】按钮
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        List<String> list_1=new ArrayList<String>();
        list_1.add("性别：");
        list_1.add("年龄：");
        list_1.add("现居住地：");

        EB0301Page eB0301Page=(EB0301Page)eBFA08Page_1.img_altClick("刷新").sleepForSeconds(2)//刷新页面
                    .checkCardInform(list)//在“EBFA08人选详情”页面，校对 人选详情卡片的性别、年龄、现居住地
                    .checkResume_personalInform(list_1,list)//在“EBFA08人选详情”页面，校对  简历详情里的性别、年龄、现居住地
                    .clickSpan("生成推荐报告").sleepForSeconds(1)//点击 生成推荐报告
                    .Span_Value("生成推荐报告成功")//框架上 提示生成推荐报告成功
                    .clickLi("推荐报告")//切换 推荐报告栏
                    .sleepForSeconds(2)
                    .click_Recommend()//点击  查看报告
                    .switchToNewIframe(1, EB0301Page.class).sleepForSeconds(2);

        List<String> list_2=new ArrayList<String>();
        list_2.add("性别：");
        list_2.add("现居住地：");

        List<String> list_3=new ArrayList<String>();
        list_3.add(sex_str);
        list_3.add(location);

        eB0301Page.checkRecommendation_personalInfor(list_2, list_3);//在“EB0301”页面，校对 人选信息的性别、现居住地

    }
}
