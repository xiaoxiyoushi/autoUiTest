package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;

import java.util.List;

//GC18客户基本信息（CC模式）
public class GC18Page extends Public<GC18Page> {
    /*public Element element(int i){
        Element element=this.findById("header_GC18")
                            .findListByClassName("ivu-row").get(i);
        return element;
    }*/

    //选择按钮
    public GC18Page btnElement(String strBtn){
        List<Element> elements=this.findById("header_GC18").findListByTagName("button");
        int n=elements.size();
        for(int i=0;i<n;i++){
            String str=elements.get(i).getText();
            if (str.equals(strBtn)){
                elements.get(i).click();
                break;
            }
        }
        return this;
    }

    /*public GC18Page clickCreateProj(){
        this.findById("header_GC18")
        return this;
    }*/

}
