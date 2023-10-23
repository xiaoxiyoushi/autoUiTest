package com.beilie.test.bole.cases.项目部._02项目候选人详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA01Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP12Page;
import com.beilie.test.bole.pages.GP.GPXX.GP14Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.testng.annotations.Test;

public class GP14项目候选人详情_备注人选基本信息Test extends BoleBase {
    @Test(description="测试备注人选基本信息")
    public void 校对备注人选基本信息的姓名跟手机号() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage1 = login();
        process(bdHomePage1);
    }

    public BdHomePage login() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);
        return bdHomePage;
    }

    public void process(BdHomePage bdHomePage) throws IllegalAccessException, InstantiationException, InterruptedException {
        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject()//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .inputClientName("请输入项目名称", "卖葡萄糖的")//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        String name=gP10Page.getNmae();
        String phone=gP10Page.getPhone();

        GP14Page gP14Page = (GP14Page) gP10Page
                .clickName()//点击姓名
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        gP14Page.a_click("备注人选信息").sleepForSeconds(2);

        String memoName=gP14Page.getMemoName();
        String memoPhone=gP14Page.getMemoPhone();

        Assert.assertEquals(name,memoName);
        Assert.assertEquals(phone,memoPhone);
    }

}
