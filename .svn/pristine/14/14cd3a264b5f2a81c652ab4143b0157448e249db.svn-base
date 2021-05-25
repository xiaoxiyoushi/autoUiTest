package com.beilie.test.bole.cases.项目部.人才库.EBFA08人选详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class EBFA08人选详情_必须包含关键词 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickMenus(" 中文简历库", "人选搜索")//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(1);

        List<String> list=new ArrayList<String>();
        list.add("13671647565");
        list.add("ewyd3510@sina.com");
        list.add("上海汇众汽车制造公司");
        list.add("冲压工艺工程师");
        list.add("湖北汽车工业学院");
        list.add("材料成型及控制工程");

        String mustKeywords="13671647565 ewyd3510@sina.com 上海汇众汽车制造公司 冲压工艺工程师 湖北汽车工业学院 材料成型及控制工程";
        EBFA08Page eBFA08Page=(EBFA08Page)eBFA03Page.sendInputPlaceholder("请输入必须包含的关键词,用空格隔开",mustKeywords)
                .clickSpan("搜索").sleepForSeconds(3)
                .div_click("李琳")
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        eBFA08Page.clickSpan("展开更多").sleepForSeconds(1)
        .checkInform_Card(list,0)//人选卡片
        .checkInform_Card(list,1).sleepForSeconds(2)//简历详情
        ;

    }
}
