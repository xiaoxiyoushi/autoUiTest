package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP52Page extends Public<GP52Page> {
    public GP52Page clickSubmit(){
        this.findByClassName("ef-btn-submit").click();
        return this;
    }
}
