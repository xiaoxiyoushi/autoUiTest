package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import java.util.ArrayList;

//GC12编辑合同
public class GC12Page extends Public<GC12Page> {
    public Element element(int i){
        /*Element element=this.findByClassName("ivu-col-span-22").findByTagName("form")
                .findListByXPath("//child::div").get(i);*/
        Element element=this.findByClassName("ivu-col-span-22")
                .findListByClassName("ivu-row").get(i);
        return element;
    }

    public ArrayList store(){
        String contractNo=element(0).findListByClassName("ivu-form-item-content").get(0).getText();
        String clientName=element(0).findListByClassName("ivu-form-item-content").get(1).getText();
        ArrayList arrayList=new ArrayList();
        arrayList.add(contractNo);
        arrayList.add(clientName);
        return arrayList;
    }

    //输入甲、乙方
    public GC12Page inputParty(String PartyA,String PartyB){
        String PartyA1=PartyA+Public.generateString(6);
        String PartyB1=PartyB+Public.generateString(6);
        element(1).findListByTagName("input").get(0).sendKeys(PartyA1);
        element(1).findListByTagName("input").get(1).sendKeys(PartyB1);
        return this;
    }

    //选择开始时间
    public GC12Page selectStartTime() throws InterruptedException{
        element(2).findByTagName("input").click().sleepForSeconds(1);
        this.findByClassName("ivu-date-picker-cells-cell").click();
        return this;
    }

    //输入法人
    public GC12Page inputLegalPerson(String legalPerson) throws InterruptedException{
        String legalPerson1=legalPerson+Public.generateString(6);
        element(4).findByTagName("input").sendKeys(legalPerson1);
        return this;
    }

    //联系人
    public GC12Page ContactPerson(String Landline) throws InterruptedException{
        element(5).findByClassName("ivu-select-placeholder").click().sleepForSeconds(1);//点击联系人框
        element(5).findListByTagName("li").get(1).click();//选择联系人

        String Landline1=Landline+Public.generateString(6);
        //element(5).findByTagName("input").sendKeys(Landline1);//输入座机号
        sendInputPlaceholder("区号-座机号-分机",Landline1);
        return this;
    }

    //联系地址
    public GC12Page ContactAddress() throws InterruptedException{
        element(7).findByTagName("a").click().sleepForSeconds(1);//点击 修改工作地址
        this.findByClassName("ivu-radio-inner").click();//选择地址
        this.findByClassName("ivu-modal-close").click();//关闭地址弹窗
        return this;
    }

    //计费方式
    public GC12Page Charges() throws InterruptedException{
        String charges="1收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准";
        String annualSalaryDefinition="2年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义";
        String paymentMethods="3付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式";
        div_dataplaceholder_send("请输入收费标准不超过1024字",charges);//收费标准
        div_dataplaceholder_send("请输入年薪定义不超过1024字",annualSalaryDefinition);//年薪定义
        div_dataplaceholder_send("请输入付费方式不超过1024字",paymentMethods);//付费方式
        return this;
    }

    //上传合同附件
    public GC12Page uploadFile(){
        divClass_input_send("ivu-upload ivu-upload-select","C:\\Users\\86182\\Desktop\\文件格式\\风景1.JPG");
        divClass_input_send("ivu-upload ivu-upload-select","C:\\Users\\86182\\Desktop\\文件格式\\PDF文件.PDF");
        divClass_input_send("ivu-upload ivu-upload-select","C:\\Users\\86182\\Desktop\\文件格式\\小写pdf文件.pdf");
        return this;
    }

    public GC12Page submit() throws InterruptedException{
        this.findByClassName("listBtns").findListByTagName("button").get(1).click();//保存数据
        this.sleepForSeconds(1);
        this.findByClassName("listBtns").findListByTagName("button").get(2).click();//提交数据
        return this;
    }

}
