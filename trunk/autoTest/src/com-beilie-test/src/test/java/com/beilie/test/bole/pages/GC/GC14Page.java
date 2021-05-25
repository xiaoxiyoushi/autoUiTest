package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;

public class GC14Page extends Public<GC14Page> {
    public Element element(int i){
        Element element=this.findListByClassName("rowstyle").get(i);
        return element;
    }

    //点击合同状态
    public GC14Page clickContractStatus(int i){
        element(0).findListByTagName("a").get(i).click();
        return this;
    }

    //点击合同编号
    public GC14Page clickContractNo(int i){
        this.findByClassName("ivu-table-tbody").findByTagName("tr")
                .findListByTagName("td").get(i).click();
        return this;
    }
}
