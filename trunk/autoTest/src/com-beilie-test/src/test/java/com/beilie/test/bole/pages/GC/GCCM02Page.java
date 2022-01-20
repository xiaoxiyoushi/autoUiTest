package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;

public class GCCM02Page extends Public<GCCM02Page> {
    //第i行，第j个
    public Element element(int i,int j){
        Element element=this.findById("homeIndex")
                              .findListByClassName("ivu-row").get(i)
                                .findListByClassName("ivu-col").get(j);
        return element;
    }

    //点击未保护框
    public GCCM02Page clickProtectInput(){
        element(0,2).findByTagName("span").click();
        return this;
    }
    //选择未保护
    public GCCM02Page selectUnprotected(int i){
        element(0,2).findListByClassName("ivu-select-item").get(i).click();
        return this;
    }

    //table元素
    public Element trElement(int i,int j){
        Element trElement=this.findByClassName("ivu-table-fixed-body")
                                .findListByTagName("tr").get(i)
                                  .findListByTagName("td").get(j);
        return trElement;
    }

    //点击一个客户名称
    public GCCM02Page clickOneClientName(){
        trElement(0,0).click();
        return this;
    }

}
