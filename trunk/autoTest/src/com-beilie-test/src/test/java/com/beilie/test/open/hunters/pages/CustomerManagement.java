package com.beilie.test.open.hunters.pages;

import com.beilie.core.exceptions.BusinessException;
import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import com.beilie.test.seleniums.core.UIPage;
import org.junit.Assert;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CustomerManagement extends Public<CustomerManagement> {
    String randomStr=Public.generateString(6);
    /**
     * 判定当前页面是已经加载成功的；
     */
    public Boolean isLoad() {
        return Boolean.TRUE;
    }
    /**
     * 断言是否已经完成客户管理页面的加载；
     */
    public CustomerManagement assertLoaded() {
        if(Boolean.TRUE.equals(this.isLoad())){
            return this;
        }
        throw new BusinessException("页面加载失败。");
    }
    //点击 【+新增企业】
    public CustomerManagement clickIncrease(){
        this.findByCssSelector("#customerInfo > div:nth-child(2) > button").click();
        return this;
    }
    //新增企业信息 increaseEnterprise
    //输入 客户名称
    String clientName="上海扶苏实业"+randomStr+"有限公司";
    public CustomerManagement writeClientName(){
        //String clientName="上海扶苏实业"+randomStr+"有限公司";
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(1) > div:nth-child(1) > div > div > div > div > input").sendKeys(clientName);
        return this;
    }
    //输入 对外显示名称
    String ocn= Public.generateString(4);
    public CustomerManagement writeOutsideClientName(String outsideClientName1){
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(1) > div:nth-child(2) > div > div > div > div > input").sendKeys(outsideClientName1+ocn);
        return this;
    }
    //选择 所属行业
    public CustomerManagement clickIndustry(){
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(2) > div > div > div > div > div > div > input").click();
        return this;
    }
    public CustomerManagement clickInternet(){
        this.findByCssSelector("#plugin > div > div.allIndustry.clearfix.flex > div > ul > li:nth-child(2) > span").click();
        return this;
    }
    public CustomerManagement submitIndustry(){
        this.findByCssSelector("#plugin > div > div.industruWrapFooter > button.ef-btn.ef-confirm-btn").click();
        return this;
    }

    /*一级*/
    public Element selectElems(int i) {
        Element elements = this.findByClassName("dialog-box").findListByTagName("ul").get(i);
        return elements;
    }
    //点击所在地
    public CustomerManagement clickLocation(){
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(3) > div > div > div > div > div > div > input").click();
        return this;
    }
    public Element selectElems1(int i) {
        Element elements = this.findByClassName("tab-body functionName").findListByTagName("ul").get(i);
        return elements;
    }
    /*public CustomerManagement location1() {
        this.selectElems(0).findListByTagName("li").get(7).click();
        return this;
    }*/

    /*public CustomerManagement location2() {
        this.findById("stab.level").findListByTagName("li").get(28).click();
        return this;
    }*/

    /*public CustomerManagement submitlocation() {
        this.findByClassName("industruWrapFooter").findListByTagName("button").get(1).click();
        return this;
    }*/
    //企业性质
     public CustomerManagement clickNature(){
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(4) > div > div > div > div > div > div.ivu-select-selection > div > span").click();
        return this;
     }
    public CustomerManagement selectNature(){
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(4) > div > div > div > div > div > div.ivu-select-dropdown > ul.ivu-select-dropdown-list > li:nth-child(1)").click();
        return this;
    }
    //企业规模
    public CustomerManagement  clickScale(){
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(5) > div > div > div > div > div > div.ivu-select-selection > div > span").click();
        return this;
    }
    public CustomerManagement selectScale(){
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(5) > div > div > div > div > div > div.ivu-select-dropdown > ul.ivu-select-dropdown-list > li:nth-child(1)").click();
        return this;
    }
    //企业介绍
    public CustomerManagement writeIntroduce(){
        this.findByCssSelector("#addOrEditCompanyBg > div.ivu-modal-wrap > div > div > div.ivu-modal-body > form > div:nth-child(6) > div > div > div > div > textarea").sendKeys("我们始终为客户提供好的产品和技术支持、健全的售后服务，我公司主要经营劳务派遣，人力装卸服务，礼品包装服务，人才咨询，以服务外包方式从事企业管理服务，市容巡视服务，人才中介，职业中介，职业咨询，家政服务，保洁服务，企业管理咨询，物业管理，商务信息咨询，园林绿化工程（凭许可资质经营），苗木种植，一般劳防用品、家用电器批发、零售，仓储服务（除危险化学品），展览展示服务");
        return this;
    }
    //点击保存客户信息
    public CustomerManagement clickSave(){
        this.findByCssSelector("#footerBtn > button.saveBtn.ivu-btn.ivu-btn-default > span").click();
        return this;
    }
    public CustomerManagement checkCustomerName(){
        List<Element> elements=this.findById("mytableDiv").findByTagName("tbody")
                .findListByTagName("tr");
          String customerName=elements.get(0).findByTagName("span").getText();
        Assert.assertEquals(clientName,customerName);


        //System.out.println(uuid);
        return this;
    }


}
