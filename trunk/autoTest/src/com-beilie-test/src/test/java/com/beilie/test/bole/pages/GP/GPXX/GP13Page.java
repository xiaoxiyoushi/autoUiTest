package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP13Page extends Public<GP13Page> {
public GP13Page sure_click(String str){
    this.findByXPath("//div[text()=\""+str+"\"]/parent::div/preceding-sibling::a/parent::div/div[3]//button[2]").click();
    return this;
}

    public GP13Page entryTime_click(int i){
        this.findListByXPath("//div[@class=\"ivu-select-dropdown ivu-date-picker-transfer\"]").get(i)
             .findByClassName("ivu-date-picker-cells-cell-today").click();
        return this;
    }

}
