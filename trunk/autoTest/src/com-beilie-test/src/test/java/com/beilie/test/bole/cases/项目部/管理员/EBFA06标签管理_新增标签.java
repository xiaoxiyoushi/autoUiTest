package com.beilie.test.bole.cases.项目部.管理员;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.*;
import com.beilie.test.bole.pages.EB.EBFA06Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Test;

public class EBFA06标签管理_新增标签 extends BoleBase {
    @Test
    public void 成功创建项目并且跳到下一个页面 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = manageLogin("13312312323", "1").sleepForSeconds(3);

        EBFA06Page eBFA06Page=(EBFA06Page)bdHomePage
                .clickMenus("\n" +
                        "          中文简历库","标签管理")//点击菜单栏
                .switchToNewIframe1("EBFA06",EBFA06Page.class).sleepForSeconds(1);

        String label="高校"+Public.generateString(8);

        eBFA06Page.clickAddBtn()//点击新增按钮
            .inputLabel(label)
            .clickSubmitBtn().sleepForSeconds(2)
            .checkLabel(label).sleepForSeconds(2);

    }
}
