package com.beilie.test.bole.cases.项目部.项目详情.团队人选;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class GP10项目详情_添加备注 extends BoleBase {
    @Test
    public void login() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68658226", "1").sleepForSeconds(3);

        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickMenus(" 项目管理", "我的项目")//点击菜单栏
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        int n = Public.generateNumber0_n_1(3);
        String randomStr = Public.generateString(8);//8位随机字符串
        String remark = "在GP10项目详情添加的备注" + randomStr;//备注的内容

        GP10Page gP10Page = (GP10Page) gPPM10Page
                .selectName(0)//选择项目名称
                .inputClientName("请输入项目名称", "卖麦芽糖的")//输入项目名称
                .clickSearch()
                .sleepForSeconds(2)
                .table_td_aClick(0, 0)
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        EBFA08Page eBFA08Page = (EBFA08Page) gP10Page.clickProcess("寻访中", 1).sleepForSeconds(1)
                .secondTask("+")
                .textarea_sendkeys("输入备注内容", remark)
                .button_classClick("okBtn ivu-btn")
                .secondTask("预览")
                .switchToNewIframe(1, EBFA08Page.class).sleepForSeconds(3);

        eBFA08Page.clickLi("备注").sleepForSeconds(1)//切换 备注栏
                .getSpanValue(remark);

        GP10Page gP10Page_1 = (GP10Page) eBFA08Page.img_altClick("关闭")
                .switchToNewIframe(0, GP10Page.class).sleepForSeconds(3);

        gP10Page_1.clickSpan("搜索").sleepForSeconds(1)
                .getSpanValue(remark);

        /*gP10Page_1.secondTask("more").sleepForSeconds(1)
                .getSpanValue(remark);*/
    }
}
