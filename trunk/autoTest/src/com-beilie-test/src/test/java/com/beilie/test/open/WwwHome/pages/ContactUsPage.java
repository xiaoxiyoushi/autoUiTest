package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class ContactUsPage extends UIPage<ContactUsPage> {
    public ContactUsPage checkCompanyName(){
        String companyName=this.findByXPath("//*[@id=\"dituContent\"]/div[1]/div[2]/div[1]/div/div[9]/div[2]/b").getText();
        Assert.assertEquals("上海谈聘网络科技有限公司",companyName);
        return this;
    }
    public ContactUsPage clickCross(){
        this.findByCssSelector("#dituContent > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div > img:nth-child(10)").click();
        return this;
    }
    /**
     * 提交联系我们
     */
    public Element eles(int i){
        Element element=this.findByCssSelector("#inputBoxWrap > div > div.handleBox > form ")
                .findListByClassName("ivu-form-item").get(i);
        return element;
    }

    public ContactUsPage writeName(int i,String name){
        eles(i).findByTagName("input").sendKeys(name);
        return this;
    }
    //点击确定按钮
    public ContactUsPage clickQueRen(){
        //this.findByCssSelector("#okContact").click();
        //this.findByClassName("btnBox").findByTagName("button").click();
        this.findById("okContact").click();
        return this;
    }
    public ContactUsPage checkTiShi(){
        String str=this.findByCssSelector("#showPositionbtn > div.succModal > p").getText();
        Assert.assertEquals("信息提交成功啦,我们会尽快与您取得联系,请耐心等待！",str);
        return this;
    }

}
