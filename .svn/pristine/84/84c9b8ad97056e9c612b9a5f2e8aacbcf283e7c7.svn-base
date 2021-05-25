package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class EBFA04Page extends Public<EBFA04Page> {

    public EBFA04Page a(){
        for (int i=0;i<6;i++){
            int n=this.findByClassName("pt72").findListByClassName("small_card").get(0)
                    .findListById("big_card").get(0)
                    .findListByClassName("color3").size();
        }

        return this;
    }


    /*
     点击头像
    */
    public EBFA04Page clickAvatar(int n){
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").click();
        return this;
    }

    /*
     悬浮头像
    */
    public EBFA04Page hoverAvatar(int n){
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").hover();
        return this;
    }

    /*
    获取 未确认 的个数
     */
    public int uncomfirm_numb(){

            int n=this.findListByXPath("//span[text()=\"未确认\"]").size();

        return n;
    }

    /*
    点击未确认入库的人选
     */
    public EBFA04Page uncomfirm_click(){

        //int o=this.findListByXPath("//span[text()=\"未确认\"]").size();
        /*int n=this.findByClassName("pt72").findListByClassName("small_card").get(1)
                .findByClassName("peopleInfos_infos")
                .findByClassName("weight400")
                .findListByClassName("ml10")
                .size();*/


        this.findByXPath("//span[text()=\"未确认\"]/parent::div/parent::div/parent::div/preceding-sibling::div").click()
        //this.findByXPath("//span[text()=\"未确认\"]/parent::div/following-sibling::div/img").click()
        ;


        return this;
    }

    //勾选 目前公司
    public EBFA04Page checkCurrentCompany(){
        this.findListByClassName("ivu-checkbox-input").get(2).click();
        return this;
    }

    //校对简历卡片的 姓名、电话、邮箱、性别、年龄、居住地
    public EBFA04Page checkResumeCard(List<String> list){
        String name=this.findById("big_card").findByTagName("span").getText();//获取卡片上的姓名
        String phone=this.findById("big_card").findByClassName("ml20").findByTagName("strong").getText();//获取卡片上的手机号
        String mailbox=this.findById("big_card").findListByClassName("ml20").get(1)
                            .findByTagName("span").getText();//获取卡片上的邮箱

        String sex=this.findByClassName("maxWidth100Pre").findListByTagName("span").get(0).getText();//获取性别
        String age=this.findByClassName("maxWidth100Pre").findListByTagName("span").get(2).getText();//获取年龄
        String location=this.findByClassName("maxWidth100Pre").findListByTagName("span").get(4).getText();//获取居住地

        List<String> list_actual=new ArrayList<String>();
        list_actual.add(name);
        list_actual.add(phone);
        list_actual.add(mailbox);
        list_actual.add(sex);
        list_actual.add(age);
        list_actual.add(location);

        for (int i=0;i<list.size();i++){
            Assert.assertEquals(list.get(i),list_actual.get(i));
        }
        return this;
    }

    //校对简历卡片的 目前公司、职位名称、职能、行业、目前薪资
    public EBFA04Page checkResumeCard_currentJob(List<String> list){
        String company=this.findById("big_card").findByClassName("ml6").findByTagName("span").getText();
        String industry=this.findById("big_card").findByClassName("ml6").findListByTagName("span").get(2).getText();
        String function=this.findById("big_card").findByClassName("ml6").findListByTagName("span").get(4).getText();
        String job=this.findById("big_card").findByClassName("ml6").findListByTagName("span").get(6).getText();
        //String salary=this.findById("big_card").findByClassName("ml6").findListByTagName("span").get(8).getText();

        List<String> list_actual=new ArrayList<String>();
        list_actual.add(company);
        list_actual.add(job);
        list_actual.add(function);
        list_actual.add(industry);

        for (int i=0;i<list_actual.size();i++){
            Assert.assertEquals(list.get(i),list_actual.get(i));
        }

        return this;
    }

    //校对简历卡片的 学校、专业
    public EBFA04Page checkResumeCard_colleage(List<String> list){
        String company=this.findById("big_card").findByClassName("mt20").findByTagName("span").getText();
        String industry=this.findById("big_card").findByClassName("mt20").findListByTagName("span").get(2).getText();

        List<String> list_actual=new ArrayList<String>();
        list_actual.add(company);
        list_actual.add(industry);

        for (int i=0;i<list_actual.size();i++){
            Assert.assertEquals(list.get(i),list_actual.get(i));
        }

        return this;
    }

    public EBFA04Page addProject_click(){
        /*this.findByClassName("ivu-table-tbody")
        .findByClassName("ivu-table-hidden").click()
        ;*/
                //.findListByTagName("td").get(4).click();
        this.findByXPath("//*[@id=\"selectTable_box\"]/div[2]/div[1]/div/div[4]/div[2]/table/tbody/tr[1]/td[1]/div/div/div").click();
        return this;
    }

    /*
    点击收藏按钮
     */
    public EBFA04Page clickCollection(){
        this.findByClassName("pt72").findByClassName("small_card")
                .findByClassName("addToTalents").findByTagName("img").click();
        return this;
    }

    //校对简历卡片的 姓名、电话、邮箱、性别、年龄、居住地
    public EBFA04Page checkResumeCard_name(){
        String name=this.findById("big_card").findByTagName("span").getText();//获取卡片上的姓名


        return this;
    }

    //校对简历卡片的 电话
    public EBFA04Page checkResumeCard(String actualPhone){
        String phone=this.findById("big_card").findByClassName("ml20").findByTagName("strong").getText();//获取卡片上的手机号
        Assert.assertEquals(phone,actualPhone);

        return this;
    }

    //校对弹窗：该人选当前正在本职位操作中，无法重复添加。
    public EBFA04Page checkTip_againAdd(){
        String value=spanClass("ef-modal-ef-model-confirm-b-span");
        Assert.assertEquals(value,"该人选当前正在本职位操作中，无法重复添加。");

        return this;
    }



}
