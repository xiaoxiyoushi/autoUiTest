package com.beilie.test.bole.cases.CCL角色.DHSP06外呼部门分配;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.DH.DHSP06Page;
import com.beilie.test.bole.pages.GP.GPPM.GPPM10Page;
import com.beilie.test.bole.pages.GP.GPXX.GP10Page;
import org.testng.annotations.Test;

import java.util.Map;

public class DHSP06外呼部门分配_分配或者收回号码Test extends BoleBase {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, InterruptedException, Exception {
        BdHomePage bdHomePage = cclLogin().sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        DHSP06Page dHSP06Page = (DHSP06Page) bdHomePage
                .clickFirstMenu_callManage().sleepForSeconds(1)//点击一级菜单：外呼管理
                .clickSecondMenu_callDepartment()//点击二级菜单：外呼部门分配
                .switchToNewIframe1("DHSP06", DHSP06Page.class).sleepForSeconds(2);

        String oprationText = dHSP06Page.opration();

        if (oprationText.equals("分配")) {
            dHSP06Page.oprationClick()
                    .sendInputPlaceholder("请选择", "66624284").sleepForSeconds(1)
                    .Li_click("CCLershi")
                    .clickSpan(" 确定 ");
        }else {
            dHSP06Page.oprationClick();
        }

    }
}
