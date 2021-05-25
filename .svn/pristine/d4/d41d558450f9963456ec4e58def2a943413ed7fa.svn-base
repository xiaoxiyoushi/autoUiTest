package com.beilie.test.open.WwwHome.pages;

import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class MediaCooperationPage extends UIPage<MediaCooperationPage> {
    public Element eles(int i){
        Element element=this.findByCssSelector("#newModel > div.newModel > form ")
                .findListByClassName("ivu-form-item").get(i);
        return element;
    }

    public MediaCooperationPage writeName(String name){
        eles(0).findByTagName("input").sendKeys(name);
        return this;
    }
    public MediaCooperationPage writeMobile(String mobile){
        eles(1).findByTagName("input").sendKeys(mobile);
        return this;
    }
    public MediaCooperationPage writeEmile(String emile){
        eles(2).findByTagName("input").sendKeys(emile);
        return this;
    }
    public MediaCooperationPage writeCompanyName(String companyName){
        eles(3).findByTagName("input").sendKeys(companyName);
        return this;
    }
    public MediaCooperationPage writePosition(String position){
        eles(4).findByTagName("input").sendKeys(position);
        return this;
    }
    public MediaCooperationPage clickQueRen(){
        this.findByCssSelector("#newModel > div.newModel > footer > input").click();
        return this;
    }
    public MediaCooperationPage checkTiShi(){
        String str=this.findByCssSelector("#showPositionbtn > div.succModal > p").getText();
        Assert.assertEquals("创建媒体合作成功。",str);
        return this;
    }

    /*
    反向验证，输入框下的提示语
     */
    //您的姓名
    public MediaCooperationPage ReverseCheck(){
        ArrayList<String> arrayList=new ArrayList<String>();
        ArrayList<String> arrayList1=new ArrayList<String>();

        arrayList1.add("请输入正确的姓名");
        arrayList1.add("请输入正确的手机号码");
        arrayList1.add("请输入正确的邮箱");
        arrayList1.add("请输入正确的公司名称");
        arrayList1.add("请输入正确的职位");

         List<Element> elements=this.findByCssSelector("#newModel > div.newModel > form").findListByClassName("ivu-form-item");

        for (int i=0;i<5;i++){
            String str1=elements.get(i).findByClassName("ivu-form-item-error-tip").getText();
            arrayList.add(str1);
        }

         for(int i=0;i<5;i++){
             String str2=arrayList.get(i);
             String str3=arrayList1.get(i);

                boolean b=str2.equals(str3);
                Assert.assertTrue(b);
         }

        return this;
    }
    //手机号码
    public MediaCooperationPage ReverseCheck1(){
        String str=this.findByCssSelector("#newModel > div.newModel > form > div:nth-child(2) > div > div.ivu-form-item-error-tip").getText();
        Assert.assertEquals("请输入正确的手机号码",str);
        return this;
    }
    //您的邮箱
    public MediaCooperationPage ReverseCheck2(){
        String str=this.findByCssSelector("#newModel > div.newModel > form > div:nth-child(3) > div > div.ivu-form-item-error-tip").getText();
        Assert.assertEquals("请输入正确的邮箱",str);
        return this;
    }
    //公司名称
    public MediaCooperationPage ReverseCheck3(){
        String str=this.findByCssSelector("#newModel > div.newModel > form > div:nth-child(4) > div > div.ivu-form-item-error-tip").getText();
        Assert.assertEquals("请输入正确的邮箱",str);
        return this;
    }
}



