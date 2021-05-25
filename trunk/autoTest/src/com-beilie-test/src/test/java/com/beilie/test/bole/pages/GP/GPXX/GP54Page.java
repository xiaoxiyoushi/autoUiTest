package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP54Page extends Public<GP54Page> {
    public GP54Page selectTime() throws InterruptedException{
        this.findByClassName("ivu-date-picker-cells-cell-today").click();//选择当天
        this.sleepForSeconds(1);
        this.findByXPath("//span[text()=\"确定\"]").click();//点击【确定】按钮
        return this;
    }

    public GP54Page clickSubmit(){
        this.findByClassName("ef-btn-submit").click();
        return this;
    }
}
