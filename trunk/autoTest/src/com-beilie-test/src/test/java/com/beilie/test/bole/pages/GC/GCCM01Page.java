package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;

import java.util.List;

public class GCCM01Page extends Public<GCCM01Page> {
    /*
    新增客户
     */
    //输入公司名称
    public GCCM01Page inputClientName(String clientName){
        this.findById("your-input-id").findByTagName("input").sendKeys(clientName);
        return this;
    }

    //选择客户来源
    public GCCM01Page selectClient(){
        //点击 请选择框
        this.findById("Editor_bg").findByClassName("ivu-select-placeholder").click();
        //选择 客户来源
        this.findById("Editor_bg")
                .findByClassName("ivu-select-dropdown-list")
                   .findListByTagName("li").get(1).click();
        return this;
    }

    //选择所属行业
    public GCCM01Page selectIndustry(){
        //点击  请选择一个行业
        this.findById("Editor_bg")
                .findById("b-expect-industry")
                  .findByTagName("input").click();

        /*//选择：IT/互联网/游戏 > 全部
        this.findByClassName("nextUl").findByTagName("li").click();
        //点击 确定
        this.findByClassName("ef-confirm-btn").click();*/
        return this;
    }

    //选择城市
//    public GCCM01Page selectCity(){
////        //点击  请选择一个所在地
////        this.findById("b-expect-location")
////                .findByTagName("input").click();
////
////        //选择：北京 > 全部
////        this.findByClassName("tab-body").findByTagName("li").click();
////        this.findByClassName("tab-body").findByTagName("li").click();
////        //点击 确定
////        this.findByClassName("ef-confirm-btn").click();
////        return this;
////    }
    public GCCM01Page selectCity(){
        //点击  请选择一个所在地
        this.findById("b-expect-location")
               .findByTagName("input").click();

        return this;
    }

    //点击【新增客户】
    public GCCM01Page clickAddClient(){
        this.findByClassName("customerBtn").click();
        return this;
    }

    //校对提示
    public GCCM01Page checkTips(){
        String str=this.findByClassName("ef-model-confirm-b-span").getText();
        Assert.assertEquals(str,"创建客户成功，如需要锁定该客户，请尽快到我的客户中去完成锁定操作。");
        return this;
    }

    /*
    批量导入
     */
    //点击  批量导入:Batch Import
    public GCCM01Page clickBatchImport(){
        this.findByClassName("ivu-col-offset-20").findByTagName("a").click();
        return this;
    }

    //输入框
    public List<Element> elements(int i){
        List<Element> elements=this
                .findListByXPath("//*[@id=\"EFPage\"]/div[2]/div/div/div[3]/div[3]/div/child::div")
                .get(i)
                .findListByTagName("input");
        return elements;
    }
    //提示
    public Element element(int i){
        Element element=this
                .findListByXPath("//*[@id=\"EFPage\"]/div[2]/div/div/div[3]/div[3]/div/child::div")
                .get(i)
                .findByTagName("span");
        return element;
    }

    //添加 客户名称
    public GCCM01Page inputClient(String clientName,int i){
        elements(i).get(0).sendKeys(clientName);
        return this;
    }
    //添加 座机,座机:Landline
    public GCCM01Page inputLandline(String landline,int i){
        elements(i).get(1).sendKeys(landline);
        return this;
    }
    //添加 联系人姓名
    public GCCM01Page inputContactName(String contactName,int i){
        elements(i).get(2).sendKeys(contactName);
        return this;
    }
    //添加 手机
    public GCCM01Page inputPhone(String phone,int i){
        elements(i).get(3).sendKeys(phone);
        return this;
    }
    //添加 邮箱
    public GCCM01Page inputEmail(String email,int i){
        elements(i).get(4).sendKeys(email);
        return this;
    }
    //添加 相关链接
    public GCCM01Page inputLink(String link,int i){
        elements(i).get(5).sendKeys(link);
        return this;
    }
    //点击 【新增客户】
    public GCCM01Page clickAdd(){
        this.findByClassName("customerBtn").click();
        return this;
    }
    //校对提示
    public GCCM01Page checkTishi(){
        for (int n=0;n<10;n++){
            String tip1=element(n).getText();
            Assert.assertEquals("添加客户成功；",tip1);
        }
        return this;
    }

}
