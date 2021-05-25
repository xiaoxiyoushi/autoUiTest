package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;

public class GP13Page extends Public<GP13Page> {
public GP13Page sure_click(String str){
    this.findByXPath("//div[text()=\""+str+"\"]/parent::div/preceding-sibling::a/parent::div/div[3]//button").click();
    return this;
}
}
///html/body/div[2]/div[2]/div/div/div[3]