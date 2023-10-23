package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;

public class GC02Page extends Public<GC02Page> {
    public Element element(int i){
        Element element=this.findByClassName("ivu-form-label-right")
                .findListByClassName("ivu-row").get(i);
        return element;
    }

    //输入姓名
    public GC02Page inputName(String name){
        String name1=name+Public.generateString(6);
        element(0).findByTagName("input").sendKeys(name1);
        return this;
    }

    //输入手机号
    public GC02Page inputPhone(String phone){
        String phone1=phone+Public.generateString(6);
        element(1).findListByTagName("input").get(1).sendKeys(phone1);
        return this;
    }

    //输入邮箱
    public GC02Page inputEmail(String email){
        String email1=email+Public.generateString(3);
        element(2).findListByTagName("input").get(1).sendKeys(email1);
        return this;
    }

    //点击保存
    public GC02Page clickSave(){
        this.findListByXPath("//div[@class=\"ef-modal-page-footer ef-page-footer\"]/button")
                .get(1)
                .click();
        return this;
    }

}
