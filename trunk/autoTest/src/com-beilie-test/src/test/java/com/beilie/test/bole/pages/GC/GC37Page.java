package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import java.util.List;
//GC37待审核的合同
public class GC37Page extends Public<GC37Page> {
    public List<Element> elements(){
        List<Element> elements=this.findByClassName("ivu-table-tbody").findListByTagName("tr");
        return elements;
    }

    //点击合同编号
    public GC37Page clickContractNo(){
        elements().get(0).findListByTagName("td").get(0).click();
        return this;
    }

    //获取审核合同的公司名称
    public String getCompanyName(){
        String companyName=elements().get(0).findListByTagName("td").get(1).getText();
        return companyName;
    }

    //点击搜索按钮
    public GC37Page clickSearch(){
        this.findByXPath("//span[text()=\"搜索\"]").click();
        return this;
    }
}
