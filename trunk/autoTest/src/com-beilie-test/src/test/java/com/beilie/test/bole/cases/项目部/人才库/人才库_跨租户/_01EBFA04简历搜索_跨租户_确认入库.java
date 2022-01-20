package com.beilie.test.bole.cases.项目部.人才库.人才库_跨租户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA02Page;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class _01EBFA04简历搜索_跨租户_确认入库 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68659106", "888888").sleepForSeconds(3);
        bdHomePage.closeHideMenue();

        //bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_resumeSearch()//点击二级菜单：简历搜索
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String randomStr= Public.generateString(8);//8位随机字符串
        String newPhone= "135437648"+randomStr;//8位随机字符串

        String mustKeywords = "13764863406";
        EBFA02Page eBFA02Page = (EBFA02Page) eBFA04Page
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)
                .clickSpan("搜索").sleepForSeconds(2)
                .clickAvatar(0)//点击头像
                .switchToNewIframe(0, EBFA02Page.class).sleepForSeconds(2);

        EBFA04Page eBFA04Page_1 = (EBFA04Page)eBFA02Page.input_bcakSpace("请输入姓名",2)//将陈磊 键盘删掉
                .sendInputPlaceholder("请输入姓名","赵萍萍"+randomStr)//将姓名填值

                .input_bcakSpace("请输入联系电话",11)//将联系电话 键盘删掉
                .sendInputPlaceholder("请输入联系电话",newPhone)//给联系电话填值

                .input_bcakSpace("请输入电子邮箱",19)//将电子邮箱 键盘删掉
                .sendInputPlaceholder("请输入电子邮箱","1876545422159@163.com"+randomStr)//给电子邮箱填值
                .clickSpan("添加到收藏夹").sleepForSeconds(1)
                .checkTip()//核对提示框的内容
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        eBFA04Page_1.a_classClick("mr25")
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", newPhone)
                .clickSpan("搜索").sleepForSeconds(2)
                .hoverAvatar(0).sleepForSeconds(1)
                .checkResumeCard(newPhone).sleepForSeconds(1);

    }
}
