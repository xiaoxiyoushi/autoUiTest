package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.testng.Assert;

public class GC14Page extends Public<GC14Page> {
    public Element element(int i){
        Element element=this.findListByClassName("rowstyle").get(i);
        return element;
    }

    //点击合同状态：草稿，点击合同编号
    public GC14Page contractNumb_click(int i,int j) throws InterruptedException{
        element(0).findListByTagName("a").get(i).click();//点击合同状态 草稿
        this.sleepForSeconds(1);
        this.findByClassName("ivu-table-tbody").findByTagName("tr")
                .findListByTagName("td").get(j).click();//点击合同编号
        return this;
    }

    //点击合同编号
    public GC14Page clickContractNo(int i){
        this.findByClassName("ivu-table-tbody").findByTagName("tr")
                .findListByTagName("td").get(i).click();
        return this;
    }

    //核对合同提交成功
    public GC14Page checkContract_submit(String clientName,String contractNumb){
        iClass_click("gcl4_closeContractStatus_class");//叉掉草稿状态
        element(0).findListByTagName("a").get(0).click();//点击合同状态 审核中
        inputPlaceholder_send("gcl4_clientName_placeholder",clientName);//输入客户名称
        spanClick("gcl4_search");//点击【搜索】
        String str=divClass_A("gcl4_contractNumb_class");//获取合同编号
        Assert.assertEquals(contractNumb,str);//核对合同编号
        return this;
    }
}
