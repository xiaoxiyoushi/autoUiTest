package com.beilie.test.bole.pages.GP.GPCP;

import com.beilie.test.open.PublicClass.Public;

public class GPCP06Page extends Public<GPCP06Page> {
    public GPCP06Page filterCustomerName(String str,String str1){
        int n=this.findListByXPath("//div[@class=\""+str+"\"]").size();
        for (int i=0;i<n;i++) {
            String customer=this.findListByXPath("//div[@class=\""+str+"\"]").get(i).getText();
            if (customer.equals(str1)) {
                this.findListByXPath("//div[@class=\""+str+"\"]").get(i).click();
                break;
            }
        }
        return this;
    }
}
