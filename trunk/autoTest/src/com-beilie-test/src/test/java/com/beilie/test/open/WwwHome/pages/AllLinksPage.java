package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.open.WwwHome.core.WwwBase;
import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.Engine;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllLinksPage extends UIPage<AllLinksPage> {
    //教师招聘
    public AllLinksPage checkEducation(){
        /*this.waitFor(10, d -> {
            this.findByCssSelector("#loginToolBar > div > span").click();
            return Boolean.TRUE;
        });*/
        return this;
    }
    //事业单位招聘
    public AllLinksPage checkInstitution(){
        String str=this.findByCssSelector("body > div.fxBox > div > div.pic.fl > p").getText();
        Assert.assertEquals("快捷入口",str);
        return this;
    }
    //企业征信
    public AllLinksPage checkCorporateCredit(){
        /*this.waitFor(10, d -> {
            String str=this.findByCssSelector("#search_items > span.entInfo.selected").getText();
            Assert.assertEquals("企业信用信息",str);
            return Boolean.TRUE;
        });*/
        return this;
    }
    //银行招聘
    public AllLinksPage checkBank(){
        String str=this.findByCssSelector("#midder > div.div-1 > div.mid > div.hd > h3").getText();
        Assert.assertEquals("最新银行招聘信息",str);
        return this;
    }
    //考研信息网
    public AllLinksPage checkPostgraduate(){
        String str=this.findByCssSelector("body > div.main-wrapper > div.container > div.index-row.part01.clearfix > div.yz-left > dl > dt:nth-child(1)").getText();
        //boolean b=str.contains("报名入口");
        Assert.assertEquals("报名入口",str);
        return this;
    }
    //国家公务员考试网
    public AllLinksPage checkNationalCivil(){
        String str=this.findByCssSelector("#div01 > div.box01_head > span").getText();
        Assert.assertEquals("重要通知",str);
        return this;
    }
    //上海市人力资源社会保障网
    public AllLinksPage checkHumanResources(){
        String str=this.findByCssSelector("#main > div.row.postcard > div.col-md-3 > ul > li:nth-child(1) > h2 > a").getText();
        Assert.assertEquals("新闻发布",str);
        return this;
    }
    //人力资源和社会保障部
    public AllLinksPage checkHumanResources1(){
        String str=this.findByCssSelector("body > div.main > div.main_m > div.nav > li.hover > a").getText();
        Assert.assertEquals("新闻中心",str);
        return this;
    }

    /*public static UIPage waitWebElement(Engine driver, final By by) {
        UIPage waitElement = null;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            // 创建一个新的ExpectedCondition接口，实现apply方法
            waitElement = wait.until(new ExpectedCondition<UIPage>(){
                public UIPage apply(Engine d) {
                    return d.findElement(by);
                }
            });
        } catch (Exception e) {
            System.out.println(by.toString() + " is not exist until " + second);
        }
        return waitElement;
    }
*/
}
