package com.beilie.test.bole.pages.GLAC;

import com.beilie.test.bole.pages.DH.DHSP06Page;
import com.beilie.test.open.PublicClass.Public;

public class GLAC01Page extends Public<GLAC01Page> {
    public String tagNumber(){
        String tagNumber=this.findByClassName("font-weight-900").getText();
        return tagNumber;
    }
}
