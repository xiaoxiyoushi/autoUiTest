package com.beilie.test.open.applicants.pages;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

public class FindPositionPage extends Public<FindPositionPage> {
    //点击搜索
    public FindPositionPage clickSearch(){
        this.findByCssSelector("#bg > div.searchHeaderWrap > div > div > div:nth-child(5) > button").click();
        return this;
    }
    //输入关键词
    public FindPositionPage writeKeyWords(String keyWords){
        this.findByCssSelector("#onlySearch > input").sendKeys(keyWords);
        return this;
    }
    public FindPositionPage writeKeyWords() throws InterruptedException{
        String str= Public.generateString(6);
        this.findByCssSelector("#onlySearch > input").sendKeys(str);

        this.findByCssSelector("#bg > div.searchHeaderWrap > div > div > div:nth-child(5) > button").click();
        this.sleepForSeconds(1);

        //点击搜索框
        this.findByCssSelector("#onlySearch > input").click();
        this.sleepForSeconds(1);

        List<Element> elements=this
                .findListByClassName("listItem");

        String str1=elements.get(2).getText();
        Assert.assertEquals(str,str1);

        return this;
    }

    //删除已选条件
    public FindPositionPage deleteTiaojian(){
        Element element=this.findByCssSelector("div.fl.ivu-col.ivu-col-span-14 > span");
        element.hover();
        element.findByTagName("i").click();
        element.findByTagName("i").click();
        return this;
    }
    //点击职位名称
    /*public FindPositionPage clickPosition() throws Throwable{
        this.findByCssSelector("#bg > div.positionList.clearfix > div.listLeft.fl.w862 > div:nth-child(1) > div > div > div:nth-child(2) > div.positionName.mw70 > a").click();
        return this;
    }*/
    public FindPositionPage clickPosition() throws Throwable{
        this.findByCssSelector("#bg > div.positionList.clearfix > div.listLeft.fl.w862 > div:nth-child(1) > div > div > div:nth-child(2) > div.positionName.mw70 > a").click();
        return this;
    }

    //校验搜索出的职位
    public FindPositionPage checkPosition(String position){
        List<Element> elements = this.findByCssSelector("#bg > div.positionList.clearfix > div.listLeft.fl.w862")
                                     .findListByClassName("positionBg");
        if (CollectionUtils.isEmpty(elements)){
            //说明没有搜索到职位，直接跳过
            return this;
        }

        for(int i=0;i<elements.size();i++){
            String str=elements.get(i).findByTagName("a").getText();
            if(position.equalsIgnoreCase(str)){
                continue;
            }
            else {
                Assert.assertTrue(false);
            }
        }

        return this;
    }

    //学历要求
    public FindPositionPage searchDegrees() throws InterruptedException{

        List<Element> elements=this.findByClassName("positionSearchCondition").findListByClassName("mb15");

          int n=elements.get(1).findListByClassName("degrees").size();

          this.findByClassName("changeInfo").hover();
          this.findByClassName("ivu-icon-ios-close-empty").click();

            for (int i=1;i<n;i++){

                this.findByClassName("changeInfo").hover();
                this.findByClassName("ivu-icon-ios-close-empty").click();
                this.sleepForSeconds(1);

                elements.get(1).findListByClassName("degrees").get(i).click();
                String degree=elements.get(1).findListByClassName("degrees").get(i).getText();

                String str=this.findByClassName("ivu-col-span-14").findByTagName("span").getText();
                Assert.assertEquals(degree,str);
                this.sleepForSeconds(1);

                Element element1 = this.findByClassName("positionList");

                if (CollectionUtils.isEmpty(element1.findListByClassName("positionBg"))){
                    //说明没有搜索到职位，直接跳过
                    continue;
                }else {
                    String str1=element1.findListByClassName("positionBg")
                                        .get(0).findByClassName("degreeDiv")
                                        .findByTagName("span").getText();
                    //搜索条件学历，与职位中的学历是否一致
                    Assert.assertTrue(degree.equals(str1));
                }

            }

        return this;
    }

    //工作年限
    public FindPositionPage searchCondition(int a) throws InterruptedException{
        List<Element> elements=this.findByClassName("positionSearchCondition").findListByClassName("mb15");

        List<Element> elements1=elements.get(a).findListByClassName("degrees");

        int n=elements1.size();

        for (int i=1;i<n;i++){
            this.findByClassName("changeInfo").hover();
            this.findByClassName("ivu-icon-ios-close-empty").click();

            String degree=elements1.get(i).getText();
            elements1.get(i).click();

            String str=this.findByClassName("ivu-col-span-14").findByTagName("span").getText();

            Assert.assertEquals(degree,str);
        }

        return this;
    }

    //点击搜索框
    public FindPositionPage clickSearchInput() throws InterruptedException{
        this.findByCssSelector("#onlySearch > input").click();
        this.sleepForSeconds(1);

        List<Element> elements=this.findListByClassName("listItem");

         String currentPosition=elements.get(0).getText();
         elements.get(0).click();

         //校验搜索的职位
        List<Element> elements1 = this.findByCssSelector("#bg > div.positionList.clearfix > div.listLeft.fl.w862").findListByClassName("positionBg");
        if (CollectionUtils.isEmpty(elements1)){
            //说明没有搜索到职位，直接跳过
            return this;
        }

        for(int i=0;i<elements1.size();i++){
            String str=elements1.get(i).findByTagName("a").getText();
            if(currentPosition.equalsIgnoreCase(str)){
                continue;
            }
            else {
                Assert.assertTrue(false);
            }
        }

        return this;
    }

    //校验历史搜索记录
    public FindPositionPage checkHistoryRecord() throws InterruptedException{
        this.findByCssSelector("#onlySearch > input").click();
        this.sleepForSeconds(1);

        List<Element> elements=this
                .findListByClassName("listItem");

        String str=elements.get(2).getText();
        return this;
    }

    //点击期望行业，选择行业，校验行业
    public FindPositionPage clickExpectIndustry() throws InterruptedException{

        Element element=this.findByCssSelector("div.fl.ivu-col.ivu-col-span-14 > span");
        element.hover();
        element.findByTagName("i").click();

        List<Element> elements=this.findListByClassName("positionSelectItem");

        elements.get(0).click();

        this.sleepForSeconds(1);

        //选择行业
        this.findByCssSelector("#plugin > div > div.allIndustry.clearfix.flex > div > ul > li:nth-child(2) > span").click();
        this.findByCssSelector("#plugin > div > div.industruWrapFooter > button.ef-btn.ef-confirm-btn").click();

        this.sleepForSeconds(1);

        //校验行业
        List<Element> elements1 = this.findByCssSelector("#bg > div.positionList.clearfix > div.listLeft.fl.w862").findListByClassName("positionBg");
        if (CollectionUtils.isEmpty(elements)){
            //说明没有搜索到职位，直接跳过
            return this;
        }

        for(int i=0;i<elements1.size();i++){
            String str=elements1.get(i).findByClassName("workPlaceDivSpan1").getText();
            if("互联网/移动互联网".equalsIgnoreCase(str)){
                continue;
            }
            else {
                Assert.assertTrue(false);
            }
        }


        return this;
    }

    public Element selectElems(int i) {
        Element elements = this.findByClassName("dialog-box").findListByTagName("ul").get(i);
        return elements;
    }

    //点击期望职能，选择职能，点击职位名称
    public FindPositionPage clickExpectFunction() throws InterruptedException{
        //组件框
        List<Element> elements=this.findListByClassName("positionSelectItem");
        //搜索出的职位信息
        List<Element> elements1 = this.findByCssSelector("#bg > div.positionList.clearfix > div.listLeft.fl.w862").findListByClassName("positionBg");

        /*Element element=this.findByCssSelector("#bg > div.positionList.clearfix > div.listLeft.fl.w862");
        if (StringUtils.isEmpty(element)){

        }*/

        elements.get(1).click();

        this.sleepForSeconds(1);

        //选择职能
        this.selectElems(1).findListByTagName("li").get(0).click();
        this.findByClassName("dialog-box").findByTagName("ul").findListByTagName("li").get(1).click();
        this.findByClassName("dialog-box").findByTagName("ul").findListByTagName("li").get(2).click();
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();

        this.sleepForSeconds(1);

        elements1.get(0).findByTagName("a").click();

        return this;
    }


}
