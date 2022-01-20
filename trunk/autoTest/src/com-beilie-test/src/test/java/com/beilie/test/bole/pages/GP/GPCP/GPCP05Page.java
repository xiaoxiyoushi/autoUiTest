package com.beilie.test.bole.pages.GP.GPCP;

import com.beilie.test.open.PublicClass.Public;

public class GPCP05Page extends Public<GPCP05Page> {
    public GPCP05Page selectTime_Many(String str,String str_1){
        this.findByXPath("//input[@placeholder=\""+str+"\"]").click();
        this.findByXPath("//span[text()=\""+str_1+"\"]/following-sibling::div")
                .findByClassName("ivu-date-picker-cells-cell-today").click();
        return this;
    }
}
