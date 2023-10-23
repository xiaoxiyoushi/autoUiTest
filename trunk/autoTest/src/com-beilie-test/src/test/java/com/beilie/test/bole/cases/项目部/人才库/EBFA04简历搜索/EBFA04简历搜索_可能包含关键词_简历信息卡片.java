package com.beilie.test.bole.cases.项目部.人才库.EBFA04简历搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA04Page;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class EBFA04简历搜索_可能包含关键词_简历信息卡片 extends BoleBase {
    @Test(description = "简历信息卡片")
    public void 搜索手机号_邮箱_公司名称_职位_学校_专业 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA04Page eBFA04Page = (EBFA04Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_resumeSearch()//点击二级菜单
                .switchToNewIframe1("EBFA04", EBFA04Page.class).sleepForSeconds(1);

        List<String> list=new ArrayList<String>();
        list.add("13482127008901");
        list.add("yiling12310_tang@163.com");
        list.add("上海嘉定区黄渡中学家教中心");
        list.add("语文教师");

        String mustKeywords="13482127008901 yiling12310_tang@163.com 上海嘉定区黄渡中学家教中心 语文教师 新杨中学 英语";
        eBFA04Page.sendInputPlaceholder("请输入可能包含的关键词,用空格隔开",mustKeywords)
                .clickSpan("搜索").sleepForSeconds(3)
                .checkInform_yellow(list,2);//在EBFA04页面  校验小卡片

        list.add("新杨中学");
        list.add("英语");
        eBFA04Page.div_hover("张怡玲")//hover姓名
                  .checkInform_yellow(list,1).sleepForSeconds(2);//在EBFA04页面  校验大卡片

    }
}
