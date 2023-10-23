package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.lang.model.util.Elements;
import java.util.ArrayList;
import java.util.List;

public class EBFA03Page extends Public<EBFA03Page> {

    //等待人选数据加载出来
    public EBFA03Page waitCandidateSearchResults(){
        this.waitFor(30,"//div[@class=\"EBFA03_rightResult_content\"]//div[@class=\"small_card mb20\"]");
        return this;
    }

    public EBFA03Page a() throws InterruptedException{
        String  companyName="";

        for (int i=0;i<6;i++){

            int n=this.findByClassName("pt72").findListByClassName("small_card").get(i)
                    .findListById("big_card").get(0)
                    .findListByClassName("ivu-row").size();
            /*int n=this.findByClassName("pt72")
                    .findListByClassName("small_card").get(i)
                    .findListById("big_card").get(0)
                    .findListByClassName("ivu-row").size();*/

            this.findByClassName("pt72").findListByClassName("small_card").get(i)
                    .findByClassName("cursorP").hover();

            if (n>0){
               String currentJob=this.findByClassName("pt72").findListByClassName("small_card").get(i)
                        .findListById("big_card").get(0)
                        .findListByClassName("ivu-row").get(0)
                        .findByClassName("nowWorks_title")
                        .getText();

                String education=this.findByClassName("pt72").findListByClassName("small_card").get(i)
                        .findListById("big_card").get(0)
                        .findListByClassName("ivu-row").get(1)
                        .findByClassName("nowWorks_title")
                        .getText();

                String value=this.findByClassName("pt72").findListByClassName("small_card").get(i)
                        .findListById("big_card").get(0)
                        .findListByClassName("ivu-row").get(2)
                        .findByClassName("nowWorks_title")
                        .getText();

                String value1=this.findByClassName("pt72").findListByClassName("small_card").get(i)
                        .findListById("big_card").get(0)
                        .findListByClassName("ivu-row").get(3)
                        .findByClassName("nowWorks_title")
                        .getText();

                String value2=this.findByClassName("pt72").findListByClassName("small_card").get(i)
                        .findListById("big_card").get(0)
                        .findListByClassName("ivu-row").get(4)
                        .findByClassName("nowWorks_title")
                        .getText();

                this.findByClassName("pt72").findListByClassName("small_card").get(i)
                        .findListById("big_card").get(0)
                ;


                      /*companyName=this.findByClassName("pt72").findListByClassName("small_card").get(i)
                              .findListById("big_card").get(0).findListByClassName("ivu-row").get(0)
                              .findByClassName("ivu-col-span-20") .findListByTagName("span").get(0).getText();*/

                /*this.findByClassName("pt72").findListByClassName("small_card").get(i)
                        .findByClassName("cursorP").click();*/

              break;
            }

        }

        return this;
    }

    //点击搜索
    public EBFA03Page clickSearch(){
        clickSpan("搜索");
        return this;
    }

    /*
       点击头像
        */
    public EBFA03Page clickAvatar(int n){
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").click();
        return this;
    }

    /*
    点击收藏按钮
     */
    public EBFA03Page clickCollection(){
        this.findByClassName("pt72").findByClassName("small_card")
                .findByClassName("addToTalents").findByTagName("img").click();
        return this;
    }

    /*
   在“确认取消收藏?”弹框里，点击【确定】按钮
    */
    public EBFA03Page clickConfirmBtn(){
        /*this.findById("inquiryModal_modal").findByClassName("click_btn_bg")
                .click();*/
        this.findByXPath("//div[@id=\"inquiryModal_modal\"]//button[@class=\"ivu-btn ivu-btn-primary\"]").click();
        return this;
    }

    //勾选 目前公司或者目前职位的勾选框
    public EBFA03Page checkCurrent(int i){
        this.findListByClassName("ivu-checkbox-input").get(i).click();
        return this;
    }

    //校对职位名称
    public EBFA03Page checkJob(String job){
        String job_1=this.findByClassName("curWorks").findListByClassName("maxWidth156").get(1).getText();
        Assert.assertEquals(job,job_1);
        return this;
    }

    /*
       获取第一个人选的
        */
    /*public EBFA03Page getFirstResume_Education(String str){
        String value=this.findByClassName("small_card")
                .findByXPath("//span[text()=\""+str+"\"]").getText();
        return this;
    }*/

    /*
       hover头像
        */
    public EBFA03Page hoverAvatar(int n){
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").hover();
        return this;
    }

    //校对人选卡片上的学历
    public EBFA03Page checkCandidateCard(){
        int numb=this.findByClassName("maxWidth100Pre").findListByTagName("span").size();
        String education=this.findByClassName("maxWidth100Pre").findListByTagName("span").get(numb-1).getText();
        Assert.assertEquals("大专",education);

        return this;
    }

    //添加标签，点击确定
    public EBFA03Page tagConfirm(){
        this.findById("efAddTags_footer")
        .findByClassName("ml20").click();
        return this;
    }

    public EBFA03Page clearButton_click(){
        this.findByXPath("//a[text()=\"" + "清空" + "\"]").click();//按钮是清空文案
        return this;
    }

    //按钮是清空文案+可点击
    public EBFA03Page clearButton(){
        Element element=this.findByXPath("//a[text()=\"" + "清空" + "\"]");//按钮是清空文案
        element.isEnabled();//可点击
        return this;
    }

    //标签
    public String labelButton() throws InterruptedException{
        clickSpan("标签");//点击标签icon
        this.sleepForSeconds(1);

        //获取第一个标签的值
        String label=this.findByXPath("//button[@class=\"" + "tagBtn_size singleLine font12 weight400 ml10 mb10 ivu-btn ivu-btn-default notAtiveTag" + "\"]//span").getText();
        //选中第一个标签
        button_classClick("tagBtn_size singleLine font12 weight400 ml10 mb10 ivu-btn ivu-btn-default notAtiveTag");
        button_classClick("ml20 ivu-btn ivu-btn-primary");//点击确定
        return label;
    }

    //验证标签搜索结果
    public EBFA03Page assertLabel(String label) throws InterruptedException{
        hoverAvatar(0);//hover头像
        this.sleepForSeconds(1);

        /*List<Element> elements=this.findListByClassName("ivu-col-span-20").get(3)
                .findListByTagName("span");*/

        List<Element> elements=this.findListByXPath("//span[@class=\"singleLine inblock talentTagsBtn font14 weight400 mr20 mb10\"]");

        int labelNumb=elements.size();

        for (int i=0;i<3;i++){
            String labelValue=elements.get(i).getText();
            if (labelValue.equals(label)){//校验卡片里的标签
                break;
            }
            if (i==labelNumb-1){
                Assert.assertFalse(true);
            }
        }
        return this;
    }

    //鼠标hover姓名，显示人选基本信息card
    public EBFA03Page hoverNameAndAssert() throws InterruptedException{
        //获取姓名
        String name=this.findByXPath("//div[@class=\"ml10 font14 weight400 flex singleLine\"]/div[1]/div[1]/div[1]").getText();

        //hover姓名
        this.findByXPath("//div[@class=\"ml10 font14 weight400 flex singleLine\"]/div[1]").hover();
        this.sleepForSeconds(1);

        //获取卡片的姓名
        String cardName=this.findListById("big_card").get(1)
                .findByTagName("span")
                .getText();
        Assert.assertEquals(name,cardName);
        return this;
    }

    //鼠标点击姓名
    public EBFA03Page clickName() throws InterruptedException{
        //点击姓名
        this.findByXPath("//div[@class=\"ml10 font14 weight400 flex singleLine\"]/div[1]").click();
        return this;
    }

    //添加标签
    public String addTag() throws InterruptedException{
        //点击添加标签
        this.findByXPath("//div[@class=\"body_down\"]//span").click();
        this.sleepForSeconds(1);

        String tagValue=this.findByXPath("//div[@id=\"efAddTags_content\"]//button[@class=\"tagBtn_size singleLine font12 weight400 ml10 mb10 ivu-btn ivu-btn-default notAtiveTag\"]").getText();
        this.findByXPath("//div[@id=\"efAddTags_content\"]//button[@class=\"tagBtn_size singleLine font12 weight400 ml10 mb10 ivu-btn ivu-btn-default notAtiveTag\"]").click();

        this.findByXPath("//div[@id=\"efAddTags_footer\"]//button[@class=\"ml20 ivu-btn ivu-btn-primary\"]").click();

        return tagValue;
    }

    //点击加入项目
    public EBFA03Page clickJoinProject() throws InterruptedException{
        this.findByXPath("//div[@class=\"body_down\"]//a[text()=\"加入项目\"]").click();
        /*this.waitFor(10, d -> {
            this.findByXPath("//div[@class=\"body_down\"]//a[text()=\"加入项目\"]").click();
            return Boolean.TRUE;
        });*/
        return this;
    }

    //获取加入项目框的客户名称、项目名称，搜索并且校对
    public EBFA03Page checkClientProject() throws InterruptedException{
        //获取第二行的客户名称、项目名称
        String client=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"][2]//span").getText();
        String project=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"][2]//div[@class=\"font14 pr20\"]//span").getText();

        //在输入框输入客户名称、项目名称
        this.findByXPath("//input[@placeholder=\"请输入客户名称\"]").sendKeys(client);
        this.findByXPath("//input[@placeholder=\"请输入项目名称\"]").sendKeys(project);

        //点击搜索
        this.findByXPath("//div[@class=\"ef-search-bar-btns\"]//span").click();
        this.sleepForSeconds(2);

        //校对
        String searchProject=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"]//div[@class=\"font14 pr20\"]//span").getText();
        Assert.assertEquals(project,searchProject);
        return this;
    }

    //在加入项目框，点击加入项目
    public EBFA03Page clickJoinProjectBtn() throws InterruptedException{
        //获取第二行的客户名称、项目名称
        String client=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"][2]//span").getText();
        String project=this.findByXPath("//div[@class=\"ivu-table-body ivu-table-overflowX\"]//tr[@class=\"ivu-table-row\"][2]//div[@class=\"font14 pr20\"]//span").getText();

        //在输入框输入客户名称、项目名称
        this.findByXPath("//input[@placeholder=\"请输入客户名称\"]").sendKeys(client);
        this.findByXPath("//input[@placeholder=\"请输入项目名称\"]").sendKeys(project);

        //点击搜索
        this.findByXPath("//div[@class=\"ef-search-bar-btns\"]//span").click();
        this.sleepForSeconds(2);

        //点击加入项目
        this.findByXPath("//div[@class=\"ivu-table ivu-table-default ivu-table-border ivu-table-stripe\"]//div[@class=\"ivu-table-fixed-right\"]//span[text()=\"加入项目\"]").click();
        return this;
    }

    //等待请选择人选简历页面数据加载
    public EBFA03Page waitResume() throws InterruptedException{


        return this;
    }

    //在请选择人选简历页面，点击确定
    public EBFA03Page clickConfirm() throws InterruptedException{
        try {
            //被淘汰，是否继续添加,点击确定
            this.findByXPath("//div[@class=\"ef-modal v-transfer-dom\"]//span[text()=\"确定\"]").click();
        }catch (Exception e){}
        this.sleepForSeconds(2);

        //等待确定按钮加载出来
        this.waitFor(30,"//div[@class=\"addProjectSelectResume v-transfer-dom\"][7]//span[text()=\"确定\"]");
        //在请选择人选简历页面，点击确定
        this.findByXPath("//div[@class=\"addProjectSelectResume v-transfer-dom\"][7]//span[text()=\"确定\"]").click();
        return this;
    }

    //在人选加入项目的时候，姓名、联系电话，校验必填项
    public EBFA03Page checkNamePhone() throws InterruptedException{
        //清除姓名
         for (int i = 0; i < 12; i++) {
            this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请填写姓名\"]").sendKeys(Keys.BACK_SPACE);
        }

        //清除联系电话
        for (int i = 0; i < 11; i++) {
            this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请输入联系电话\"]").sendKeys(Keys.BACK_SPACE);
        }

        //点击确定
        this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//span[text()=\"确定\"]").click();
        this.sleepForSeconds(2);

        //获取姓名、联系电话的必填提示
        String nameTip=this.findByXPath("//div[@class=\"ivu-form-item-error-tip\"]").getText();
        String phoneTip=this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请输入联系电话\"]/parent::div/following-sibling::div").getText();

        //校对
        Assert.assertEquals("姓名不能为空",nameTip);
        Assert.assertEquals("联系电话不能为空",phoneTip);
        return this;
    }

    //在人选加入项目的时候，更改联系电话、电子邮箱，加入成功，并且校验
    public EBFA03Page joinCandidateSucess() throws InterruptedException{
        //清除联系电话
        this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请输入联系电话\"]").clear();
        //输入新的手机号
        String phone ="3"+ Public.GenerateNumber(10);
        this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请输入联系电话\"]").sendKeys(phone);

        //清除电子邮箱
        this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请输入电子邮箱\"]").clear();
        //输入新的邮箱
        String mail ="lvxiao2023@163.com"+Public.generateString(8);
        this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//input[@placeholder=\"请输入电子邮箱\"]").sendKeys(mail);

        //点击确定
        this.findByXPath("//div[@class=\"confirm-info-modal v-transfer-dom\"]//span[text()=\"确定\"]").click();
        this.sleepForSeconds(4);

        //获取已加入文字
        String haveJoinedStr=this.findByXPath("//div[@class=\"ivu-table-fixed-right\"]//button[@class=\"ivu-btn ivu-btn-text ivu-btn-small\"]/span").getText();
        //核对已加入文字
        Assert.assertEquals("已加入",haveJoinedStr);
        return this;
    }

    /*
    校对人选数据
    */
    //核对地点
    public EBFA03Page checkLocation() throws InterruptedException{
        //获取工作地点
        String location=this.findByXPath("//div[@class=\"EBFA03_rightResult_content\"]//div[@class=\"small_card mb20\"]//span[@class=\"max-width-100 singleLine inblock\"]").getText();

        Assert.assertEquals("广东省-广州-白云区",location);
        return this;
    }
}

