package com.beilie.test.open.hunters.cases.homes;

import com.beilie.test.open.hunters.core.HunterBase;
import org.junit.Test;

public class 首页职位管理菜单都可以点击 extends HunterBase {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, InterruptedException {
        login("shccl@gongkai", "1")
                .assertLoginSuccess()
                .clickMenuItem("职位管理","发布中的职位")
                .clickMenuItem("职位管理","已暂停的职位")
                .clickMenuItem("职位管理","已关闭的职位")
                .clickMenuItem("职位管理","草稿职位")
                .clickMenuItem("职位管理","客户管理")
                .clickMenuItem("职位管理","推荐记录")
                .clickMenuItem("职位管理","应聘记录")
                .sleepForSeconds(10);
    }
}
