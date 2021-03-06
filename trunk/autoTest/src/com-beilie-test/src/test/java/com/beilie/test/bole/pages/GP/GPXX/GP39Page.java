package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

//GP39财务收款
public class GP39Page extends Public<GP39Page> {

    public String tableValues(int i){
        String tableValues=this.findByClassName("ivu-table-tbody")
                .findListByTagName("td").get(i)
                .findByTagName("span").getText();
        return tableValues;
    }

    public String getCompanyName(){
        String companyName=this.findByClassName("ivu-table-tbody")
                .findByTagName("span").getText();
        return companyName;
    }

/*
未收款时，创建时间、候选人姓名、本次收款
 */
public Map<String,Object> getValue(){
    Map<String, Object> hash= new HashMap<String, Object>();
    String createTime=tableValues(1);
    String candidate=tableValues(2);
    String payMent=tableValues(3);;

    hash.put("1",createTime);
    hash.put("2",candidate);
    hash.put("3",payMent);

    return hash;
  }

  //点击 确认收款
    public GP39Page clickConfirmPay(){
        this.findByXPath("//span[text()=\"确认收款\"]").click();
    return this;
    }

    //输入公司名称
    public GP39Page inputCompanyName(String companyName){
        this.findByXPath("//input[@placeholder=\"请输入客户名称\"]").sendKeys(companyName);
        return this;
    }

    //点击收款状态框
    public GP39Page clickPaystatusInput(){
        this.findByXPath("//span[text()=\"未收款\"]").click();
        return this;
    }

    //选择已收款
    public GP39Page selectPayStatus(String payStatus){
        this.findByXPath("//li[text()=\""+payStatus+"\"]").click();
        return this;
    }

    //点击【搜索】按钮
    public GP39Page clickSearchButton(){
    String search="\n" +
            "              搜索\n" +
            "            ";
        this.findByXPath("//button[text()=\""+search+"\"]").click();
        return this;
    }

    public GP39Page checkValue(Map<String,Object> hash){
        Object createTime=hash.get("1");
        Object candidate=hash.get("2");
        Object payMent=hash.get("3");

        int numb=this.findByClassName("ivu-table-tbody")
                .findListByTagName("tr").size();

        for (int i=0;i<numb;i++){
            String tableValue1=this.findByClassName("ivu-table-tbody")
                    .findListByTagName("tr").get(i)
                    .findListByTagName("td").get(1)
                    .findByTagName("span").getText();

            if(createTime.equals(tableValue1)){
                String tableValue2=this.findByClassName("ivu-table-tbody")
                        .findListByTagName("tr").get(i)
                        .findListByTagName("td").get(2)
                        .findByTagName("span").getText();

                String tableValue3=this.findByClassName("ivu-table-tbody")
                        .findListByTagName("tr").get(i)
                        .findListByTagName("td").get(3)
                        .findByTagName("span").getText();

                Assert.assertEquals(candidate,tableValue2);
                Assert.assertEquals(payMent,tableValue3);
                break;
            }

        }

        return this;
    }

}
