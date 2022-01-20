package com.beilie.test.bole.cases.项目部._02项目候选人详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP12Page;
import com.beilie.test.bole.pages.GP.GPXX.GP14Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

/*
淘汰人选再加入项目
 */

public class GP14项目候选人详情_备注人选基本信息 extends BoleBase {
    @Test
    public void run() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage1 = login();
        process(bdHomePage1);
    }

    public BdHomePage login() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);
        return bdHomePage;
    }

    public void process(BdHomePage bdHomePage) throws IllegalAccessException, InstantiationException, InterruptedException {
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickMenus("\n" +
                        "          项目管理", "我的项目").sleepForSeconds(2)//点击菜单栏
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        String randomStr = Public.generateString(8);//8位随机字符串
        String name = "侯明昊" + randomStr;
        String phone = "18362945222" + randomStr;
        String mailbox =randomStr+"158324803@qq.com";

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .inputClientName("请输入项目名称", "卖葡萄糖的")//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);


    }

}
