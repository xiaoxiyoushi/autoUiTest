package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

//GP05设置项目操作顾问
public class GP05Page extends Public<GP05Page>{

    public GP05Page tickAllMember(){
        this.findByXPath("//span[text()=\"全部成员\"]/following-sibling::span").click();
        return this;
    }

    public GP05Page tickSubmit(){
        this.findByXPath("//span[text()=\"提交\"]").click();
        return this;
    }
}
