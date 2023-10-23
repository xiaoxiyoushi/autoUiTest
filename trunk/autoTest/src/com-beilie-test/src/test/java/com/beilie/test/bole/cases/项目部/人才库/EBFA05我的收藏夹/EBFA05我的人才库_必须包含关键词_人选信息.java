package com.beilie.test.bole.cases.项目部.人才库.EBFA05我的收藏夹;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA05Page;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class EBFA05我的人才库_必须包含关键词_人选信息 extends BoleBase {
    @Test(description = "必须包含关键词_人选信息")
    public void 搜索手机号_邮箱_公司名称_职位_学校_专业 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗

        EBFA05Page eBFA05Page = (EBFA05Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_myFavorities()//点击二级菜单
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(1);

        List<String> list=new ArrayList<String>();
        list.add("13482127008901");
        list.add("yiling12310_tang@163.com");
        list.add("上海嘉定区黄渡中学家教中心");
        list.add("语文教师");

        String mustKeywords="13482127008901 yiling12310_tang@163.com 上海嘉定区黄渡中学家教中心 语文教师 新杨中学 英语";
        eBFA05Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mustKeywords)
                .clickSpan("搜索").sleepForSeconds(3)
                .checkInform_Card(list,2);//在EBFA03人选搜索页面  校验小卡片

        list.add("新杨中学");
        list.add("英语");
        eBFA05Page.div_hover("张怡玲")//hover姓名
                .checkInform_Card(list,1).sleepForSeconds(2);//在EBFA03人选搜索页面  校验大卡片

    }
}
