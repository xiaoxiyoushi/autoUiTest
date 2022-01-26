package com.beilie.test.bole.pages.GP;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;

//GPRP01发布到贝猎网
public class GPRP01Page extends Public<GPRP01Page> {
    /*
    核对页面文字：发布到贝猎网、企业基本信息、职位基本信息；
     */
    public GPRP01Page checkInfor(){
        //String str1=this.findByXPath("//span[text()=\"发布到贝猎网\"]").getText();
        String str2=this.findByXPath("//span[text()=\"企业基本信息\"]").getText();
        String str3=this.findByXPath("//h2[text()=\"职位基本信息\"]").getText();

        //Assert.assertEquals(str1,"发布到贝猎网");
        Assert.assertEquals(str2,"企业基本信息");
        Assert.assertEquals(str3,"职位基本信息");
      return this;
    }

    public GPRP01Page clickCompanyInp(){
        this.findByXPath("//input[@placeholder=\"请输入公司名称\"]").click();//点击公司名称框
        this.findByTagName("li").click();//点击公司名称
        return this;
    }

    public GPRP01Page clickDepartment(String department) throws InterruptedException{
        Element element =this.findByXPath("//span[text()=\"选择部门名称\"]");
        element.click();//点击部门名称框
        String str=this.findByClassName("ivu-select-visible").findByTagName("li").getText();//获取下拉的部门
        if(str.equals("无匹配数据")){
            element.click();
            this.sleepForSeconds(1);
            this.findByXPath("//a[text()=\" 添加部门\n" +
                    "              \"]").click();//点击+
            this.findByXPath("//input[@placeholder=\"请输入部门名称\"]").sendKeys(department);//输入部门名称
            this.findByClassName("addDepartBtn").findListByTagName("img").get(1).click();

        }else {
            this.findByClassName("ivu-select-visible")
                    .findByClassName("ivu-select-dropdown-list").findByTagName("li").click();//选择已有的一个部门
        }
        return this;
    }

    public GPRP01Page submit() throws InterruptedException{
        this.findByXPath("//span[text()=\"提交\"]").click();
        return this;
    }

}
