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

    //有确定按钮
    public GP12Page selectTomorrow(String str) throws InterruptedException{
        this.findByXPath("//input[@placeholder=\""+str+"\"]").click();
        this.sleepForSeconds(1);
        this.findByClassName("ivu-date-picker-cells-cell-next-month").click();

        this.findByXPath("//span[text()=\"确定\"]").click();//点击【确定】按钮
        return this;
    }
}
