package com.beilie.test.bole.pages.GP.GPXX;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.openqa.selenium.NoSuchElementException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

//GP00创建项目
public class GP00Page extends Public<GP00Page> {
    //输入项目名称
    public GP00Page inputProjName(String projName){
        this.findByXPath("//input[@placeholder=\"请输入项目名称\"]").sendKeys(projName);
        return this;
    }

    //输入招聘人数
    public GP00Page inputRecruitment(int num){
        String numStr=num+"";
        this.findByXPath("//input[@placeholder=\"请输入招聘人数\"]").sendKeys(numStr);
        return this;
    }

    //点击行业分类框
    public GP00Page clickIndustryIcon(){
        this.findByClassName("icon-industry").click();
        return this;
    }

    //点击职能分类框
    public GP00Page clickFunctIcon(){
        this.findByClassName("icon-function").click();
        return this;
    }

    /**
     * 获取元素 添加部门、添加联系人
     * @return Element
     */
    public List<Element> aIcomElements(){
        List<Element> icomElements=this.findListByXPath("//a[@icon=\"plus\"]");
        return icomElements;
    }

    /**
     * 获取元素 新增联系地址、新增语言、新增亮点
     * @return Element
     */
    public List<Element> spanIcomElements(){
        List<Element> icomElements=this.findListByXPath("//span[@icon=\"plus\"]");
        return icomElements;
    }

    //点击添加部门
    public GP00Page clickAddDepartment(){
        aIcomElements().get(0).click();

        //this.findByXPath("//span[text()=\"请选择所属部门\"]").click();
        return this;
    }

    //输入部门
    public GP00Page inputDepartment(){
        this.findByXPath("//input[@placeholder=\"请输入添加部门的名称\"]").sendKeys("dd");
        return this;
    }

    //点击添加按钮
    public GP00Page clickAddBtn(){
        this.findByXPath("//input[@placeholder=\"请输入添加部门的名称\"]/following-sibling::div")
                .click();
        return this;
    }

    public GP00Page clickX(String str){
        this.findByXPath("//div[text()=\""+str+"\"]/parent::div/preceding-sibling::a")
                .click();
        return this;
    }

    //点击新增联系地址
    public GP00Page clickAddress(){
        spanIcomElements().get(0).click();
        return this;
    }

//勾选地址复选框
    public GP00Page clickCheckbox(){
        divClass("address-checkboxs ivu-checkbox-group ivu-checkbox-default");
        return this;
    }

    public GP00Page submitAddress(){
        this.findByXPath("//div[@class=\"ivu-modal-wrap vertical-center-modal modelH100\"]//button[@class=\"ivu-btn ivu-btn-primary\"]")
                .click();
        return this;
    }

    public GP00Page salary(){
        this.findByXPath("//span[text()=\"年薪\"]/preceding-sibling::span").click();//选年薪
        this.findByXPath("//input[@placeholder=\"金额\"]").sendKeys("15");//输入年薪上限
        this.findListByXPath("//input[@placeholder=\"金额\"]").get(1).sendKeys("20");//输入年薪下限
        return this;
    }

    public GP00Page gender(){
        //"性别要求："
        this.findByXPath("//label[text()=\"男\"]/span").click();
        return this;
    }

    public GP00Page workYear(){
        this.findByXPath("//input[@placeholder=\"年\"]").sendKeys("3");
        this.findByXPath("//label[text()=\"工作年限：\"]/following-sibling::div//input[@placeholder=\"不限\"]")
                .sendKeys("5");
        return this;
    }

    public GP00Page age(){
        this.findByXPath("//input[@placeholder=\"岁\"]").sendKeys("20");
        this.findByXPath("//label[text()=\"年龄要求：\"]/following-sibling::div//input[@placeholder=\"不限\"]")
                .sendKeys("70");
        return this;
    }

    public GP00Page education() throws InterruptedException{
        this.findByClassName("edQu").findByXPath("//span[text()=\"请选择\"]").click();
        this.sleepForSeconds(1);
        this.findByXPath("//li[text()=\"不限\n" +
                "                    \"]").click();
        return this;
    }

    public GP00Page reportTo() throws InterruptedException{
        this.findByXPath("//input[@placeholder=\"请输入汇报对象\"]").sendKeys("coo");
        return this;
    }

    public GP00Page jobDescription() throws InterruptedException{
        this.findByXPath("//textarea[@placeholder=\"请输入职位描述\"]")
                .sendKeys("1职位描述职位描述职位描述职位描述职位描述职位描述职位描述" +
                          "职位描述职位描述职位描述职位描述职位描述职位描述职位描述职" +
                          "职位描述职位描述职位描述职位描述职位描述职位描述职位描述职" +
                          "职位描述职位描述职位描述职位描述职位描述职位描述职位描述职");
        return this;
    }

    /*public GP00Page submitProj(String save,String submit)throws InterruptedException{
        this.findByXPath("//span[text()=\""+save+"\"]").click();
        this.sleepForSeconds(1);
        this.findByXPath("//span[text()=\""+submit+"\"]").click();
        return this;
    }*/

    public GP00Page unconfirmedEmail(String str)throws InterruptedException{
        //Element element=this.findByXPath("//span[text()=\""+str+"\"]");
        //String value=this.findByClassName("ef-modal-ef-model-confirm-b-span").getText();

        /*if (element != null) {
            this.clickButton("确定");
        }*/

        try {
//            Element element=this.findByXPath("//span[text()=\""+str+"\"]");
            this.findByXPath("//div[text()=\"邮箱尚未确认，提交后请及时联系保护BD[jackZhang1]进行确认，以免影响推荐报告的发送\"]/parent::div/parent::div/following-sibling::div//span").click();
        } /*catch (NoSuchElementException e,No) {
            e.printStackTrace();
        }*/catch (Exception e) {
            e.printStackTrace();
        }


        return this;
    }


    public GP00Page saveAndSubmit() throws InterruptedException{
        this.findByXPath("//*[@id=\"EFPage\"]/div[2]/div[2]/button[1]/span").click();
        this.sleepForSeconds(1);
        this.findByXPath("//*[@id=\"EFPage\"]/div[2]/div[2]/button[2]/span").click();
        return this;
    }
}
