package com.beilie.test.bole.cases.项目部._01项目详情.项目详情;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

public class GP10项目详情_项目要点Test extends BoleBase {
    @Test
    public void 编辑项目要点_校对内容及分段 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page=(GPPM10Page)bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1)//点击一级菜单：项目管理
                .clickSecondMenu_myProject()//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        int i_1 = Public.generateNumber1_n(1000);
        String b_1 = i_1 + "";
        String value_1=b_1+"aaaa";

        int i_2 = Public.generateNumber1_n(1000);
        String b_2 = i_2 + "";
        String value_2=b_2+"bbbb";

        int i_3 = Public.generateNumber1_n(1000);
        String b_3 = i_3 + "";
        String value_3=b_3+"cccc";

        GP10Page gP10Page=(GP10Page)gPPM10Page.table_td_aClick(0,0)
                .switchToNewIframe(0,GP10Page.class).sleepForSeconds(2);

        gP10Page.Li_click("项目详情").sleepForSeconds(1)
                .span_followingI("项目要点").sleepForSeconds(1)
                .div_dataplaceholder_clear("请输入项目要点")
                .div_dataplaceholder_send("请输入项目要点",value_1+"\n"+value_2+"\n"+value_3+"\n")
                .clickSpan("确定").sleepForSeconds(1)
                .checkParagraph(value_1,value_2,value_3).sleepForSeconds(2);

    }

}
