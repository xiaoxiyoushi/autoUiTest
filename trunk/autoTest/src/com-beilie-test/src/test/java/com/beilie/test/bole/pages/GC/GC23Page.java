package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;

//gty6t
public class GC23Page extends Public<GC23Page> {

    //点击【审核合同】按钮
    public GC23Page clickAuditContractBtn(){
        this.findByClassName("ivu-btn-error").click();
        return this;
    }

    //点击【审核通过】按钮
    public GC23Page clickPass(){
        //this.findByClassName("GC23_ac").findByClassName("btnPanels").findByClassName("aPassBtn").click();
        this.findByClassName("aPassBtn").click();
        return this;
    }

    //点击【审核不通过】按钮
    public GC23Page clickFail(){
        //this.findByClassName("GC23_ac").findByClassName("btnPanels").findByClassName("aPassBtn").click();
        this.findByClassName("aFaileBtn").click();
        return this;
    }

    //填写不通过理由
    public GC23Page inputReason(){
        this.findByClassName("nopassR").findByTagName("textarea").sendKeys("审核合同不通过的理由");
        return this;
    }

    //点击【确定】按钮
    public GC23Page clickSubmit(){
        this.findByClassName("nopassR").findByClassName("aPassBtn").click();
        return this;
    }

}
