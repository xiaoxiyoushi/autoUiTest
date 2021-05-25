package com.beilie.test.bole.cases.审核专员;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GC13Page;
import com.beilie.test.bole.pages.GC.GC23Page;
import com.beilie.test.bole.pages.GC.GC37Page;
import org.junit.Test;

public class GC37待审核的合同 extends BoleBase {
    @Test
    public void 合同审核通过() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657209", "1").sleepForSeconds(3);
        GC37Page gc37Page = (GC37Page) bdHomePage
                //.clickClientManger("待审核的合同",14)//开发环境dululu
                .clickMenus(" 客户合同", "待审核的合同")//点击菜单栏
                .switchToNewIframe1("GC37", GC37Page.class).sleepForSeconds(3);

        //获取审核合同的公司名称
        String companyName = gc37Page.clickSearch().sleepForSeconds(1)//点击搜索按钮
                .getCompanyName();

        GC23Page gc23Page = (GC23Page) gc37Page
                .clickContractNo()//点击合同编号
                .switchToNewIframe(0, GC23Page.class).sleepForSeconds(2);

        BdHomePage bdHomePage_1 = (BdHomePage) gc23Page.clickAuditContractBtn().sleepForSeconds(1)//点击【审核合同】按钮
                .clickPass()//点击【审核通过】按钮
                .switchOutIframe(BdHomePage.class);

        GC13Page gc13Page = (GC13Page) bdHomePage_1
                //.clickSecondMenu("合同管理",0)
                .clickSingleMenu("合同管理")
                .switchToNewIframe1("GC13", GC13Page.class).sleepForSeconds(1);

        gc13Page.inputCompanyName(companyName)//输入客户名称
                .clickSearch().sleepForSeconds(3)//点击搜索按钮
                .checkContractStatus().sleepForSeconds(3)

        ;


    }
}
