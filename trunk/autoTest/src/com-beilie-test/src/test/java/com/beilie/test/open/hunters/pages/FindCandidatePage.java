package com.beilie.test.open.hunters.pages;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

import java.util.List;

public class FindCandidatePage extends UIPage<FindCandidatePage> {
    public FindCandidatePage clickSearch() {
        this.findByClassName("searBtn").click();
        return this;
    }

    /**
     * todo
     *
     * @return
     */

    public FindCandidatePage assertNoConditionAlert() {
        //判定是否弹出了没有设置搜索条件的错误
        //String concent = this.findByCssSelector("div.succModal").findByClassName("modalConcent").getText();
        String concent = this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-header > span").getText();
        Assert.assertEquals("至少填写一个搜索条件。", concent);
        return this;
    }

    public FindCandidatePage keywords(String keywords) {
        this.findByTagName("form").findByCssSelector("input.ivu-input.ivu-input-default").sendKeys(keywords);
        return this;
    }

    /*
    职位名称
     */
    public FindCandidatePage positionName(String positionName) {
        this.findById("efPositionNameBg").findByTagName("form").findByTagName("input").sendKeys(positionName);
        return this;
    }
    /*
    公司名称
     */
    public FindCandidatePage companyName(String companyName){
        this.findByCssSelector("#efCompanyNameBg > form > div > div > div > input").sendKeys(companyName);
        return this;
    }

    public FindCandidatePage customizeSearch(){
        this.findByCssSelector("#bg > div > div.mt50.mb50 > button:nth-child(2)").click();
        return this;
    }
    public FindCandidatePage addOption(){
        this.findByCssSelector("#customizeSearchBg > div.clearfix.pd20 > div.addContent.w400.fl > p.inAdd.mt15.h480 > ul > li:nth-child(2)").click();
        return this;
    }
    public FindCandidatePage deleteOption(){
        this.findByCssSelector("#customizeSearchBg > div.clearfix.pd20 > div.addContent.w400.fl > p.inAdd.mt15.h480 > ul > li:nth-child(2)").click();
        return this;
    }
    public FindCandidatePage saveSet(){
        this.findByCssSelector("#customizeSearchBg > div.clearfix.footerBtn > button.saveBtn").click();
        return this;
    }
    /*
    选择学历
    * */
    public Element elems() {
        Element elements = this.findByCssSelector("#efDegreeBg > form > div > div > div:nth-child(1) > div > div > div.ivu-select-dropdown > ul.ivu-select-dropdown-list");
        return elements;
    }

    public FindCandidatePage degree() {
        //this.findByCssSelector("#efDegreeBg > form > div > div > div:nth-child(1) > div > div > div.ivu-select-selection > div > span").click();
        this.findById("efDegreeBg").findByTagName("span").click();
        return this;
    }

    /*本科学历*/
    public FindCandidatePage degreeBachelor() {
        this.elems().findListByTagName("li").get(6).click();
        return this;
    }

    /*专科学历*/
    public FindCandidatePage degreeSpecialist() {
        this.elems().findListByTagName("li").get(5).click();
        return this;
    }
    /*
    选择期望职能
    * */
    /*一级*/
    public FindCandidatePage expectationFunction() {
        this.findByCssSelector("#bg > form > div > div > div > input").click();
        return this;
    }

    public Element selectElems(int i) {
        Element elements = this.findByClassName("dialog-box").findListByTagName("ul").get(i);
        return elements;
    }

    public FindCandidatePage expectationFunctionProfessional() {
        //this.findByClassName("dialog-box").findListByTagName("ul").get(1).findListByTagName("li").get(0).click();
        this.selectElems(1).findListByTagName("li").get(0).click();
        return this;
    }

    /*二级*/
    public FindCandidatePage expectationFunctionIt() {
        //this.findByCssSelector("#stab\\2e level > li:nth-child(2)").click();
        this.findByClassName("dialog-box").findByTagName("ul").findListByTagName("li").get(1).click();
        return this;
    }

    /*三级*/
    public FindCandidatePage expectationFunctionEngineer() {
        this.findByClassName("dialog-box").findByTagName("ul").findListByTagName("li").get(2).click();
        return this;
    }

    public FindCandidatePage submitExpectationFunction() {
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        return this;
    }

    /*
    期望地点
    * */
    public FindCandidatePage expectedLocation() {
        this.findByCssSelector("#bg > div > div:nth-child(8) > #bg > form > div > div > div > input").click();
        return this;
    }

    public Element selectElems1(int i) {
        Element elements = this.findByClassName("tab-body functionName").findListByTagName("ul").get(i);
        return elements;
    }

    public FindCandidatePage expectationLocation1() {
        this.selectElems(0).findListByTagName("li").get(7).click();
        return this;
    }

    public FindCandidatePage expectationLocation2() {
        this.findById("stab.level").findListByTagName("li").get(28).click();
        return this;
    }

    public FindCandidatePage submitExpectationLocation() {
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        return this;
    }


    /*保存搜索条件
     * */
    public FindCandidatePage saveSearch() {
        this.findByCssSelector("#bg > div > div.mt50.mb50 > button:nth-child(3)").click();
        //this.findByClassName("mt50 mb50").findListByTagName("button").get(2).click();
        //this.findByClassName("mt50 mb50").findListByClassName("formButtons acolor btns").get(1).click();
        return this;
    }

    public FindCandidatePage templateName() {
        String str= Public.generateString(4);
        this.findByCssSelector("#bg > div.modelName > div > div.modelInfo > div > input").sendKeys("java"+str+"设计师");
        return this;
    }

    public FindCandidatePage submitTemplate() {
        this.findByCssSelector("#bg > div.modelName > div > div.clearfix.footerBtn > button.saveBtn").click();
        //this.findByClassName("clearfix footerBtn").findByClassName("saveBtn").click();
        return this;
    }

    /*
    校验搜索模板
    * */
    public FindCandidatePage checkTemplate() {
        /*String str=this.findByCssSelector("#quickSearchBg > div > ul > li > p.underline.fl.singleLine").getText();
        Assert.assertEquals("ui设计师",str);*/
        /*int i=0;
        Element eles=this.findByCssSelector("#quickSearchBg > div > ul").findListByTagName("li").get(i);*/
        List<Element> eles = this.findByCssSelector("#quickSearchBg > div > ul").findListByTagName("li");
        boolean exist = false;
        for (int i = 0; i < eles.size(); i++) {
            String str = eles.get(i).findListByTagName("p").get(0).getText();
            if (str.contains("java")) {
                exist = true;
                break;
            }
        }
        Assert.assertEquals(true,exist);
        return this;
    }
}
