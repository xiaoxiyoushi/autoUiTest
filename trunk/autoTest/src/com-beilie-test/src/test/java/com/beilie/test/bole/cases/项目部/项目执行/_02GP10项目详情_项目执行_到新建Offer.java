package com.beilie.test.bole.cases.项目部.项目执行;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EQ.EQQB05Page;
import com.beilie.test.bole.pages.GP.GPPC01Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.*;
import org.junit.Test;

public class _02GP10项目详情_项目执行_到新建Offer extends BoleBase {
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
                .clickMenus(" 项目管理", "我的项目")//点击菜单栏
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .selectName(0)//选择项目名称
                .inputClientName("请输入项目名称", "卖麦芽糖的")//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        GP14Page gP14Page = (GP14Page) gP10Page
                .clickLi("已推荐").sleepForSeconds(2)
                .clickName()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP12Page gP12Page = (GP12Page) gP14Page.clickSpan("创建面试")
                .clickConfirmBtn()
                .switchToNewIframe(2, GP12Page.class).sleepForSeconds(3);

        GP14Page gP14Page_1 = (GP14Page) gP12Page.sendInputPlaceholder("请输入", "赵面试官")
                .selectTomorrow("请选择")
                .label_followingDiv_clickInput("面试地址：").sleepForSeconds(1)
                .h2_inputClick("常用地址中选择并添加到面试地址")
                .labelClick("初试")
                .labelClick("面试")
                .label_followingDiv_clickInput("提醒对象：")
                .secondTask("cc41")
                .clickConfirm()
                .clickSpan("保存").sleepForSeconds(1)
                .clickSubmit()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP54Page gP54Page = (GP54Page) gP14Page_1.clickSubmitInterviewBtn()
                .switchToNewIframe(2, GP54Page.class).sleepForSeconds(3);

        GP52Page gP52Page = (GP52Page) gP54Page.clickInputPlaceholder("请选择时间")
                .scrollBar().sleepForSeconds(1)
                .selectTime().sleepForSeconds(1)
                .clickSubmit()
                .switchToNewIframe(2, GP52Page.class).sleepForSeconds(3);

        EQQB05Page eQQB05Page = (EQQB05Page) gP52Page.secondTask("去完成>>>")
                .switchToNewIframe(3, EQQB05Page.class).sleepForSeconds(3);

        GP52Page gP52Page_1 = (GP52Page) eQQB05Page
                .clickSpan("保存").sleepForSeconds(1)
                .clickSpan("是")
                .switchToNewIframe(2, GP52Page.class).sleepForSeconds(3);

        GP14Page gP14Page_3 = (GP14Page) gP52Page_1.clickSubmit()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GP53Page gP53Page = (GP53Page) gP14Page_3.clickSubmitInterviewBtn()
                .switchToNewIframe(2, GP53Page.class).sleepForSeconds(3);

        EQQB05Page eQQB05Page_1 = (EQQB05Page) gP53Page.secondTask("去完成>>>")
                .switchToNewIframe(3, EQQB05Page.class).sleepForSeconds(3);

        GP53Page gP53Page_1 = (GP53Page) eQQB05Page_1
                .clickSpan("保存").sleepForSeconds(1)
                .clickSpan("是")
                .switchToNewIframe(2, GP53Page.class).sleepForSeconds(3);

        GP14Page gP14Page_5 = (GP14Page) gP53Page_1.clickSubmit()
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(3);

        GPPC01Page gPPC01Page = (GPPC01Page) gP14Page_5.clickSpan("签订offer").sleepForSeconds(1)
                .labelClick("进行背景调查")
                .confirmBackground().sleepForSeconds(1)
                .clickConfirmBtn().sleepForSeconds(2)
                .switchToNewIframe(2, GPPC01Page.class).sleepForSeconds(1);

        GP14Page gP14Page_6 = (GP14Page) gPPC01Page.img_altClick("关闭")
                .switchToNewIframe(1, GP14Page.class).sleepForSeconds(1);

        GP10Page gP10Page_1 = (GP10Page) gP14Page_6.img_altClick("关闭")
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(1);

        gP10Page_1.img_altClick("关闭").sleepForSeconds(1);
    }
}
