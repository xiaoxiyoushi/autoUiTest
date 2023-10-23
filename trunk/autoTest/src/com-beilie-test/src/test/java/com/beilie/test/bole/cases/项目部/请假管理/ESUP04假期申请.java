package com.beilie.test.bole.cases.项目部.请假管理;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.ESUP04Page;
import org.testng.annotations.Test;

import java.util.Map;

public class ESUP04假期申请 extends BoleBase {
    @Test
    public void GP10项目详情_全部栏_加入时间默认倒序() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = login("userName","password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        ESUP04Page eSUP04Page = (ESUP04Page) bdHomePage
                .clickMenu_holiday()
                .switchToNewIframe1("ESUP04", ESUP04Page.class).sleepForSeconds(1);

        eSUP04Page.spanClick("esup04_holidayApply").sleepForSeconds(1)
                .divClass_click("esup04_selectReviewer_class")
                .liCliss("esup04_asCC_class").sleepForSeconds(1)
                .reviewer()
                .spanClick("esup04_holidayType")
                .liClick("esup04_holiday")
        .leaveTime()
        ;

    }
}
