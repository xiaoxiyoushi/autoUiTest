package com.beilie.test.bole.cases.项目部._01项目详情.团队人选;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import org.testng.annotations.Test;

import java.util.Map;

public class GP10项目详情_全部栏_加入时间默认倒序Test extends BoleBase {
    @Test
    public void GP10项目详情_全部栏_加入时间默认倒序 ()throws IllegalAccessException, InstantiationException, InterruptedException,Exception {
        BdHomePage bdHomePage = login_ceshi("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue().sleepForSeconds(1);//关闭设置隐藏菜单的弹窗
        GPPM10Page gPPM10Page = (GPPM10Page) bdHomePage
                .clickFirstMenu_projectManage().sleepForSeconds(1) //点击一级菜单：项目管理
                .clickSecondMenu_myProject().sleepForSeconds(1)//点击二级菜单：我的项目
                .switchToNewIframe1("GPPM10", GPPM10Page.class).sleepForSeconds(1);

        GP10Page gP10Page=(GP10Page)gPPM10Page.table_td_aClick(0,0)
                .switchToNewIframe(0,GP10Page.class).sleepForSeconds(3);

        Map<String, Object> hash = gP10Page.getTime();
        gP10Page.checkStap(hash);


    }
}
