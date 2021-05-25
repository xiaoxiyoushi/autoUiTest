package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class NewsPage extends UIPage<NewsPage> {
     public NewsPage clickHotNews1(){
         this.findByCssSelector("#app > div:nth-child(2) > div:nth-child(2) > div > div > div.r-patch > div.r3a > div:nth-child(1) > img").click();
         return this;
     }

    public NewsPage clickHotNews2(){
         this.findByCssSelector("#app > div:nth-child(2) > div:nth-child(2) > div > div > div.r-patch > div.r3a > div:nth-child(2) > img").click();
         return this;
    }
    public NewsPage clickHotNews3(){
        this.findByCssSelector("#app > div:nth-child(2) > div:nth-child(2) > div > div > div.r-patch > div.r3a > div:nth-child(3) > img").click();
        return this;
    }
    public NewsPage clickHotNews4(){
        this.findByCssSelector("#app > div:nth-child(2) > div:nth-child(2) > div > div > div.r-patch > div.r-ad > img:nth-child(1)").click();
        return this;
    }
    public NewsPage clickHotNews5(){
        this.findByCssSelector("#app > div:nth-child(2) > div:nth-child(2) > div > div > div.r-patch > div.r-ad > img:nth-child(2)").click();
        return this;
    }
    public NewsPage clickShouYe(){
         this.findByCssSelector("#header_bg > div > div.headerCenter > div > div.headerName.fl > ul > li:nth-child(1) > a").click();
         return this;
    }

    /**
     * 校验是否loading出资讯页，查找 是否有“热点新闻”四字
     */
    public NewsPage checkZiXun(){
        String str=this.findByCssSelector("#app > div:nth-child(2) > div:nth-child(2) > div > div > div.r-patch > div.tit > span").getText();
        Assert.assertEquals("热点新闻",str);
        return this;
    }

}
