package com.beilie.test.open.applicants.pages;

import com.beilie.test.open.PublicClass.Public;
import com.beilie.test.seleniums.core.Element;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class EditMyResume extends Public<EditMyResume> {
    String randomStr=Public.generateString(4);

      public EditMyResume editMingpian(){
          this.findByCssSelector("#basicPersonalInfo > div > div > div.information > div").click();
          return this;
      }

      //校验是编辑页
      public EditMyResume checkEdit(){
          String str=this.findByCssSelector("#basicPersonalInfo > div > div > div:nth-child(1) > button").getText();
          String str1=this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div > div.clearfix > div.fl > div").getText();
          Assert.assertEquals("预览简历",str);
          Assert.assertEquals("职业意向",str1);
          return this;
      }
    //input元素
    public Element element(String str,int i){
        Element element=this.findById(str).findByTagName("form")
                .findListByClassName("formItemName")
                .get(i)
                .findByTagName("input");
        return element;
    }
    //span元素
    public Element element1(String str,int i){
        Element element=this.findById(str).findByTagName("form")
                .findListByClassName("formItemName")
                .get(i)
                .findByTagName("span");
        return element;
    }
    //textarea元素
    public Element element2(String str,int i){
        Element element=this.findById(str).findByTagName("form")
                .findListByClassName("ivu-form-item")
                .get(i)
                .findByTagName("textarea");
        return element;
    }
    //保存按钮元素
    public Element element3(String str,int i){
        Element element=this.findById(str).findByTagName("form")
                .findListByClassName("ivu-form-item")
                .get(i)
                .findListByTagName("button")
                .get(1);
        return element;
    }
    /*
      工作经历  添加工作经历
       */
      public EditMyResume addWorkExperience(){
          this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.clearfix > div.fr.mb15.addBtns.cursor.font14").click();
          return this;
      }

      String str="workExperience";
    //输入公司名称、职位名称
      public EditMyResume writeWord(int i,String name){
          element(str,i).sendKeys(name);
          return this;
      }
      //点击公司行业、工作地点
      public EditMyResume clickInput(int i){
          element(str,i).click();
          return this;
      }
      //点击任职时间
      public EditMyResume clickWorkingTime(int i,int j){
          this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.color6.font14 > div.edit.borderN.pd20.pt40.bgF7.mb30 > form")
                  .findListByClassName("formItemName")
                  .get(i)
                  .findListByTagName("input").get(j).click();
          return this;
      }
      //入职时间
    public EditMyResume selectEntryTime(){
          this.findByCssSelector("#EFMonthSelector > div > div.ivu-select-dropdown > div > div > div > div:nth-child(2) > div > span:nth-child(1) > em").click();
                                //#EFMonthSelector > div > div.ivu-select-dropdown > div > div > div > div:nth-child(2) > div > span:nth-child(1) > em
          return this;
    }
    //离职时间
    public EditMyResume selectSeparationTime(){
        this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.color6.font14 > div.edit.borderN.pd20.pt40.bgF7.mb30 > form > div:nth-child(6) > div")
                .click();
        //this.findByXPath("//*[@id=\"EFMonthSelector\"]/div/div[2]/div/div/div/div[2]/div/span[12]/em").click();
        //#EFMonthSelector > div > div.ivu-select-dropdown > div > div > div > div:nth-child(2) > div > span:nth-child(12)
        //#bg > div.bg.borderN.pd30.clearfix > div.color6.font14 > div.edit.borderN.pd20.pt40.bgF7.mb30 > form > div:nth-child(6) > div
        return this;
    }
    //工作业绩
    public EditMyResume writeWorkPerformance(String str){
          this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.color6.font14 > div.edit.borderN.pd20.pt40.bgF7.mb30 > form > div:nth-child(7) > div > div > textarea")
                  .sendKeys(str);
          return this;
    }
    //点击保存
    public EditMyResume clickSave(){
          this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.color6.font14 > div.edit.borderN.pd20.pt40.bgF7.mb30 > form > div.fl.pl100.mt20.mb20 > button.formButtons.comfirmBtnHeight40").click();
          return this;
    }
    public EditMyResume ReverseCheck(int i,String str){
        ArrayList<String> arrayList=new ArrayList<String>();
        ArrayList<String> arrayList1=new ArrayList<String>();

        switch (i){
            case 1:
                arrayList1.add("公司名称不能为空");
                arrayList1.add("公司行业不能为空");
                arrayList1.add("职位名称不能为空");
                arrayList1.add("工作地点不能为空");
                arrayList1.add("请填写下属人数,若无下属,请填写0");
                arrayList1.add("入职时间不能为空");
                arrayList1.add("职业业绩不能为空");
                break;
            case 2:
                arrayList1.add("项目名称不能为空");
                arrayList1.add("公司名称不能为空");
                arrayList1.add("职务不能为空");
                arrayList1.add("项目开始时间不能为空");
                arrayList1.add("项目描述不能为空");
                break;
            case 3:
                arrayList1.add("学校不能为空");
                arrayList1.add("专业不能为空");
                arrayList1.add("入校时间不能为空");
                arrayList1.add("学历不能为空");
                break;
            case 4:
                arrayList1.add("培训机构不能为空");
                arrayList1.add("培训课程不能为空");
                arrayList1.add("开始时间不能为空");
                break;
        }

        List<Element> elements=this.findById(str).findByTagName("form").findListByClassName("ivu-form-item");

        for (int j=0;j<arrayList1.size();j++){
            String str1=elements.get(j).findByClassName("ivu-form-item-error-tip").getText();
            arrayList.add(str1);
        }

        for(int j=0;j<arrayList1.size();j++){
            String str2=arrayList.get(j);
            String str3=arrayList1.get(j);

            boolean b=str2.equals(str3);
            Assert.assertTrue(b);
        }
          return this;
    }

    /*
    项目经历
     */
    public EditMyResume addProjectExperience(){
        this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.title.clearfix > div.fr.mb15.addBtns.cursor.font14").click();
        return this;
    }
    String strWork="projectExperience";
    //输入项目名称、公司名称、职务
    public EditMyResume writeWord1(String name,int i){
        element(strWork,i).sendKeys(name);
        return this;
    }
    //点击项目时间
    public EditMyResume clickInput1(int i){
        element(strWork,i).click();
        return this;
    }
    //项目描述
    public EditMyResume writeWord2(String description,int i){
        element2(strWork,i).sendKeys(description);
        return this;
    }
    //点击保存
    public EditMyResume clickSave(int i){
        element3(strWork,i).click();
        return this;
    }

    /*
    点击编辑项
     */
    public EditMyResume clickEditItems(String str){
        this.findById(str)
            .findByClassName("mb15")
            .click();
        return this;
    }
    /*
    教育经历
     */
    String strEducation="educationExperience";
    //学校名称
    public EditMyResume writeEducationWords(int i){
        element(strEducation,i).sendKeys("南京"+randomStr+"大学");
        return this;
    }
    //专业名称
    public EditMyResume writeEducationWords(String name,int i){
        element(strEducation,i).sendKeys(name);
        return this;
    }
    //就读时间
    public EditMyResume clickEducationInput(int i){
        element(strEducation,i).click();
        return this;
    }
    //学历
    public EditMyResume clickEducationInput1(int i){
        element1(strEducation,i).click();
        return this;
    }
    public EditMyResume degreeBachelor() {
        this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.color6.font14 > div.edit.borderN.pd30.bgF7.mb20.clearfix > form > div.formItemName.fl.mb0.ivu-form-item.ivu-form-item-required > div > div > div.ivu-select-dropdown > ul.ivu-select-dropdown-list > li:nth-child(7)").click();
        return this;
    }
    //点击保存
    public EditMyResume clickEducationSave(){
        this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.color6.font14 > div.edit.borderN.pd30.bgF7.mb20.clearfix > form > div.fl.pl100.mt10 > button.formButtons.comfirmBtnHeight40").click();
        return this;
    }

    //校验提示内容
    public EditMyResume checkEducationPrompt(){
        String str=this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-header > span").getText();
        Assert.assertEquals("已经存在相同的教育经历。",str);
        return this;
    }

    /*
    培训经历
     */
    String strTraining="trainingExperience";
    //培训机构、培训课程
    public EditMyResume writeTrainingWords(String name,int i){
        element(strTraining,i).sendKeys(name);
        return this;
    }
    //培训时间
    public EditMyResume clickTrainingInput(int i){
        element(strTraining,i).click();
        return this;
    }
    public EditMyResume writeTrainingWords(int i){
        element2(strTraining,i).sendKeys("由老师一对一教学java课程");
        return this;
    }

    //保存
    public EditMyResume clickTrainingSave(){
        this.findByCssSelector("#bg > div.bg.borderN.pd30.clearfix > div.color6.font14 > div.edit.borderN.pd20.bgF7.pt40.mb20 > form > div.fl.pl100.mt20.mb20 > button.formButtons.comfirmBtnHeight40").click();
        return this;
    }

    /*
    删除
     */

    public EditMyResume deleteItems(String id){
        List<Element> elements=this.findById(id).findByClassName("color6")
                .findListByClassName("mt10");
        if (CollectionUtils.isEmpty(elements)){
            return this;
        }else{
            elements.get(0).findByClassName("color9").hover();
            elements.get(0).findByClassName("editIconSmall").click();
        }
        return this;
    }

    public EditMyResume deleteItems1(String id){
        List<Element> elements=this.findListByXPath("//*[@id=\"bg\"]/div[1]/div[2]/div/child::div");
                                                                     ////*[@id="bg"]/div[1]/div[2]/div
        if (CollectionUtils.isEmpty(elements)){
            return this;
        }else{
            elements.get(0).findByClassName("color9").hover();
            elements.get(0).findByClassName("editIconSmall").click();
        }
        return this;
    }
    public EditMyResume deleteItems2(String id){
        List<Element> elements=this.findById(id).findByClassName("color6")
                .findListByClassName("mt10");
        if (CollectionUtils.isEmpty(elements)){
            return this;
        }else{
            elements.get(0).findByClassName("ivu-col-span-5").hover();
            elements.get(0).findByClassName("editIconSmall").click();
        }
        return this;
    }

    //删除工作经历
    public EditMyResume clickConfirm(){
        this.findByCssSelector("body > div:nth-child(8) > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div > button.formButtons.saveBtns.mt40.mb20").click();
        return this;
    }
    public EditMyResume checkPrompt(){
        String str=this.findByCssSelector("#ef-model-confirm > div.ef-model-confirm-header > span").getText();
        Assert.assertEquals("删除工作经历成功。",str);
        return this;
    }
    //删除项目经历
    public EditMyResume clickProjectExperienceConfirm(){
       this.findByXPath("/html/body/div[4]/div[2]/div/div/div[2]/div/button[2]").click();
        //this.findByXPath("/html/body/div["+str+"]/div[2]/div/div/div[2]/div/button[2]").click();
        return this;
    }
    //删除教育经历
    public EditMyResume clickEducationExperienceConfirm(){
        this.findByXPath("/html/body/div[5]/div[2]/div/div/div[2]/div/button[2]").click();
        return this;
    }
    //删除培训经历
    public EditMyResume clickTrainingExperienceConfirm(){
        this.findByXPath("/html/body/div[6]/div[2]/div/div/div[2]/div/button[2]").click();

        //this.findByCssSelector("body > div:nth-child(10) > div.ivu-modal-wrap > div > div > div.ivu-modal-body > div > button.formButtons.saveBtns.mt40.mb20").click();
        return this;
    }

    public EditMyResume clickPreview(){
        this.findByCssSelector("#basicPersonalInfo > div > div > div:nth-child(1) > button").click();
        return this;
    }



}