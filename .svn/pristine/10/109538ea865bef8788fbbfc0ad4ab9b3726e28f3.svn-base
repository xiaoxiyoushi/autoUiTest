package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.Engine;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class PositionDetailPage extends UIPage<PositionDetailPage> {
    /*public List<Element> elements(){
        //Element element=this.findListByClassName("formButtons");
        List<Element> elements=this.findListByClassName("formButtons");
        return elements;
    }*/

    public Element element(int i){
        Element element=this.findListByClassName("formButtons").get(i);
        return element;
    }

    public PositionDetailPage clickCollection(){
        /*this.waitFor(10,d -> {
            eles().findByTagName("a").click();
            return Boolean.TRUE;
        });*/

        element(0).click();
        return this;
    }

    public PositionDetailPage applyPosition(){
        this.element(1).click();
        return this;
    }

    public PositionDetailPage clickLogin(){
        this.element(2).click();
        return this;
    }
    public PositionDetailPage clickRegistere(){
        this.element(3).click();
        return this;
    }

    public PositionDetailPage checkCurrentUrl(){
        String url= Engine.getCurrentPageUrl();
        String url1="https://www.tanpin.com/#/positionDetail";
        Boolean b=url.startsWith(url1);
        Assert.assertTrue(b);
        return this;
    }
}
