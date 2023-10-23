package com.beilie.test.bole.pages.GC;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;

import java.util.ArrayList;

//GC12编辑合同
public class GC12Page extends Public<GC12Page> {
    public Element element(int i) {
        Element element = this.findByClassName("ivu-col-span-22")
                .findListByClassName("ivu-row").get(i);
        return element;
    }

    public ArrayList store() {
        String contractNo = element(0).findListByClassName("ivu-form-item-content").get(0).getText();
        String clientName = element(0).findListByClassName("ivu-form-item-content").get(1).getText();
        ArrayList arrayList = new ArrayList();
        arrayList.add(contractNo);
        arrayList.add(clientName);
        return arrayList;
    }

    //获取合同编号
    public String contarctNumb() throws InterruptedException {
        return label_parentDiv_div("合同编号：");
    }

    //获取客户名称
    public String clientName() throws InterruptedException {
        return label_parentDiv_div("客户名称：");
    }


    //输入甲、乙方
    public GC12Page party_send() {
        sendInputPlaceholder("请输入甲方公司名称","上海甲方公司");
        sendInputPlaceholder("请输入乙方公司名称","上海乙方公司");
        /*inputPlaceholder_send("jiaFang_placeholder", "上海甲方公司");
        inputPlaceholder_send("yiFang_placeholder", "上海乙方公司");*/
        return this;
    }

    //选择开始时间
    public GC12Page selectStartTime() throws InterruptedException {
        iClass_click("gcl2_startTime_class").sleepForSeconds(1);
        this.findByClassName("ivu-date-picker-cells-cell").click();
        return this;
    }

    //输入法人
    public GC12Page inputLegalPerson(String legalPerson) throws InterruptedException {
        String legalPerson1 = legalPerson + Public.generateString(6);
        element(4).findByTagName("input").sendKeys(legalPerson1);
        return this;
    }

    //联系人
    public GC12Page ContactPerson(String Landline) throws InterruptedException {
        spanClick("gcl2_contact").sleepForSeconds(1);//点击联系人框
        this.findByXPath("//div[@class=\"w340 ivu-select ivu-select-visible ivu-select-single ivu-select-default\"]//li[@class=\"ivu-select-item\"]").click();//选择联系人
        String Landline1 = Landline + Public.generateString(6);
        sendInputPlaceholder("区号-座机号-分机", Landline1);
        return this;
    }

    //联系地址
    public GC12Page ContactAddress() throws InterruptedException {
        spanClick("gcl2_adress").sleepForSeconds(1);//点击 添加地址
        this.findByClassName("ivu-radio-wrapper").click();//选择地址
        divText_parentDiv_precedingA_click("gcl2_a");//关闭地址弹窗
        return this;
    }

    //计费方式
    public GC12Page Charges() throws InterruptedException {
        String charges = "1收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准收费标准";
        String annualSalaryDefinition = "2年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义年薪定义";
        String paymentMethods = "3付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式付费方式";
        div_dataplaceholder_send("请输入收费标准不超过1024字", charges);//收费标准
        div_dataplaceholder_send("请输入年薪定义不超过1024字", annualSalaryDefinition);//年薪定义
        div_dataplaceholder_send("请输入付费方式不超过1024字", paymentMethods);//付费方式
        return this;
    }

    //上传合同附件
    public GC12Page uploadFile() {
        divClass_input_send("ivu-upload ivu-upload-select", "C:\\Users\\86182\\Desktop\\文件格式\\风景1.JPG");
        //divClass_input_send("ivu-upload ivu-upload-select", "C:\\Users\\86182\\Desktop\\文件格式\\PDF文件.PDF");
        //divClass_input_send("ivu-upload ivu-upload-select", "C:\\Users\\86182\\Desktop\\文件格式\\小写pdf文件.pdf");
        return this;
    }

    public GC12Page submit() throws InterruptedException {
        div_class_spans("gcl2_footer_class",1);//保存数据
        this.sleepForSeconds(1);
        div_class_spans("gcl2_footer_class",2);//提交数据
        return this;
    }

}
