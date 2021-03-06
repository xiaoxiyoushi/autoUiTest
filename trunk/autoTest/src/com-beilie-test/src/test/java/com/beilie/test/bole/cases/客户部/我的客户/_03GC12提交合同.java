package com.beilie.test.bole.cases.客户部.我的客户;

import com.beilie.test.bole.core.BoleBase;
import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.bole.pages.GC.GC12Page;
import com.beilie.test.bole.pages.GC.GC14Page;
import org.junit.Test;

public class _03GC12提交合同 extends BoleBase {
    @Test
    public void test ()throws IllegalAccessException, InstantiationException, InterruptedException {
        BdHomePage bdHomePage = login("68657224", "1").sleepForSeconds(3);

        //GC14Page gcc14Page=(GC14Page)bdHomePage.clickClientManger("我的合同",14)//点击菜单 我的合同
        GC14Page gcc14Page=(GC14Page)bdHomePage.clickMenus("\n" +
                "          客户合同","我的合同")//点击菜单 我的合同
                .switchToNewIframe1("GC14", GC14Page.class).sleepForSeconds(1);

        GC12Page gc12Page=(GC12Page)gcc14Page.clickContractStatus(3)//点击合同状态 草稿
                .clickContractNo(0)//点击合同编号
                .switchToNewIframe(0,GC12Page.class).sleepForSeconds(1);

        Object contractNo=gc12Page.store().get(0);//合同编号
        Object clientName=gc12Page.store().get(1);//客户名称

        gc12Page.inputParty("上海甲方公司","上海乙方公司")//输入甲乙方公司
                .selectStartTime()//选择开始时间
                .inputLegalPerson("马云法人")//输入法人
                .ContactPerson("021-1234")//联系人
                .ContactAddress()//选择地址
                .Charges()//计费方式
                .uploadFile().sleepForSeconds(1)//上传合同附件
                .submit().sleepForSeconds(2)//保存并且提交合同
                ;
       }
    }

