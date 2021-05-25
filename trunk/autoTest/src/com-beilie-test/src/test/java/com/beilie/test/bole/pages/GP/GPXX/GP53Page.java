package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP53Page extends Public<GP53Page> {
    public GP53Page clickSubmit(){
        this.findByClassName("ef-btn-submit").click();
        return this;
    }
}
