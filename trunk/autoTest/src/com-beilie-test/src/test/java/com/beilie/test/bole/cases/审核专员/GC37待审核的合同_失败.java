package com.beilie.test.bole.cases.审核专员;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GC23Page;
import com.beilie.test.bole.pages.GC.GC37Page;
import org.junit.Test;

public class GC37待审核的合同_失败 extends BoleBase {
    /*@Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException{
        BdHomePage bdHomePage = login("68657230", "1").sleepForSeconds(3);
        GC37Page gc37Page=(GC37Page)bdHomePage
                .clickClientManger("待审核的合同",0)//点击菜单栏
                .switchToNewIframe1("GC37",GC37Page.class);

        GC23Page gc23Page=(GC23Page)gc37Page
                .clickContractNo()//点击合同编号
                .switchToNewIframe(0,GC23Page.class);

        gc23Page.clickAuditContractBtn().sleepForSeconds(1)//点击【审核合同】按钮
                .clickFail()//点击【审核不通过】按钮
        .clickSubmit()
        ;
    }*/
}
