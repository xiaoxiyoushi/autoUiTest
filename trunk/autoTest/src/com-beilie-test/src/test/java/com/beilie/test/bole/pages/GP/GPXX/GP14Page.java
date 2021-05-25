package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP14Page extends Public<GP14Page> {
    public GP14Page clickReport(){
        this.findByClassName("ivu-radio-inner").click();
        return this;
    }

    public GP14Page clickConfirmBtn(){
        this.findByClassName("ivu-btn-primary").click();
        return this;
    }

    public GP14Page clickSubmitInterviewBtn(){
        this.findByClassName("canButton").click();
        return this;
    }

    public GP14Page confirmBackground(){
        this.findByCssSelector("body > div:nth-child(6) > div.ivu-modal-wrap > div > div > div.ivu-modal-footer > div > button:nth-child(2)").click();
        return this;
    }
}
