package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class EBFA03人选搜索_可能包含关键词_人选信息 extends BoleBase {
    @Test
    public void 搜索手机号_邮箱_公司名称_职位_学校_专业 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus("\n" +
                        "          中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        List<String> list=new ArrayList<String>();
        list.add("18072915260");
        list.add("261518060@qq.com");
        list.add("北京人艺公司");
        list.add("运营经理");

        String mustKeywords="18072915260 261518060@qq.com 北京人艺公司 运营经理 杭州电子科技大学 印刷工程";
        eBFA03Page.sendInputPlaceholder("请输入可能包含的关键词,用空格隔开",mustKeywords)
        .clickSpan("搜索").sleepForSeconds(3)
        .checkInform_yellow(list,2);//在EBFA03人选搜索页面  校验小卡片

        list.add("杭州电子科技大学");
        list.add("印刷工程");
        eBFA03Page.div_hover("范建波")//hover姓名
        .checkInform_yellow(list,1).sleepForSeconds(2);//在EBFA03人选搜索页面  校验大卡片

    }
}
