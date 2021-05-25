package com.beilie.test.bole.pages.GP;

import com.beilie.test.bole.pages.BdHomePage;
import com.beilie.test.open.PublicClass.Public;

public class GPRR01Page extends Public<GPRR01Page> {
    public GPRR01Page selectCandidate(){
        this.findByClassName("ivu-table-body")
                .findByTagName("input").click();
        return this;
    }

    public GPRR01Page addRecommend(){
        this.findByClassName("ayBtns").click();
        return this;
    }
}
