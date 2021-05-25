package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class EBFA03人选搜索_必须包含关键词_人选信息 extends BoleBase {
    @Test
    public void 搜索手机号_邮箱_公司名称_职位_学校_专业 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        List<String> list=new ArrayList<String>();
        list.add("1348212700890");
        list.add("yiling12310_tang@163.com");
        list.add("上海嘉定区黄渡中学家教中心");
        list.add("语文教师");

        String mustKeywords="1348212700890 yiling12310_tang@163.com 上海嘉定区黄渡中学家教中心 语文教师 上海立信会计学院 英语";
        eBFA03Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mustKeywords)
        .clickSpan("搜索").sleepForSeconds(3)
        .checkInform_Card(list,2);//在EBFA03人选搜索页面  校验小卡片

        list.add("上海立信会计学院");
        list.add("英语");
        eBFA03Page.div_hover("魏怡玲")//hover姓名
        .checkInform_Card(list,1).sleepForSeconds(2);//在EBFA03人选搜索页面  校验大卡片

    }
}
