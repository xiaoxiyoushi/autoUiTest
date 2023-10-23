package com.beilie.test.open.WwwHome.pages;

import com.beilie.core.exceptions.BusinessException;
import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;

import java.util.List;

public class WwwHomePage extends UIPage<WwwHomePage>{

    public WwwHomePage clickMenuItem(String menuName,int i) throws InterruptedException {
        String className = null;
        //String headerName=this.findListByClassName("decorationNone").get(i).getText();
        //if (StringUtils.equals(headerName, str))
        className = "positionLi";
        Element linkText = this.findListByClassName(className).get(i);
        linkText.hover();
        this.sleepForSeconds(2);
        linkText.findListByTagName("a").parallelStream().filter(a -> StringUtils.equals(a.getText(), menuName)).findFirst().get().click();
        return this;
    }

    /**
     * 判定当前页面是已经加载成功的；
     */
    public Boolean isLoad() {
        return Boolean.TRUE;
    }
    /**
     * 断言是否已经完成客户管理页面的加载；
     */

    public WwwHomePage assertLoaded() {
        if(Boolean.TRUE.equals(this.isLoad())){
            return this;
        }
        throw new BusinessException("页面加载失败。");
    }
    public WwwHomePage clickHeader(String text) throws IllegalAccessException, InstantiationException {
        /*this.waitFor(2, d -> {
            this.findByCssSelector("#wrap > div:nth-child(3) > div.com-index.map.ivu-col.ivu-col-span-20.ivu-col-offset-2 > div > div:nth-child(1) > div > div > div.ivu-tabs-bar > div > div > div > div").findByLinkText(text).click();
            return Boolean.TRUE;
        });*/
        return this;
    }
    /**
     * 点击banner
     */
    //选择第一个banner
    public Element eles(int i){
        Element element=this.findListByCssSelector("#banner > div > ul").get(i);
        return element;
    }
    public WwwHomePage clickFirstBanner(){
        eles(0).click();
        return this;
    }
    public WwwHomePage clickBanner(){
        this.findByCssSelector("#banner > div > div > div > div:nth-child(1) > div > img").click();
        return this;
    }

    /**
     * 点击 导航栏：职位
     */
    public WwwHomePage clickPosition(){
        /*this.waitFor(10,d -> {
            this.findByCssSelector("#header_bg > div > div.headerCenter > div > div.headerName.fl > ul > li.positionLi > a").click();
        return Boolean.TRUE;
                });*/
        return this;
    }

    /**
     * 点击  各个行业下的 职位
     * i0：哪个行业
     * i1：第几个职位
     */
    /*public Element eles1(int i0,int i1){
        Element element=this.findByCssSelector("div.ivu-tabs-content.ivu-tabs-content-animated")
                .findListByClassName("ivu-tabs-tabpane").get(i0)
                .findListByClassName("position").get(i1);
        return element;
    }

    public WwwHomePage clickInternetPosition(int i2,int i3){
        eles1(i2,i3).click();
        return this;
    }*/

    public WwwHomePage clickInternetPosition(int i){
        this.findListByXPath("//*[@id=\"anchor_hotposition\"]/div[3]/child::div")
                .get(i).click();
        return this;
    }

    /**
     * 选行业栏
     */
    public WwwHomePage chooseIndustry(int i) throws IllegalAccessException, InstantiationException{
        /*this.waitFor(10, d -> {
            this.findByCssSelector("#anchor_hotposition > div.tabcube")
                    .findListByTagName("span").get(i).click();
            return Boolean.TRUE;
        });*/
            return this;
    }
    /*
    星探
     */
    public WwwHomePage clickXinTan(){
        this.findByCssSelector("#wrap > div:nth-child(4) > div > div.clearfix.hearH > div > span").click();
        return this;
    }
    //点击高薪星探
    public WwwHomePage clickGaoXinXinTan(){
        this.findByCssSelector("#wrap > div:nth-child(4) > div > div.hunterTabBox > div > div:nth-child(1) > div > img").click();
        return this;
    }
    //点击第一个猎头名字
    public WwwHomePage clickFirstHunter(){
        this.findByClassName("cloneBox").findByClassName("talent").click();
        this.findByClassName("cloneBox").findByClassName("talent").findByClassName("name").click();
        return this;
    }


    /**
     * 点击猎头 头像
     */
    public WwwHomePage clickHunter(int i){

        this.findByCssSelector("#wrap > div:nth-child(3) > div.com-index.map.ivu-col.ivu-col-span-20.ivu-col-offset-2 > div > div:nth-child(2) > div")
                .findListByClassName("company")
                .get(i).findByTagName("img").click();
        return this;
        //#wrap > div:nth-child(4) > div > div.tabInfoBox > div:nth-child(1) > div.logoErea > div > img
        //#wrap > div:nth-child(4) > div > div.tabInfoBox > div:nth-child(2) > div.logoErea > div > img
    }

    public WwwHomePage clickHunter(){

        this.findByCssSelector("#wrap > div:nth-child(5) > div > div.tabInfoBox > div:nth-child(1) > div.logoErea > div > img").click();
        return this;
        //#wrap > div:nth-child(4) > div > div.tabInfoBox > div:nth-child(1) > div.logoErea > div > img
        //#wrap > div:nth-child(4) > div > div.tabInfoBox > div:nth-child(2) > div.logoErea > div > img
        //#wrap > div:nth-child(5) > div > div.tabInfoBox > div:nth-child(1) > div.logoErea > div > img
    }

    /**
     * 点击猎头卡片里的 职位
     */
    //点击职位
    public WwwHomePage clickHunterPosition(int i){
        this.findByCssSelector("#wrap > div:nth-child(3) > div.com-index.map.ivu-col.ivu-col-span-20.ivu-col-offset-2 > div > div:nth-child(2) > div")
                .findListByClassName("company")
                .get(i).findByClassName("job").click();
        return this;
    }
    /**
     * 职场风向标
     * 问卷报告
     */
    public WwwHomePage clickSearch(int i){
        this.findByCssSelector("#anchor_jobVune > div > div.jobimg")
                .findListByClassName("position").get(i).click();
        return this;
    }
    /**
     * 求职攻略
     */
    public WwwHomePage clickRaiders(int i,int j){
        this.findByCssSelector("#anchor_jobVune > div > div.ulli")
                .findListByClassName("ul").get(i).findByTagName("ul")
                .findListByTagName("li").get(j).click();
        return this;
    }
    /**
     * 首页底部
      */
    //谈聘网简介
    public Element eles2(int i,int j){
        Element element=this.findByCssSelector("#bg > div > div > div.footBody.clearfix ")
                .findListByClassName("fl").get(i).findListByTagName("li").get(j);
        return element;
    }
    public WwwHomePage clickIntroduction(){
        eles2(0,1).click();
        return this;
    }
    //联系我们
    public WwwHomePage connectUs(){
        eles2(0,2).click();
        return this;
    }
    //意见反馈
    public WwwHomePage feedBack(){
        eles2(1,1).click();
        return this;
    }
    //常见问题
    public WwwHomePage commonProblem(){
        eles2(1,2).click();
        return this;
    }
    //用户服务协议
    public WwwHomePage userServicesAgreement(){
        eles2(1,3).click();
        return this;
    }
    /*
    友情链接
     */
    public Element eles3(int i){
        Element element=this.findByCssSelector("#bg > div > div > ul").findListByTagName("a").get(i);
        return element;
    }
    public WwwHomePage clickLink(int i){
        eles3(i).click();
        return this;
    }
    /**
     *验证 注册、我要找工作、我要招聘
     */
    public WwwHomePage clickRegistered(){
        this.findByCssSelector("#header_bg > div > div.headeerTop > div > div > ul > li:nth-child(3) > a").click();
        return this;
    }
    public WwwHomePage clickJob(){
        this.findByCssSelector("#header_bg > div > div.headeerTop > div > div > ul > li:nth-child(2) > a").click();
        return this;
    }
    public WwwHomePage clickRecruitment(){
        this.findByCssSelector("#header_bg > div > div.headeerTop > div > div > ul > li:nth-child(1) > a").click();
        return this;
    }


}
