package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP11Page extends Public<GP11Page> {
    public GP11Page selectTime_Many(String str){
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div//input").click();
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-next-month").click();

        this.findByXPath("//span[text()=\"确定\"]").click();//点击【确定】按钮
        return this;
    }

    public GP11Page confirmTime(String str){
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div//input").click();
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-today").click();

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
        this.findByXPath("//label[text()=\""+str+"\"]/following-sibling::div//span[2]").click();

        return this;
    }

    //*[@id="EFPage"]/div[2]/div/div/div/div[1]/form/div[3]/div[1]/div/div/div/div[1]/span[2]

}
