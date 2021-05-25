package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;

public class EBFA07Page extends Public<EBFA07Page> {

    public EBFA07Page addConfirmBtn_click(String str){
        this.findByXPath("//div[text()=\""+str+"\"]/parent::div/parent::div//div[text()=\"确定\"]").click();
        return this;
    }
    public String getPageValue(){
        String  pageNumb=this.findByClassName("paging").findByTagName("span").getText();
        return pageNumb;
    }
    //确认删除 点击【确定】
    public EBFA07Page confirmBtnDelete_click(String str){
        this.findByXPath("//*[@id=\"inquiryEBFA06_modal\"]//div[text()=\""+str+"\"]").click();
        return this;
    }

}
