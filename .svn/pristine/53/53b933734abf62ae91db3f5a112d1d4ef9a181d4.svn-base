package com.beilie.test.open.applicants.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

import java.util.List;

public class AppPositionDetailPage extends UIPage<AppPositionDetailPage> {
    public AppPositionDetailPage checkPosition(){
        String positionName=this.findByClassName("nameclass").getText();
        Assert.assertTrue(positionName.contains("成本控制员"));
        /*if(){
            this.findByCssSelector("#bg > div > div.rightBox.fr > div.mt70 > button").click();
        }*/
        return this;
    }

    public AppPositionDetailPage clickHunter(){
          this.findByCssSelector("#wrap > div.w300.fr > div.bgh > div > div.avatar > div > div.photos > img").click();
          return this;
    }

    //校验职能
    public AppPositionDetailPage checkFunction(){

        List<Element> elements=this.findByClassName("leftBox")
                                   .findByClassName("mt24")
                                   .findListByTagName("em");

         String str=elements.get(1).getText();
         Assert.assertTrue(str.contains("软件工程师"));

        return this;
    }

    public AppPositionDetailPage checkPositionDetail1(){
        String str=this.findByCssSelector("#bg > div > div > div > div:nth-child(1) > h3").getText();
        Assert.assertEquals("职位描述",str);
        return this;
    }

}
