package com.beilie.test.bole.cases.项目部.人才库.人才库_跨租户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA02Page;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class _02EBFA04简历搜索_跨租户_加入项目 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68659106", "888888").sleepForSeconds(3);

        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickMenus(" 中文简历库", "简历搜索")//点击菜单栏
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String newPhone = "1358765238" + randomStr;//新的手机号
        String newName = "孙萍萍" + randomStr;//新的姓名

        String mustKeywords = "13764863406";
        EBFA02Page eBFA02Page = (EBFA02Page) eBFA04Page
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", mustKeywords)
                .clickSpan("搜索").sleepForSeconds(2)
                .secondTask("加入项目").sleepForSeconds(2)//在简历卡片  点击“加入项目”
                .addProject_click()//在加入项目弹窗，点击“加入项目”
                .switchToNewIframe(0, EBFA02Page.class).sleepForSeconds(2);

        EBFA04Page eBFA04Page_1 = (EBFA04Page) eBFA02Page.input_bcakSpace("请输入姓名", 2)//将陈磊 键盘删掉
                .sendInputPlaceholder("请输入姓名", newName)//将姓名填值

                .input_bcakSpace("请输入联系电话", 11)//将联系电话 键盘删掉
                .sendInputPlaceholder("请输入联系电话", newPhone)//给联系电话填值

                .input_bcakSpace("请输入电子邮箱", 19)//将电子邮箱 键盘删掉
                .sendInputPlaceholder("请输入电子邮箱", "13568174549@163.com" + randomStr)//给电子邮箱填值
                .clickSpan("添加到收藏夹").sleepForSeconds(1)
                .checkTip().sleepForSeconds(1)//核对提示框的内容
                .checkTip_addProject(newName)
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        eBFA04Page_1.i_classClick("ivu-icon ivu-icon-ios-close")
                .a_classClick("mr25")
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开", newPhone)
                .clickSpan("搜索").sleepForSeconds(2)
                .secondTask("加入项目").sleepForSeconds(2)//在简历卡片  点击“加入项目”
                .addProject_click().sleepForSeconds(1)//在加入项目弹窗，点击“加入项目”
                .checkTip_againAdd().sleepForSeconds(1);//校对弹窗：该人选当前正在本职位操作中，无法重复添加。

    }
}
