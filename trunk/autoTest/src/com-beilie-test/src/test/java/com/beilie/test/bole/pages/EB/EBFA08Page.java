package com.beilie.test.bole.pages.EB;

import com.beilie.test.bole.core.Common;
import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;

import java.util.List;

//EBFA08人选详情
public class EBFA08Page extends Common<EBFA08Page> {
    /*
    获取手机号
     */
    public String getMobile(){
        String mobile=this.findById("peopleInfos").findListByClassName("ml20").get(1)
                .findByTagName("span").getText();
        return mobile;
    }

    /*
    关闭页面
     */
    public EBFA08Page closePage(){
        this.findByXPath("//img[@alt=\"关闭\"]").click();
        return this;
    }

    public EBFA08Page checkCardInform(List<String> list){
        for (int i=0;i<list.size();i++){
            String str=list.get(i);
            String value=this.findByXPath("//*[@id=\"peopleInfos\"]//span[text()=\""+str+"\"]").getText();
            Assert.assertEquals(value,str);
        }

        return this;
    }

    public EBFA08Page checkCardInform_contract(String name,String phone,String mailbox){
        this.findByXPath("//*[@id=\"peopleInfos\"]//div[text()=\""+name+"\"]").getText();
        this.findByXPath("//*[@id=\"peopleInfos\"]//strong[text()=\""+phone+"\"]").getText();
        this.findByXPath("//*[@id=\"peopleInfos\"]//span[text()=\""+mailbox+"\"]").getText();

        return this;
    }

    /*
    核对人选信息卡片 目前工作
     */
    public EBFA08Page checkBigcardInform(List<String> list,String currentSalary){
        /*
        目前公司名称、职位、职能
         */
        for (int i=0;i<list.size()-1;i++){
            String str=list.get(i);
            String value=this.findByXPath("//div[text()=\"目前工作：\"]/following-sibling::div//span[text()=\""+str+"\"]").getText();
            Assert.assertEquals(value,str);
        }

        /*
        目前薪资
         */
        String getSalary=this.findByXPath("//div[text()=\"目前工作：\"]/following-sibling::div/span[5]/span[2]").getText();
        String salary=getSalary.split("万")[0];
        double salary_numb=Double.parseDouble(salary);
        double x=salary_numb*10000;
        int y=(int)x;

        String salary_str=Integer.toString(y);
        Assert.assertEquals(salary_str,currentSalary);

        /*
        目前行业
         */
        String jobName=list.get(1);
        String industry_value=this.findByXPath("//div[text()=\"目前工作：\"]/following-sibling::div//span[text()=\""+jobName+"\"]/parent::span/following-sibling::span/span[2]").getText();
        String actualIndustry_value=list.get(3);
        Assert.assertEquals(industry_value,actualIndustry_value);
        return this;
    }

    /*
    核对人选信息卡片 目前工作
     */
    public EBFA08Page checkBigcardInform_education(List<String> list){
        /*
        教育信息，学校、专业
         */
        for (int i=0;i<list.size();i++){
            String str=list.get(i);
            this.findByXPath("//div[text()=\"教育信息：\"]/following-sibling::div//span[text()=\""+str+"\"]").getText();//获取到 教育信息值，就验证成功
        }

        return this;
    }

    //校对简历详情里的 性别、年龄、现居住地
    public EBFA08Page checkResume_personalInform(List<String> list_1,List<String> list){
        for (int i=0;i<list.size();i++){
           String a=this.findByXPath("//span[text()=\""+list_1.get(i)+"\"]/following-sibling::span[text()=\""+list.get(i)+"\"]")
                   .getText();//获取到 性别、年龄、现居住地，就验证成功
           }


        return this;
    }

    //校对简历详情里的 电话、性别、年龄、现居住地、邮箱
    public EBFA08Page checkResume_allPersonalInform(List<String> list_1,List<String> list,String phone){
        this.findByXPath("//span[text()=\"联系电话：\"]/following-sibling::span/strong[text()=\""+phone+"\"]").getText();//获取到 手机，就验证成功
        for (int i=0;i<list.size();i++){
            String a=this.findByXPath("//span[text()=\""+list_1.get(i)+"\"]/following-sibling::span[text()=\""+list.get(i)+"\"]").getText();//获取到 性别、年龄、现居住地、邮箱，就验证成功
            String str=a;
        }
        return this;
    }

    //校对简历详情里的 个人简评
    public EBFA08Page checkResume_personalIntroduce(String actualPersonalIntroduce){
        String personalIntroduce=this.findByXPath("//div[@class=\"c3 pl35 text-break ivu-col ivu-col-span-24\"]").getText();
        Assert.assertEquals(personalIntroduce,actualPersonalIntroduce);

        return this;
    }

    //校对简历详情里的 项目内容
    public EBFA08Page checkResume_project(String actualProject){
        String project=span_parentDiv_followingGetDiv("项目经历");
        Assert.assertEquals(project,actualProject);

        return this;
    }

    //校对简历详情里的 工作经历，公司名称、职位名称、职能、地点、行业、薪资
    public EBFA08Page checkResume_workExperience(List<String> list,String actualIndustry_value,String actualcurrentSalary){
        //公司名称、职位名称、职能、地点
        for (int i=0;i<list.size();i++){
            String str=list.get(i);
            String value=this.findByXPath("//span[text()=\"工作经历\"]/parent::div/following-sibling::div//span[text()=\""+str+"\"]").getText();
            }

       //行业
        String industry_value=span_followingGetSpan("公司行业：");
        Assert.assertEquals(industry_value,actualIndustry_value);

        //薪资
        String getSalary=span_followingGetSpan("目前年薪：").split("元")[0];
        Assert.assertEquals(getSalary,actualcurrentSalary);

        return this;
    }

    //校对简历详情里的 学校名称、专业名称
    public EBFA08Page checkResume_education(String colleage,String major){
        //获取到 学校名称、专业名称，就验证成功
        this.Span_Value(colleage);
        this.Span_Value(major);

        return this;
    }

    //校对简历详情里的 附加信息
    public EBFA08Page checkResume_addInform(String addInform){
       this.div_getValue(addInform);//获取到 附加信息值，就验证成功

        return this;
    }

    //点击  打开推荐报告页面
    public EBFA08Page click_Recommend(){
        this.findByClassName("clickIdClass").click();
        return this;
    }

    //获取页面框架上的消息
    public String value_efpage(){
        String value=this.findByClassName(" messageContent").getText();
        return value;
    }

    /*
    推荐报告栏
     */
    //绑定报告按钮置灰
    public EBFA08Page checkBindBtn(){
        String btn_class=this.findByXPath("//span[text()=\"绑定报告\"]/parent::button").getAttribute("class");
        Assert.assertEquals("currency_btn_size disabled_btn_bgbf ivu-btn ivu-btn-default",btn_class);
        return this;
    }
    //核对推荐职位
    public EBFA08Page checkRecommendJob(){
        String recommendJob=this.findByClassName("contentListInfo")
                .findListByTagName("p").get(1)
                .findByTagName("span")
                .getText();
        Assert.assertEquals("卖麦芽糖的",recommendJob);
        return this;
    }

    //点击“生成推荐报告”
    public EBFA08Page recommndReport_click(){
this.findByClassName("newBtnDiv")
.findByTagName("li").click()
        ;
       return this;
    }


}
