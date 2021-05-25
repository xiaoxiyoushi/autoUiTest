package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;

import java.util.List;

//GC13合同管理
public class GC13Page extends Public<GC13Page> {
    public List<Element> elements(){
        List<Element> elements=this.findByClassName("ivu-table-tbody").findListByTagName("tr");
        return elements;
    }

     //输入客户名称
    public GC13Page inputCompanyName(String companyName){
        this.findByXPath("//input[@placeholder=\"请输入客户名称\"]").sendKeys(companyName);
        return this;
    }

    //点击搜索按钮
    public GC13Page clickSearch(){
        this.findByXPath("//span[text()=\"搜索\"]").click();
        return this;
    }

    //核对合同状态
    public GC13Page checkContractStatus(){
        String contractStatus=elements().get(0).findListByTagName("td").get(2).getText();
        Assert.assertEquals(contractStatus,"审核通过");
        return this;
    }

}
