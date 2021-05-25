package com.beilie.test.bole.cases.项目部.人才库.EBFA08人选详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
/*
上传简历 更改性别、年龄、现居住地，
 */

public class EBFA08人选详情_生成推荐报告_入库前更改_个人信息模块  extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA01Page eBFA01Page = (EBFA01Page) bdHomePage
                .clickMenus(" 中文简历库", "上传简历")//点击菜单栏
                .switchToNewIframe1("EBFA01", EBFA01Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        int randomNum = Public.generateNumber1(20);//0-19位随机数
        int age_numb = 20+Public.generateNumber1(80);//20-99位随机数
        String age_str=age_numb+"";
        int sex_numb = 1+Public.generateNumber1(2);//1-2位随机数
        String sex_str="";

        eBFA01Page.judgeWay()
                .uploadResume("C:\\Users\\86182\\Desktop\\resume\\吴洁琼.docx").sleepForSeconds(3)//.docx文件
                .sleepForSeconds(4)
                .workExperience_function_click()//点击目前职能的icon
                .functionSingleComponent();//选择职能组件

        String location=eBFA01Page.click_sex(sex_numb)//点击性别，随机选择 男、女
                .clearInput("请输入年龄")//清掉原来年龄的值
                .sendInputPlaceholder("请输入年龄",age_str)//输入年龄值
                .peopleInfo_location_delete()//×掉地点
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

        BdHomePage bdHomePage_1 = (BdHomePage)eBFA01Page.clickSpan("确定").sleepForSeconds(1)
                    .checkTip().sleepForSeconds(2)
                    .switchOutIframe(BdHomePage.class);

        EBFA03Page eBFA03Page = (EBFA03Page)bdHomePage_1.clickSingleMenu("人选搜索")
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        EBFA08Page eBFA08Page=(EBFA08Page)eBFA03Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开","18757140713 车逻好单位")//搜索手机号码
                  .clickSpan("搜索").sleepForSeconds(3)
                  .checkCard_Inform(list)//在“EBFA03人选搜索”页面，校验大小卡片上的性别、年龄、现居住地
                  .clickAvatar(0)//点击头像
                  .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        List<String> list_1=new ArrayList<String>();
        list_1.add("性别：");
        list_1.add("年龄：");
        list_1.add("现居住地：");

        eBFA08Page.checkCardInform(list)//在“EBFA08人选详情”页面，校对 人选详情卡片的性别、年龄、现居住地
                  .checkResume_personalInform(list_1,list)//在“EBFA08人选详情”页面，校对  简历详情里的性别、年龄、现居住地
                  .sleepForSeconds(2);

    }
}
