package com.beilie.test.open.hunters.pages;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import java.util.List;
import java.util.Random;

public class ResumeDetailPage extends UIPage<ResumeDetailPage>{
    public ResumeDetailPage viewContactInformation(){
        this.findByCssSelector("div.pdiv.clearfix.fr").click();
        return this;
    }

    public ResumeDetailPage getPhone(){
        //String str=this.findByClassName("personals clearfix").findListByTagName("div").get(1).findByClassName("contentErea fl colorBlack").findListByTagName("div").get(2).findByTagName("div").getText();
        String str=this.findByCssSelector("div.personals.clearfix > div:nth-child(2) > div > div > div > div.font14.mt10.clearfix > div:nth-child(1)").getText();
        String str1="****";
        //boolean b=str1.contains(str);
        if(str.contains(str1)){
            this.findByCssSelector("div.pdiv.clearfix.fr").click();
        }

        if(!(str.contains(str1))){
            this.findByXPath("//*[@id=\"batchResumewrap\"]/div[2]/div[2]/div[1]/div[3]/div[2]").click();
            //this.findByCssSelector("#bg > div.bgWhite > div > div:nth-child(3) > a").click();
        }
        return this;
    }
    /*public ResumeDetailPage addConnect(){
        this.findByCssSelector("#bg > div.bgWhite > div > div:nth-child(3) > a").click();
        return this;
    }*/
    public ResumeDetailPage assertNoConnectAlert(){
        //判定是否弹出了获取联系方式弹框
        //String connect = this.findByCssSelector("body > div:nth-child(7) > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div > p").getText();
        String connect = this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-header > span").getText();
        Assert.assertEquals("您确认消耗40金币来获得该求职者联系方式？", connect);
         return this;
    }

    public ResumeDetailPage grouping(){
        String str2= Public.generateString(6);
        //this.findByXPath("//*[@id=\"batchResumewrap\"]/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[1]").click();
        this.findByXPath("//*[@id=\"batchResumewrap\"]/div[2]/div[2]/div[1]/div[3]/div[2]").click();
        this.findByXPath("//*[@id=\"batchResumewrap\"]/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[1]").click();
        String str=this.findByXPath("//*[@id=\"modalWidth550\"]/div[2]/div/div/div[1]/div").getText();
        if("请设置分组".equals(str)){
            //#modalWidth550 > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div.content > div:nth-child(1) > div
                //Element ele=this.findByCssSelector("#modalWidth550 > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div.content > div.contentInput");
            Element ele=this.findByCssSelector("#modalWidth550 > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div.content > div:nth-child(1) > div");
                ele.findByTagName("input").sendKeys(str2);
                ele.findByTagName("span").click();

            //List<Element> eles = this.findByCssSelector("#modalWidth550 > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div.content > div.contentMenu").findListByClassName("l1");
            List<Element> eles = this.findListByXPath("//*[@id=\"modalWidth550\"]/div[2]/div/div/div[2]/div[1]/div[2]/child::div");

            for(int i=0;i<eles.size();i++){
                Element ele1=eles.get(i).findByCssSelector("div.divLi > span:nth-child(2)");
                String str1=ele1.getText();
                if(str2.equals(str1)){
                    //eles.get(i).findByTagName("input").click();
                    //ele1.click();
                    eles.get(i).findByCssSelector("div.divLi > span:nth-child(1)").click();
                    this.findByCssSelector("#modalWidth550 > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div.footer > button.footerSaveBtn.backgroundColor.mgr10.cursor").click();
                     break;
                }
            }
        }
        return this;
    }
}
