package com.beilie.test.bole.pages.GP.GPPM;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

//GPPM10我的项目
public class GPPM10Page extends Public<GPPM10Page> {

    //点击客户名称下拉框，选择项目名称
    public GPPM10Page selectName(int i){
        this.findByClassName("ivu-select-selection").click();
        //this.findByXPath("//li[\""+name+"\"]").click();
        this.findListByClassName("ivu-select-item").get(i).click();
        return this;
    }

    //输入项目名称
    public GPPM10Page inputClientName(String name,String projectName){
        this.findByXPath("//input[@placeholder=\""+name+"\"]").sendKeys(projectName);
        return this;
    }

    public GPPM10Page clickSearch(){
        this.findByXPath("//span[text()=\"搜索\"]").click();
        return this;
    }

    public GPPM10Page clicksearch(){
        //this.findByXPath("//div[@class=\"ef-search-bar-btns\"]//span[tesxt()=\"搜索\"]").click();
        this.findByClassName("ef-search-bar-btns").findByClassName("ivu-btn-primary").click();
        return this;
    }

    public String getProjectName(){
        String projectName=this.findByClassName("ivu-table-tbody").findByTagName("a").getText();
        return projectName;
    }

    public GPPM10Page checkProjectProcess(String projectName,String projectProcess){
        String actualProjectName = this.table_td_aValue(0, 0);
        String actualProjectProcess = this.table_td_spanValue(0, 8);
        Assert.assertEquals(projectName,actualProjectName);
        Assert.assertEquals(projectProcess,actualProjectProcess);
        return this;
    }
}
