package com.beilie.test.bole.pages.DH;

import com.beilie.test.open.PublicClass.Public;

public class DHSP06Page extends Public<DHSP06Page> {
public String opration(){
   String oprationText=this.findByClassName("ivu-table-fixed-body")
           .findByTagName("tr")
           .findByTagName("span")
           .getText();
    return oprationText;
}

    public DHSP06Page oprationClick(){
        this.findByClassName("ivu-table-fixed-body")
                .findByTagName("tr")
                .findByTagName("span")
                .click();
        return this;
    }
}
