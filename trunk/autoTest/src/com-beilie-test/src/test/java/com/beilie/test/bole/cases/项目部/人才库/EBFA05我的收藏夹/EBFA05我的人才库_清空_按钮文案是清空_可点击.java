package com.beilie.test.bole.cases.项目部.人才库.EBFA05我的收藏夹;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA05Page;
import org.testng.annotations.Test;

public class EBFA05我的人才库_清空_按钮文案是清空_可点击 extends BoleBase {
    @Test(description = "必须包含关键词_人选信息")
    public void 搜索手机号_邮箱_公司名称_职位_学校_专业 ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗

        EBFA05Page eBFA05Page = (EBFA05Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)//点击一级菜单：中文简历库
                .clickSecondMenu_myFavorities()//点击二级菜单
                .switchToNewIframe1("EBFA05", EBFA05Page.class).sleepForSeconds(1);

        eBFA05Page.waitCandidateSearchResults()
        .clearButton()
        ;

    }
}
