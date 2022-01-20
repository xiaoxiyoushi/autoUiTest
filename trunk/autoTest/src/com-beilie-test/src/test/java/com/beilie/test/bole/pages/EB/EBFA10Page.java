package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class EBFA10Page extends Public<EBFA10Page> {
    //点击性别，随机选择 男、女
    public EBFA10Page click_sex(int n){
        this.findById("vailsex")
                .findListByClassName("ivu-radio").get(n)
                .click();
        return this;
    }

    //点击地点的叉号
    public EBFA10Page peopleInfo_location_delete(){
        this.findById("vailPeopleInfo")
                .findById("selectFunSpan0")
                .findByClassName("mr5").click();
        return this;
    }

    //点击地点的叉号
    public EBFA10Page vaillocation_delete(){
        this.findById("vaillocation")
                .findById("selectFunSpan0")
                .findByClassName("mr5").click();
        return this;
    }

    //点击现居住地的icon
    public EBFA10Page peopleInfo_location_click(){
        this.findById("vaillocation")
                .findByClassName("searchFun_ebfa_select_input_div_img").click();
        return this;
    }

    //校对提示 更新简历成功，点击【确定】按钮 关掉页面
    public EBFA10Page checkTip(){
        String value=getSpanValue("更新数据成功。");
        Assert.assertEquals(value,"更新数据成功。");

        this.findByClassName("bigokbutton").click();//点击确定按钮
        return this;
    }

    //在点击组件的叉号
    public EBFA10Page component_delete(int n){
        this.findListByXPath("//span[text()=\"x\"]").get(n).click();
        return this;
    }

    //点击目前职能的icon
    public EBFA10Page workExperience_function_click(){
        this.findById("fbfa02_workfunction0father_div")
                .findByClassName("searchFun_ebfa_select_input_div_img").click();
        return this;
    }

    //点击目前职能的icon
    public EBFA10Page workExperience_Industry_click(){
        this.findById("fbfa02_workindustry0father_div")
                .findByClassName("searchFun_ebfa_select_input_div_img").click();
        return this;
    }

    //点击目前职能的icon
    public EBFA10Page workExperience_Location_click(){
        this.findById("fbfa02_worklocation0father_div")
                .findByClassName("searchFun_ebfa_select_input_div_img").click();
        return this;
    }

    //清除项目内容
    public EBFA10Page clearProject(){
        //this.findById("projectContent_div_input").clear();
        /*this.findById("projectContent_div_input").sendKeys(Keys.BACK_SPACE);
        this.findById("projectContent_div_input").sendKeys("a");
        this.findById("projectContent_div_input").sendKeys(Keys.BACK_SPACE);*/

        for (int i=0;i<12;i++){
            this.findById("projectContent_div_input").sendKeys(Keys.BACK_SPACE);
        }

        return this;
    }

    //输入项目内容
    public EBFA10Page sendProject(String project){
        this.findById("projectContent_div_input").sendKeys(project);
        return this;
    }

    //清除附加信息
    public EBFA10Page clearAddInform(){
        //this.findByXPath("//span[text()=\"附加信息\"]/parent::div/following-sibling::div/textarea").clear();
        for (int i=0;i<12;i++){
            this.findByXPath("//span[text()=\"附加信息\"]/parent::div/following-sibling::div/textarea").sendKeys(Keys.BACK_SPACE);
        }
        return this;
    }

    //输入附加信息
    public EBFA10Page sendAddInform(String addInform){
        this.findByXPath("//span[text()=\"附加信息\"]/parent::div/following-sibling::div/textarea").sendKeys(addInform);

        //this.findById("projectContent_div_input").sendKeys(project);
        return this;
    }

    //清除
    public EBFA10Page textarea_clear(){
        this.findByXPath("//div[@class=\"projectContent_div mt20 textarea_newClass ml30\"]/textarea").clear();

        return this;
    }

}
