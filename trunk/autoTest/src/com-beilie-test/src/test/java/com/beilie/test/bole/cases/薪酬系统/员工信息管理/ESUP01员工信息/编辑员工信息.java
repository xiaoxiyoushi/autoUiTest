package com.beilie.test.bole.cases.薪酬系统.员工信息管理.ESUP01员工信息;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.ESUP.ESUP01Page;
import com.beilie.test.bole.pages.GP.GPCP.GPCP03Page;
import com.beilie.test.bole.pages.GP.GPRV01Page;
import com.beilie.test.open.PublicClass.Public;
import org.testng.annotations.Test;

import java.util.Map;

public class 编辑员工信息 extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("dululu_userName", "dululu_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗

        ESUP01Page eSUP01Page = (ESUP01Page) bdHomePage
                .clickFirstMenu_memberInforManage().sleepForSeconds(1)//点击一级菜单
                .clickSecondMenu_memberInfor()//点开二级菜单
                .switchToNewIframe1("ESUP01", ESUP01Page.class).sleepForSeconds(1);

        eSUP01Page.operation_click()
        .edit_click()

        ;
    }
}
