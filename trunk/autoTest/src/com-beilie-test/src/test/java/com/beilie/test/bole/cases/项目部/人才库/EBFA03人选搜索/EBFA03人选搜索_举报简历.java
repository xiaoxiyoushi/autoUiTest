package com.beilie.test.bole.cases.项目部.人才库.EBFA03人选搜索;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.EB.EBFA03Page;
import com.beilie.test.bole.pages.EB.EBFA08Page;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.testng.annotations.Test;

public class EBFA03人选搜索_举报简历 extends BoleBase {
    @Test(description = "举报成功")
    public void 验证举报成功的消息() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("ccl_userName", "ccl_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        EBFA03Page eBFA03Page = (EBFA03Page) bdHomePage
                .clickFirstMenu_resumeLibrary().sleepForSeconds(1)
                .clickSecondMenu_candidateSearch()//点击菜单栏
                .switchToNewIframe1("EBFA03", EBFA03Page.class).sleepForSeconds(3);

        String str = "该人选简历造假" + Public.generateString(8);

        EBFA08Page eBFA08Page = (EBFA08Page) eBFA03Page
                .sendInputPlaceholder("请输入必须包含的关键词,用空格隔开","汪文亮")
                .clickSearch()
                .waitCandidateSearchResults()
                .clickAvatar(2)//点击头像
                .switchToNewIframe(0, EBFA08Page.class).sleepForSeconds(2);

        String value = eBFA08Page
                .clickSpan("举报简历")
                .textarea_sendkeys("请输入理由", str)
                .inputMail()
                .selectApprover().sleepForSeconds(2)
                .waitTipoffsOkBtn()
                .OkBtn_click().sleepForSeconds(2)
                .value_efpage();

        Assert.assertEquals("创建数据成功。", value);
    }
}
