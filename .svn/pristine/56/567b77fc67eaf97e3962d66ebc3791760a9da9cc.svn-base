package com.beilie.test.bole.pages.EB;

import com.beilie.test.open.PublicClass.Public;
import org.junit.Assert;
import java.util.List;
//人才推荐报告页面
public class EB0301Page extends Public<EB0301Page> {
    public EB0301Page checkResume(List<String> list_1, List<String> list){
        for (int i=0;i<list_1.size();i++){
            String str=list_1.get(i);
            String value=this.findByXPath("//i[text()=\""+str+"\"]/following-sibling::span").getText();
            String actual_value=list.get(i);
            Assert.assertEquals(value,actual_value);
        }

        return this;
    }

    //校对推荐报告里的 个人信息
    public EB0301Page checkRecommendation_personalInfor(List<String> list_1, List<String> list){
            String str=list_1.get(0);
            String value=this.findByXPath("//i[text()=\""+str+"\"]/following-sibling::span").getText();
            String actual_value=list.get(0);
            Assert.assertEquals(value,actual_value);

            String location_str=list_1.get(1);
            String location_value=this.findByXPath("//i[text()=\""+location_str+"\"]/following-sibling::span").getText();
            String actualValue=list.get(1);
            actualValue.startsWith(location_value);
        return this;
    }

    //在“EB0301”页面，校对 人选信息的姓名、性别、现居住地、电话、邮箱
    public EB0301Page checkRecommendation_AllpersonalInfor(List<String> list, List<String> list_1,String location){
        for (int i=0;i<list.size();i++){
            String str=list.get(i);
            String value=this.findByXPath("//i[text()=\""+list.get(i)+"\"]/following-sibling::span").getText();
            String actual_value=list_1.get(i);
            Assert.assertEquals(value,actual_value);
        }

        String check_location=this.findByXPath("//i[text()=\""+"现居住地："+"\"]/following-sibling::span").getText();
        boolean b=check_location.contains(location);
        Assert.assertTrue(b);
        return this;
    }

    //校对推荐报告里的 个人简介
    public EB0301Page checkRecommendation_personalIntroduce(String str){
        //获取到 个人简介的值，就验证成功
        String value=this.findByXPath("//p[text()=\""+str+"\"]/following-sibling::div/div").getText();
        return this;
    }

    //校对推荐报告里的 工作经验
    public EB0301Page checkRecommendation_workExperience(String actualCompanyName,String jobName,String jobContent,String currentSalary){
        String getcompanyName=this.findByXPath("//p[text()=\"工作经验\"]/following-sibling::div//span/preceding-sibling::div").getText();
        Assert.assertEquals(getcompanyName,actualCompanyName);//公司名称

        this.findByXPath("//p[text()=\"工作经验\"]/following-sibling::div//span[text()=\""+jobName+"\"]");//职位
        this.findByXPath("//p[text()=\"工作经验\"]/following-sibling::div//span[text()=\""+jobContent+"\"]");//工作内容

        String getSalary=this.findByXPath("//i[text()=\"目前薪资：\"]/following-sibling::span").getText();
        Assert.assertEquals(getSalary,currentSalary);//校对目前薪资
        return this;
    }

    //校对推荐报告里的 项目经历
    public EB0301Page checkRecommendation_project(String str){
        this.div_getValue(str);//获取到 项目经历的值，就验证成功
        return this;
    }

    //校对推荐报告里的 教育经历
    public EB0301Page checkRecommendation_education(String colleage,String major){
        //获取到 学校名称、专业名称的值，就验证成功
        String education=this.findByXPath("//p[text()=\"教育经历\"]/following-sibling::div").getText();
        education.contains(colleage);
        education.contains(major);

        return this;
    }

    //校对推荐报告里的 附加信息
    public EB0301Page checkRecommendation_addInform(String str){
        this.div_getValue(str);//获取到 附加信息的值，就验证成功

        return this;
    }


}
