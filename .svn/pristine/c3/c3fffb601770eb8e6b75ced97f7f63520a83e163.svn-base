package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.Engine;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

public class HunterDetailPage extends UIPage<HunterDetailPage> {
    /*
    检验url
     */
    public HunterDetailPage checkCurrentUrl(){
        String url= Engine.getCurrentPageUrl();
        String url1="https://www.tanpin.com/#/hunterHome";
        Boolean b=url.startsWith(url1);
        Assert.assertTrue(b);
        return this;
    }

    public HunterDetailPage clickLoginButton(){
        this.findByCssSelector("#hunterHomeBg > div.bottom > div > button.formButtons.log").click();
        return this;
    }
    /**
     * 点击首页
     */
    public HunterDetailPage clickShouYe(){
        this.findByCssSelector("#header_bg > div > div.headerCenter > div > div.headerName.fl > ul > li:nth-child(1) > a").click();
        return this;
    }

    //点击关注猎头
    public HunterDetailPage clickAttention(){
        this.findByCssSelector("#hunterBodyBg > div.isTop > div.isInfo > div:nth-child(2) > span.fr.attentionBtn").click();
        return this;
    }

    //点击委托简历
    public HunterDetailPage clickEntrustedResume(){
        this.findByCssSelector("#hunterBodyBg > div.radar.fr > div:nth-child(2) > button").click();
        return this;
    }

    //和他聊聊
    public HunterDetailPage clickChat(){
        this.findByCssSelector("#hunterBodyBg > div.radar.fr > div:nth-child(3) > button").click();
        return this;
    }

    //点击企业头像
    public HunterDetailPage clickQiYe(){
        /*this.findByClassName("hunterHomeRight")
                .findByClassName("isCompany")
                .findListByClassName("isTop").get(2).findByClassName("isTopimgBox").findByTagName("img").click();*/
        //this.findByCssSelector("#hunterHomeWrap > div.hunterHomeRight > div.isCompany.mt20.mb20 > div.isTop > div > img").click();

        this.findByCssSelector("#hunterHomeWrap > div.hunterHomeRight > div.isCompany.mt20.mb20 > div.isTop > p:nth-child(2) > span.singleLine").click();
        return this;
    }

    //点击职位
    public HunterDetailPage clickPosition(){
        this.findByCssSelector("#closeBtn > img").click();
        this.findByCssSelector("#positionCard > div > div.positionName.mw70").click();
        return this;
    }

    //点击登录
    public HunterDetailPage clickLogin(){
        this.findByCssSelector("#hunterHomeBg > div.bottom > div.wrap > button.formButtons.log").click();
        return this;
    }
    //点击注册
    public HunterDetailPage clickRegistered(){
        this.findByCssSelector("#hunterHomeBg > div.bottom > div.wrap > button.formButtons.log").click();
        return this;
    }

    //校验 服务过的高薪人才
    public HunterDetailPage checkMessage(){
        String str=this.findByCssSelector("#servedtalentBanner > div.title").getText();
        Assert.assertEquals("服务过的高薪人才",str);
        return this;
    }

}
