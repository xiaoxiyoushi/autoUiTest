package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP12Page extends Public<GP12Page> {
    public GP12Page clickConfirm(){
        this.findByCssSelector("body > div:nth-child(6) > div.ivu-modal-wrap > div > div > div.ivu-modal-footer > div > button.ivu-btn.ivu-btn-warning > span").click();
        return this;
    }

    public GP12Page clickSubmit(){
        this.findByClassName("ivu-btn-success").click();
        return this;
    }

    //选择提醒对象
    public GP12Page selectReminder(){
        ulClass_li("listyle choices",0);
        return this;
    }

    //有确定按钮
    public GP12Page selectTomorrow(String str) throws InterruptedException{
        //this.findByXPath("//input[@placeholder=\""+str+"\"]").click();
        this.findByXPath("//i[@class=\"ivu-icon ivu-icon-ios-calendar-outline ivu-input-icon ivu-input-icon-normal\"]").click();
        this.sleepForSeconds(1);
        this.findByClassName("ivu-date-picker-cells-cell-next-month").click();

        //this.findByXPath("//span[text()=\"确定\"]").click();//点击【确定】按钮
        this.findByXPath("//button[@class=\"ivu-btn ivu-btn-primary ivu-btn-small\"]").click();//点击【确定】按钮
        return this;
    }
}
