package com.beilie.test.bole.pages.GP.GPCP;

import com.beilie.test.open.PublicClass.Public;

public class GPCP07Page extends Public<GPCP07Page> {
public GPCP07Page zhangHao(String str,String str1){
    this.findByXPath("//div[@class=\""+str+"\"]//li[text()=\""+str1+"\"]").click();
    return this;
}
}
