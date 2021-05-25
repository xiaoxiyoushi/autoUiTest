package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class EBFA03Page extends Public<EBFA03Page> {

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
        this.findById("inquiryModal_modal").findByClassName("click_btn_bg")
                .click();
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

}
