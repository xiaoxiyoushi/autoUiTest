package com.beilie.test.bole.cases.客户部.我的客户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GC12Page;
import com.beilie.test.bole.pages.GC.GC14Page;
import com.beilie.test.bole.pages.GC.GCCM02Page;
import org.testng.annotations.Test;

public class _03GC12提交合同 extends BoleBase {
    @Test(description="测试提交合同成功")
    public void 提交合同() throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("bd_userName", "bd_password").sleepForSeconds(3);

        bdHomePage.closeHideMenue();//关闭设置隐藏菜单的弹窗
        GC14Page gc14Page = (GC14Page) bdHomePage
                .clickMenu_myContract()//点开菜单“我的合同”
                .switchToNewIframe1("GC14", GC14Page.class).sleepForSeconds(1);

        GC12Page gc12Page = (GC12Page) gc14Page
                .contractNumb_click(3, 0)//点击合同状态：草稿，点击合同编号
                .switchToNewIframe(0, GC12Page.class).sleepForSeconds(1);

        String contractNumb = gc12Page.contarctNumb();//获取合同编号
        String clientName = gc12Page.clientName();//获取客户名称

        GC14Page gc14Page1 = (GC14Page) gc12Page.party_send()//输入甲乙方公司
                .selectStartTime()//选择开始时间
                .sendInputPlaceholder("请输入法人", "马云法人")//输入法人
                .ContactPerson("021-1234")//选择联系人
                .sleepForSeconds(1)
                .ContactAddress()//选择地址
                .Charges()//计费方式
                .uploadFile().sleepForSeconds(4)//上传合同附件
                .submit().sleepForSeconds(2)//保存并且提交合同
                .switchToNewIframe1("GC14", GC14Page.class).sleepForSeconds(1);

        //核对合同提交成功
        gc14Page1.checkContract_submit(clientName,contractNumb)
        .sleepForSeconds(1);
    }
}

