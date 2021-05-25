package com.beilie.test.bole.pages.GP;

import com.beilie.test.bole.pages.GP.GPXX.GP14Page;
import com.beilie.test.open.PublicClass.Public;

public class GPPC01Page extends Public<GPPC01Page> {
    public GPPC01Page uploadBackground(String path){
        this.findByClassName("ivu-upload-input").sendKeys(path);;
        return this;
    }

    public GPPC01Page clickSure(){
        this.findByClassName("sureBtn").click();
        return this;
    }

}
