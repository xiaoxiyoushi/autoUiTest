package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.bole.core.Common;
import com.beilie.test.open.PublicClass.Public;

public class GP14Page extends Common<GP14Page> {
    /*public GP14Page clickReport(){
        this.findByClassName("ivu-radio-inner").click();
        return this;
    }*/

    public GP14Page clickConfirmBtn(String str){
        this.findByXPath("//button[@class=\""+str+"\"]").click();
        return this;
    }

    /*public GP14Page clickSubmitInterviewBtn(){
        this.findByClassName("canButton").click();
        return this;
    }*/

    public GP14Page tanchuang_quedingButton_click(){
        this.findByXPath("//button[@class=\"easy-modal-ok ivu-btn ivu-btn-primary\"]").click();
        return this;
    }

    /*public GP14Page oprationButton_click(){
        this.findByXPath("//button[@class=\"itemstyle operation\"]").click();

        return this;
    }*/

    public GP14Page carryButton_click(){
        this.findByXPath("//div[@class=\"itemstyle operation\"]/button").click();
        return this;
    }

    public GP14Page deleteButton_click(){
        this.findByXPath("//div[text()=\"是否确认删除推荐报告\"]/parent::div/parent::div/following-sibling::div//span[text()=\"确定\"]").click();
        return this;
    }
}
