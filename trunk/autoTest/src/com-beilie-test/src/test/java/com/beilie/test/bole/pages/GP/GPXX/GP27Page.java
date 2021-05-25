package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP27Page extends Public<GP27Page> {
    public GP27Page clickReport(){
        this.findByClassName("report-btns").findByTagName("button").click();
        return this;
    }


}
