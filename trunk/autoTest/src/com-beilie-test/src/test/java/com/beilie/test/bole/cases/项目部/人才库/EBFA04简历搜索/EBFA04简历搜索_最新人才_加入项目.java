package com.beilie.test.bole.cases.项目部.人才库.EBFA04简历搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import com.beilie.test.bole.pages.EB.EBFA16Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA04简历搜索_最新人才_加入项目 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickMenus(" 中文简历库", "简历搜索")//点击菜单栏
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String name = "顾胜男"+randomStr;//姓名

        EBFA16Page eBFA16Page=(EBFA16Page)eBFA04Page
                .clickButton("最新人才").sleepForSeconds(2)//切换至 最新人才库
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开","1药网(美股上市公司)")
                .clickSpan("搜索").sleepForSeconds(2)
                .secondTask("加入项目").sleepForSeconds(2)//在简历卡片  点击“加入项目”
                .addProject_click()//在加入项目弹窗，点击“加入项目”
                .switchToNewIframe(0, EBFA16Page.class).sleepForSeconds(3);

        eBFA16Page.sendInputPlaceholder("请输入姓名",name)//输入姓名
                .sendInputPlaceholder("请输入联系电话","1854514544"+randomStr)//输入联系方式
                .sendInputPlaceholder("请输入电子邮箱","14855156456@ww.com"+randomStr)//输入邮箱
                .click_untilNow(" 至今")
                .label_followingDiv_clickimg("目前职能：")//点击目前职能的icon
                .functionSingleComponent()//选择职能组件
                .clickSpan("添加到收藏夹").sleepForSeconds(10)
                /*.clickSpan("添加到收藏夹")
                .displayWait()*/
                .checkTip().sleepForSeconds(2)//校对提示 更新简历成功，点击【确定】按钮 关掉页面
                .checkTip_addProject(name);

    }
}
