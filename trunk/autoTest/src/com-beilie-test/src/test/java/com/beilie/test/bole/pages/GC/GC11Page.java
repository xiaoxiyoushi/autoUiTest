package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;

//GC11编辑客户
public class GC11Page extends Public<GC11Page> {
     public Element element(int i){
         /*Element element=this.findListByXPath("//*[@id=\"bg\"]/div[2]/div/form/child::div")
                 .get(i);*/
         Element element=this.findById("GC11_app").findByTagName("form")
                             .findListByXPath("//child::div").get(i);
         return element;
     }

     //选择客户来源
     public GC11Page chooseClientSource(){
         int i=Public.generateNumber1(4);
         element(0).findListByClassName("ivu-radio-wrapper").get(i).click();
         return this;
     }

     //点击所属行业
    public GC11Page clickIndustry(){
        element(1).findByClassName("industryIcon").click();
        return this;
    }

    //点击联系地址
    public GC11Page clickAddress(){
        this.findByClassName("locationIcon").click();
        return this;
    }

    //输入联系地址
    public GC11Page inputAddress(){
        //element(3).findListByTagName("input").get(1).sendKeys("aaaa");
        this.findByXPath("//*[@id=\"bg\"]/div[2]/div/form/div[4]/div/div/div/div/div[2]/div/div/div/input").sendKeys("aaaa");
        return this;
    }

    //点击确定
    public GC11Page clickSave(){
        this.findById("GC11_app").findByClassName("ivu-btn-warning").click();
        return this;
    }


}
