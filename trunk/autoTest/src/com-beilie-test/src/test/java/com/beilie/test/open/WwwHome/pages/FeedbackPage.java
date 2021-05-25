package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class FeedbackPage extends UIPage<FeedbackPage> {
   /*
   意见反馈，输入信息
    */
    public Element eles(int i){
        Element element=this.findByCssSelector("#feedbackModalx > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form")
                .findListByClassName("ivu-form-item").get(i).findByClassName("ivu-input");
        return element;
    }
    public FeedbackPage writeInformation(int i,String str){
        eles(i).sendKeys(str);
        return this;
    }

    //点击确定
    public FeedbackPage clickQueRen(){
        this.findByCssSelector("#feedbackModalx > div.ivu-modal-wrap > div > div > div.ivu-modal-footer > div > button").click();
        return this;
    }
    //校验提示
    public FeedbackPage checkTiShi(){
        String str=this.findByCssSelector("#showPositionbtn > div.succModal > p").getText();
        Assert.assertEquals("意见反馈提交成功",str);
        return this;
    }
}
