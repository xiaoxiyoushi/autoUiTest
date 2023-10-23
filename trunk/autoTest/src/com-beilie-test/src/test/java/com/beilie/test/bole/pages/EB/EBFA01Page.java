package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

public class EBFA01Page extends EBFAPage<EBFA01Page> {

    /*
    判断当前是粘贴还是上传方式
     */
    public EBFA01Page judgeWay() throws InterruptedException{
        String uploadWay=this.findByClassName("components-container-title")
                .findByTagName("a").getText();
        if (uploadWay.equals("上传文件")){
            this.findByClassName("components-container-title")
                    .findByTagName("a").click();
            this.sleepForSeconds(1);
        }
        return this;
    }

     /*
    校验右侧显示原始简历
     */
    public EBFA01Page checkRightResume(String value_1,String value_2,String value_3,String value_4){
        String getValue_1=getSpanValue(value_1);
        String getValue_2=getSpanValue(value_2);
        String getValue_3=getSpanValue(value_3);
        String getValue_4=getSpanValue(value_4);

        Assert.assertEquals(value_1,getValue_1);
        Assert.assertEquals(value_2,getValue_2);
        Assert.assertEquals(value_3,getValue_3);
        Assert.assertEquals(value_4,getValue_4);
        return this;
    }

/*
获取.txt格式的原始简历
 */
    public EBFA01Page getTxt(String value){
        String txt=this.findByClassName("note-editable").getText();
        txt.startsWith(value);
        return this;
    }

    /*
    获取input框里的数据
     */
    public EBFA01Page inputValue(){
        /*String txt=this.findByClassName("note-editable").getText();
        txt.startsWith(value);*/

       // String txt=this.findByXPath("//input[@placeholder=\"请输入姓名\"]");


        return this;
    }

    public EBFA01Page wa(){
        /*Element element=this.findByXPath("//div[text()=\"姓名不能为空\"]");
        ExpectedCondition<Boolean> e = ExpectedConditions.textToBePresentInElement((WebElement)element,"姓名不能为空");
        this.waitFor(60, e);*/
        //this.waitFor(60, ExpectedConditions.textToBePresentInElement((WebElement)this.findByXPath("//div[text()=\"姓名不能为空\"]"),"姓名不能为空"));
        String str=this.findByXPath("//div[text()=\"姓名不能为空\"]").getText();
        Assert.assertEquals("企业信用信息",str);
        /*this.waitFor(5, d -> {
            String str=this.findByXPath("//div[text()=\"姓名不能为空\"]").getText();
            Assert.assertEquals("企业信用信息",str);
            return Boolean.TRUE;
        });*/
        return this;
    }

    //校对提示 上传简历成功
    public EBFA01Page checkTip(){
        //String value=getSpanValue("上传简历成功");
        String value=divClass_value("ef-modal-message");

       Assert.assertEquals(value,"上传简历成功");


        return this;
    }

    //校对提示 加入项目成功
    public EBFA01Page checkTip_addProject(String name){
        String tips=this.findByClassName("ef-modal-message").getText();
        String name_1="添加人选["+name+"]到项目成功。";
        Assert.assertEquals(tips,name_1);
        return this;
    }

    //点击提示的【确定】按钮
    public EBFA01Page clickConfirmBtn(){
        //this.findByClassName("bigokbutton").click();
        this.findByXPath("//div[@class=\"ef-modal v-transfer-dom\"]//button").click();
        return this;
    }

    //点击地点的叉号
    public EBFA01Page peopleInfo_location_delete(){
        this.findById("vailPeopleInfo")
               // .findById("selectFunSpan0")
                .findByClassName("ivu-icon-md-close").click();
        return this;
    }

    //点击现居住地的icon
    public EBFA01Page peopleInfo_location_click(){
        this.findById("vailPeopleInfo")
                .findByClassName("icon-region").click();
        return this;
    }

    //点击目前职能的icon
    public EBFA01Page workExperience_function_click(){
        this.findById("vailworkExperience")
                .findByClassName("icon-function").click();
        return this;
    }

    //点击所在行业的icon
    public EBFA01Page workExperience_industry_click(){
        this.findById("vailworkExperience")
                .findByClassName("icon-industry").click();
        return this;
    }

    //×掉已选的任职时间
    public EBFA01Page workExperience_time_delete(){
        this.findById("vailworkExperience")
                .findByClassName("ivu-icon-ios-calendar-outline").click();
        return this;
    }

    //点击至今的勾选框
    public EBFA01Page workExperience_currentTime_click(){
        this.findById("vailworkExperience")
                .findByClassName("ivu-checkbox").click();
        return this;
    }

    //×掉已选的开始就读时间
    public EBFA01Page educations_time_delete(int n){
        this.findById("vaileducations")
                .findListByClassName("ivu-icon-ios-calendar-outline").get(n).click();
        return this;
    }

    //×掉已选的结束就读时间
    public EBFA01Page educations_endTime_delete(){
        this.findByCssSelector("#vaileducationitem_school0 > div:nth-child(2) > div > div > div:nth-child(3) > div.ivu-date-picker-rel > div > i")
                .click();
        return this;
    }

    //工作经历，月份日历
    public EBFA01Page calendar_months(String str){
        this.findByXPath("//input[@placeholder=\""+str+"\"]").click();
        this.findByClassName("ivu-date-picker-cells-cell").click();

        workExperience_currentTime_click();
        return this;
    }

    //教育经历，月份日历
    public EBFA01Page education_calendar_months(){
        this.findById("vaileducations")
                .findByClassName("ivu-icon-ios-calendar-outline").click();
        this.findById("vaileducations")
                .findByClassName("ivu-date-picker-cells-cell").click();

        this.findById("vaileducations")
                .findByClassName("ivu-checkbox").click();
        return this;
    }

    /*//在点击组件的叉号
    public EBFA01Page component_delete(int n){
        this.findListByXPath("//span[text()=\"x\"]").get(n).click();
        return this;
    }*/

    /*//点击组件的icon
    public EBFA01Page component_icon(int n){
        this.findListById("searchFun_ebfa_select_border_div").get(n)
                .findByTagName("img")
                .click();
        return this;
    }*/

    //点击性别，随机选择 男、女
    public EBFA01Page click_sex(int n){
        this.findById("vailsex")
             .findListByClassName("ivu-radio").get(n)
             .click();
        return this;
    }

    /*
    工作经历
     */
    public EBFA01Page inputJob(String str){
        sendInputPlaceholder("请输入职位名称",str);
        return this;
    }

    public EBFA01Page waitResume(String str){
        this.waitFor(30,"//span[text()=\"" + str + "\"]");
        return this;
    }

}
