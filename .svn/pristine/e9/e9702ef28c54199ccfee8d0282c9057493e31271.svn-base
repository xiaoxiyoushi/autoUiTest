package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class EBFA05Page extends Public<EBFA05Page> {

    /*
    点击头像
     */
    public EBFA05Page clickAvatar(int n){
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").click();
        return this;
    }

    /*
    hover头像
     */
    public EBFA05Page hoverAvatar(int n){
        this.findByClassName("pt72").findListByClassName("small_card").get(n)
                .findByClassName("cursorP").hover();
        return this;
    }

    /*
    点击收藏按钮
     */
    public EBFA05Page clickCollection(){
        this.findByClassName("pt72").findByClassName("small_card")
        .findByClassName("addToTalents").findByTagName("img").click();
        return this;
    }

    /*
    在“确认取消收藏?”弹框里，点击【确定】按钮
     */
    public EBFA05Page clickConfirmBtn(){
        this.findById("inquiryModal_modal").findByClassName("click_btn_bg")
                .click();
        return this;
    }

    /*
    人选搜索结果里 人选的个数,是0
     */
    public EBFA05Page checkCandidateNumb(){
        int candidateNumb=this.findByClassName("EBFA05_rightResult_content")
                .findListByClassName("small_card").size();

       String str=candidateNumb+"";
        Assert.assertEquals("0",str);

        return this;
    }

    //校对简历卡片的 姓名、电话、邮箱、性别、年龄、居住地
    public EBFA05Page checkResumeCard(String actualPhone){
        String phone=this.findById("big_card").findByClassName("ml20").findByTagName("strong").getText();//获取卡片上的手机号
        Assert.assertEquals(phone,actualPhone);

        return this;
    }

    /*
    在“添加备注”弹框里，点击【确定】按钮
     */
    public EBFA05Page clickConfirmBtn_addRemark(){
        this.findById("addRemark_modal")
                .findByClassName("click_btn_bg")
                .click();
        return this;
    }

    /*
   在“我的备注”弹框里，点击x按钮
    */
    public EBFA05Page remark_close(){
        this.findById("moreRemark_modal")
                .findByClassName("ivu-modal-close")
                .click();
        return this;
    }

    /*
        人选搜索结果里 人选的个数,是0
         */
    public EBFA05Page checkRemark(String remark,String remark_1){
        int candidateNumb=this.findByClassName("EBFA05_rightResult_content")
                .findListByClassName("small_card").size();

        String str=candidateNumb+"";
        Assert.assertEquals("0",str);

        return this;
    }

}
