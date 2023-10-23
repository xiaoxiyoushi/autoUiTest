package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP11Page extends Public<GP11Page> {
    public GP11Page selectTime_Many(String str) throws InterruptedException{
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div//input").click();
        this.sleepForSeconds(1);

        this.findListByClassName("ivu-date-picker-transfer")
        .get(0)
        .findByClassName("ivu-date-picker-cells-cell-next-month")
        .click();

        buttonClass_click("timeConfirm_class");//点击【确定】按钮
        return this;
    }

    public GP11Page confirmTime(String str,int i){
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div//input").click();
        this.findListByClassName("ivu-date-picker-transfer")
                .get(i)
                .findByClassName("ivu-date-picker-cells-cell-today")
                .click();

        return this;
    }

    public GP11Page clickConfirm(){
        this.findByCssSelector("body > div:nth-child(5) > div.ivu-modal-wrap > div > div > div.ivu-modal-footer > div > div > div.ivu-col.ivu-col-span-10.ivu-col-offset-13 > button.ivu-btn.ivu-btn-primary > span").click();
        return this;
    }

    public GP11Page clickSubmit(){
        this.findByClassName("ivu-btn-success").click();
        return this;
    }

    public GP11Page clickStatusInput(String str){
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div//span").click();

        return this;
    }

    //*[@id="EFPage"]/div[2]/div/div/div/div[1]/form/div[3]/div[1]/div/div/div/div[1]/span[2]

}
