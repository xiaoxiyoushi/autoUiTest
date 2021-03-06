package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class EBFA02Page extends EBFAPage<EBFA02Page> {
    //点击性别，随机选择 男、女
    public EBFA02Page click_sex(int n){
        this.findById("vailsex")
                .findListByClassName("ivu-radio").get(n)
                .click();
        return this;
    }
    //点击地点的叉号
    public EBFA02Page location_delete(){
        this.findById("selectFunSpan0")
                .findByClassName("mr5").click();
        return this;
    }

    //校对提示 简历入库成功，点击【确定】按钮 关掉页面
    public EBFA02Page checkTip(){
        String value=getSpanValue("添加到收藏夹成功");
        Assert.assertEquals(value,"添加到收藏夹成功");

        this.findById("EFmodal")
                .findByTagName("button").click();//点击确定按钮
        //this.findByClassName("bigokbutton").click();//点击确定按钮
        return this;
    }

    //校对提示 添加人选到项目成功；
    public EBFA02Page checkTip_addProject(String name){
        String value=getSpanValue("添加人选["+name+"]到项目成功。");

        this.findById("EFmodal")
                .findByTagName("button").click();//点击确定按钮
        return this;
    }

    //在点击组件的叉号
    public EBFA02Page component_delete(int n){
        this.findListByXPath("//span[text()=\"x\"]").get(n).click();
        return this;
    }

    //清除项目内容
    public EBFA02Page clearProject(){
        for (int i=0;i<12;i++){
            this.findById("projectContent_div_input").sendKeys(Keys.BACK_SPACE);
        }

        return this;
    }

    //输入项目内容
    public EBFA02Page sendProject(String project){
        this.findById("projectContent_div_input").sendKeys(project);
        return this;
    }

    //点击第三份工作经历的删除按钮
    public EBFA02Page deleteBtn(){
        this.findByXPath("//*[@id=\"ebfa02_bg\"]/div[1]/div/form/div[4]/div[4]/div[4]/div/div/button[1]").click();
        return this;
    }

    //清除附加信息
    public EBFA02Page clearAddInform(){
        for (int i=0;i<12;i++){
            this.findByXPath("//span[text()=\"附加信息\"]/parent::div/following-sibling::div/textarea").sendKeys(Keys.BACK_SPACE);
        }
        return this;
    }

    //输入附加信息
    public EBFA02Page sendAddInform(String addInform){
        this.findByXPath("//span[text()=\"附加信息\"]/parent::div/following-sibling::div/textarea").sendKeys(addInform);

        return this;
    }

    //点击提示的【确定】按钮
    public EBFA02Page clickConfirmBtn(){
        this.findByClassName("bigokbutton").click();
        return this;
    }

    //核对右侧简历原件
    public EBFA02Page checkRightResume(){
        String resumeText=this.findByClassName("right-origin-html").getText();
        resumeText.startsWith("张德年( ID：1555825154）");

        return this;
    }

}
